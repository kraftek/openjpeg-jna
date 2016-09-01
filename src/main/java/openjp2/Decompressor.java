package openjp2;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import openjp2.callback.Callbacks;
import openjp2.enums.CodecFormat;
import openjp2.enums.ColorSpace;
import openjp2.library.Constants;
import openjp2.library.OpenJp2Wrapper;
import openjp2.struct.*;
import openjp2.struct.Image;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kraftek on 8/17/2016.
 */
public class Decompressor {
    private static final Map<String, Integer> extensions;

    static {
        extensions = new HashMap<String, Integer>() {{
            put("pgx", 11);
            put("pnm", 10);
            put("pgm", 10);
            put("ppm", 10);
            put("bmp", 12);
            put("tif", 14);
            put("raw", 15);
            put("rawl", 18);
            put("tga", 16);
            put("png", 17);
            put("j2k", 0);
            put("jp2", 1);
            put("jpt", 2);
            put("j2c", 0);
            put("jpc", 0);
        }};
    }

    public static void main(String[] args) {
        Decompressor decompress = new Decompressor();
        File input = new File("E:\\Imagery\\czeck_one_tile\\S2A_OPER_PRD_MSIL1C_PDMC_20160318T235357_R022_V20150803T101010_20150803T101010.SAFE\\GRANULE\\S2A_OPER_MSI_L1C_TL_EPA__20160318T190052_A000591_T32UQU_N02.01\\IMG_DATA\\S2A_OPER_MSI_L1C_TL_EPA__20160318T190052_A000591_T32UQU_B02.jp2");
        File output = new File("E:\\Imagery\\Jpeg2000\\output.pgx");
        decompress.decompress(input, output, 0, 20, -1, 3, null);
        /*Map<String, String> arguments = new HashMap<String, String>();
        arguments.put("r", "3");
        arguments.put("l", "20");
        arguments.put("t", "1");
        arguments.put("p", "8");
        decompress.decompress(input, output, arguments);*/
    }

    public void decompress(File inputFile, File outputFile, int resolution, int level, int forcedPrecision, int tileIndex) {
        decompress(inputFile, outputFile, resolution, level, forcedPrecision, tileIndex, null);
    }

    public void decompress(File inputFile, File outputFile, int resolution, int level, int forcedPrecision) {
        decompress(inputFile, outputFile, resolution, level, forcedPrecision, -1, null);
    }

    public void decompress(File inputFile, File outputFile, int resolution, int level, int forcedPrecision, int tileIndex, Rectangle roi) {
        Map<String, String> arguments = new HashMap<String, String>();
        arguments.put("r", String.valueOf(resolution));
        arguments.put("l", String.valueOf(level));
        if (tileIndex >= 0) {
            arguments.put("t", String.valueOf(tileIndex));
        }
        if (forcedPrecision > 0) {
            arguments.put("p", String.valueOf(forcedPrecision));
        }
        if (roi != null) {
            arguments.put("d", String.valueOf(roi.x) + "," + String.valueOf(roi.y) + "," +
                    String.valueOf(roi.x + roi.width) + "," + String.valueOf(roi.y + roi.height));
        }
        decompress(inputFile, outputFile, arguments);
    }

    private void decompress(File inputFile, File outputFile, Map<String, String> args) {

        DecompressParameters params = new DecompressParameters();
        params.decod_format = -1;
        params.cod_format = -1;
        OpenJp2Wrapper.opj_set_default_decoder_parameters(params.core);
        params.decod_format = getFileFormat(inputFile);
        params.cod_format = getFileFormat(outputFile);

        if (args != null) {
            if (args.containsKey("r")) {
                params.core.cp_reduce = Integer.parseInt(args.get("r"));
            }
            if (args.containsKey("l")) {
                params.core.cp_layer = Integer.parseInt(args.get("l"));
            }
            if (args.containsKey("d")) {
                String[] roiValues = args.get("d").split(",");
                if (roiValues.length != 4) {
                    throw new IllegalArgumentException("ROI values are incorrect");
                }
                params.DA_x0 = Integer.parseInt(roiValues[0]);
                params.DA_y0 = Integer.parseInt(roiValues[1]);
                params.DA_x1 = Integer.parseInt(roiValues[2]);
                params.DA_y1 = Integer.parseInt(roiValues[3]);
            }
            if (args.containsKey("t")) {
                params.tile_index = Integer.parseInt(args.get("t"));
                params.nb_tile_to_decode = 1;
            }
        }

        PointerByReference l_stream = OpenJp2Wrapper.opj_stream_create_default_file_stream(inputFile.getAbsolutePath(), Constants.OPJ_STREAM_READ);
        if (l_stream == null || l_stream.getValue() == null) {
            throw new RuntimeException("Failed to create the stream from the file");
        }

        Codec l_codec;

        switch (params.decod_format) {
            case 0: // JPEG-2000 codestream
                l_codec = OpenJp2Wrapper.opj_create_decompress(CodecFormat.OPJ_CODEC_J2K);
                break;
            case 1: // JPEG-2000 compressed data
                l_codec = OpenJp2Wrapper.opj_create_decompress(CodecFormat.OPJ_CODEC_JP2);
                break;
            case 2:
                l_codec = OpenJp2Wrapper.opj_create_decompress(CodecFormat.OPJ_CODEC_JPT);
                break;
            default:
                OpenJp2Wrapper.opj_stream_destroy(l_stream);
                throw new RuntimeException("File is not coded with JPEG-2000");
        }

        Callbacks.MessageFunction callback = (msg, client_data) -> System.out.println(msg.getString(0));
        OpenJp2Wrapper.opj_set_info_handler(l_codec, callback, null);
        OpenJp2Wrapper.opj_set_warning_handler(l_codec, null, null);
        OpenJp2Wrapper.opj_set_error_handler(l_codec, null, null);

        int setupDecoder = OpenJp2Wrapper.opj_setup_decoder(l_codec, params.core);
        if (setupDecoder == 0) {
            OpenJp2Wrapper.opj_destroy_codec(l_codec);
            OpenJp2Wrapper.opj_stream_destroy(l_stream);
            throw new RuntimeException("Failed to setup decoder");
        }

        PointerByReference pImage = new PointerByReference();
        OpenJp2Wrapper.opj_read_header(l_stream, l_codec, pImage);
        Image image = new Image(pImage.getValue());
        image.read();
        if (params.nb_tile_to_decode == 0) {
            if (OpenJp2Wrapper.opj_set_decode_area(l_codec, image, params.DA_x0, params.DA_y0, params.DA_x1, params.DA_y1) == 0) {
                OpenJp2Wrapper.opj_destroy_codec(l_codec);
                OpenJp2Wrapper.opj_stream_destroy(l_stream);
                OpenJp2Wrapper.opj_image_destroy(pImage);
                throw new RuntimeException("Failed to set the decoded area");
            }
            if (OpenJp2Wrapper.opj_decode(l_codec, l_stream, image) == 0 &&
                    OpenJp2Wrapper.opj_end_decompress(l_codec, l_stream) != 0) {
                OpenJp2Wrapper.opj_destroy_codec(l_codec);
                OpenJp2Wrapper.opj_stream_destroy(l_stream);
                OpenJp2Wrapper.opj_image_destroy(pImage);
                throw new RuntimeException("Failed to decode image");
            }
        } else {
            if (OpenJp2Wrapper.opj_get_decoded_tile(l_codec, l_stream, image, params.tile_index) == 0) {
                OpenJp2Wrapper.opj_destroy_codec(l_codec);
                OpenJp2Wrapper.opj_stream_destroy(l_stream);
                OpenJp2Wrapper.opj_image_destroy(pImage);
                throw new RuntimeException("Failed to decode tile");
            }
        }
        OpenJp2Wrapper.opj_stream_destroy(l_stream);
        Image image1 = new Image(pImage.getValue());
        image1.read();
        ImageComponent[] comps = (ImageComponent[])image1.comps.toArray(image1.numcomps);
        if (image1.color_space != ColorSpace.OPJ_CLRSPC_SYCC &&
                image1.numcomps == 3 && comps[0].dx == comps[0].dy &&
                comps[1].dx != 1){
            image1.color_space = ColorSpace.OPJ_CLRSPC_SYCC;
        } else if (image1.numcomps <= 2) {
            image1.color_space = ColorSpace.OPJ_CLRSPC_GRAY;
        }
        if (image1.color_space == ColorSpace.OPJ_CLRSPC_SYCC) {
            // color_sycc_to_rgb(image);
        } else if (image1.color_space == ColorSpace.OPJ_CLRSPC_CMYK
                && params.cod_format != 14 /* TIF_DFMT */) {
            // color_cmyk_to_rgb(image);
        } else if (image1.color_space == ColorSpace.OPJ_CLRSPC_EYCC) {
            // color_esycc_to_rgb(image);
        }
        int[] array = comps[0].data.getPointer().getIntArray(0, comps[0].w * comps[0].h);
        System.out.println(array.length);
    }

    private int getFileFormat(File file) {
        if (file == null) {
            return -1;
        }
        String ext = file.getName().substring(file.getName().lastIndexOf("."));
        if (ext.isEmpty()) {
            return -1;
        }
        ext = ext.toLowerCase().replace(".", "");
        Integer code = extensions.get(ext);
        return code != null ? code : -1;
    }
}
