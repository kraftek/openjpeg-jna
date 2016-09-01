package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DecompressParameters extends Structure {

    public static int OPJ_PATH_LEN = 4096;

    /**
     * core library parameters<br>
     * C type : opj_dparameters_t
     */
    public DParameters.ByReference core;
    /**
     * input file name<br>
     * C type : char[OPJ_PATH_LEN]
     */
    public byte[] infile = new byte[OPJ_PATH_LEN];
    /**
     * output file name<br>
     * C type : char[OPJ_PATH_LEN]
     */
    public byte[] outfile = new byte[OPJ_PATH_LEN];
    /** input file format 0: J2K, 1: JP2, 2: JPT */
    public int decod_format;
    /** output file format 0: PGX, 1: PxM, 2: BMP */
    public int cod_format;
    /**
     * index file name<br>
     * C type : char[OPJ_PATH_LEN]
     */
    public byte[] indexfilename = new byte[OPJ_PATH_LEN];
    /**
     * Decoding area left boundary<br>
     * C type : OPJ_UINT32
     */
    public int DA_x0;
    /**
     * Decoding area right boundary<br>
     * C type : OPJ_UINT32
     */
    public int DA_x1;
    /**
     * Decoding area up boundary<br>
     * C type : OPJ_UINT32
     */
    public int DA_y0;
    /**
     * Decoding area bottom boundary<br>
     * C type : OPJ_UINT32
     */
    public int DA_y1;
    /**
     * Verbose mode<br>
     * C type : OPJ_BOOL
     */
    public byte m_verbose;
    /**
     * tile number ot the decoded tile<br>
     * C type : OPJ_UINT32
     */
    public int tile_index;
    /**
     * Nb of tile to decode<br>
     * C type : OPJ_UINT32
     */
    public int nb_tile_to_decode;
    /** C type : opj_precision* */
    public Precision.ByReference precision;
    /** C type : OPJ_UINT32 */
    public int nb_precision;
    /** force output colorspace to RGB */
    public int force_rgb;
    /** upsample components according to their dx/dy values */
    public int upsample;
    /** split output components to different files */
    public int split_pnm;

    public DecompressParameters() {
        super();
        core = new DParameters.ByReference();
        precision = new Precision.ByReference();
    }
    public DecompressParameters(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("core", "infile", "outfile", "decod_format", "cod_format", "indexfilename", "DA_x0", "DA_x1", "DA_y0", "DA_y1", "m_verbose", "tile_index", "nb_tile_to_decode", "precision", "nb_precision", "force_rgb", "upsample", "split_pnm");
    }

    public static class ByReference extends DecompressParameters implements Structure.ByReference { }
    public static class ByValue extends DecompressParameters implements Structure.ByValue { }
}
