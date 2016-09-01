package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

public class ImageComponent extends Structure {
    /**
     * XRsiz: horizontal separation of a sample of ith component with respect to the reference grid
     * C type : OPJ_UINT32
     */
    public int dx;
    /**
     * YRsiz: vertical separation of a sample of ith component with respect to the reference grid
     * C type : OPJ_UINT32
     */
    public int dy;
    /**
     * data width
     * C type : OPJ_UINT32
     */
    public int w;
    /**
     * data height
     * C type : OPJ_UINT32
     */
    public int h;
    /**
     * x component offset compared to the whole image
     * C type : OPJ_UINT32
     */
    public int x0;
    /**
     * y component offset compared to the whole image
     * C type : OPJ_UINT32
     */
    public int y0;
    /**
     * precision
     * C type : OPJ_UINT32
     */
    public int prec;
    /**
     * image depth in bits
     * C type : OPJ_UINT32
     */
    public int bpp;
    /**
     * signed (1) / unsigned (0)
     * C type : OPJ_UINT32
     */
    public int sgnd;
    /**
     * number of decoded resolution
     * C type : OPJ_UINT32
     */
    public int resno_decoded;
    /**
     * number of division by 2 of the out image compared to the original size of image
     * C type : OPJ_UINT32
     */
    public int factor;
    /**
     * image component data
     * C type : OPJ_INT32*
     */
    public IntByReference data;
    /**
     * alpha channel
     * C type : OPJ_UINT16
     */
    public short alpha;

    public ImageComponent() {
        super();
        data = new IntByReference();
    }
    public ImageComponent(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("dx", "dy", "w", "h", "x0", "y0", "prec", "bpp", "sgnd", "resno_decoded", "factor", "data", "alpha");
    }

    public static class ByReference extends ImageComponent implements Structure.ByReference { }

    public static class ByValue extends ImageComponent implements Structure.ByValue { }
}
