package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class ImageFolder extends Structure {
    /**
     * The directory path of the folder containing input images<br>
     * C type : char*
     */
    public Pointer imgdirpath;
    /**
     * Output format<br>
     * C type : const char*
     */
    public Pointer out_format;
    /** Enable option */
    public byte set_imgdir;
    /** Enable Cod Format for output */
    public byte set_out_format;

    public ImageFolder() {
        super();
    }
    /**
     * @param imgdirpath The directory path of the folder containing input images<br>
     * C type : char*<br>
     * @param out_format Output format<br>
     * C type : const char*<br>
     * @param set_imgdir Enable option<br>
     * @param set_out_format Enable Cod Format for output
     */
    public ImageFolder(Pointer imgdirpath, Pointer out_format, byte set_imgdir, byte set_out_format) {
        super();
        this.imgdirpath = imgdirpath;
        this.out_format = out_format;
        this.set_imgdir = set_imgdir;
        this.set_out_format = set_out_format;
    }
    public ImageFolder(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("imgdirpath", "out_format", "set_imgdir", "set_out_format");
    }

    public static class ByReference extends ImageFolder implements Structure.ByReference { }
    public static class ByValue extends ImageFolder implements Structure.ByValue { }
}
