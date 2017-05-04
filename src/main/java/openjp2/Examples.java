package openjp2;

import openjp2.library.OpenJp2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Cosmin Cara
 */
public class Examples {

    public static void main(String[] args) throws Exception {
        String osName = System.getProperty("os.name").toLowerCase();
        String path = null;
        if (osName.contains("windows")) {
            path = "win64/libopenjp2.dll";
        } else if (osName.contains("linux")) {
            path = "linux64/libopenjp2.so";
        } else if (osName.contains("mac")) {
            path = "macosx/libopenjp2.dylib";
        } else {
            throw new RuntimeException("Unsupported OS");
        }
        Path libPath = new File(Examples.class.getClassLoader().getResource(path).getFile()).toPath();
        registerLibrary(libPath);
        /*
        Raster decoded = decode(path of jp2 file);
        */
        /*
        BufferedImage image = ImageIO.read(path to file);
        encode(image);
        */
    }

    public static Raster decode(Path jp2File) throws IOException {
        Path workingFolder = Files.createTempDirectory("openjp2_decode");
        Raster uncompressedTile = null;
        try (OpenJP2Decoder decoder = new OpenJP2Decoder(workingFolder,
                                                         jp2File, 0,
                                                         DataBuffer.TYPE_INT, 0,
                                                         20, 0)) {
            uncompressedTile = decoder.read();
        }
        return uncompressedTile;
    }

    public static void encode(RenderedImage source) throws Exception {
        Path workingFolder = Files.createTempDirectory("openjp2_encode");
        try (OpenJP2Encoder encoder = new OpenJP2Encoder(source)) {
            Path target = workingFolder.resolve("encoded.jp2");
            encoder.write(target, 0);
        }
    }

    private static void registerLibrary(Path openJp2Path) {
        OpenJp2.registerLibrary(openJp2Path);
    }

}
