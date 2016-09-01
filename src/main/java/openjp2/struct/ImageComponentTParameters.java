package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class ImageComponentTParameters extends Structure {
    /**
     * XRsiz: horizontal separation of a sample of ith component with respect to the reference grid<br>
     * C type : OPJ_UINT32
     */
    public int dx;
    /**
     * YRsiz: vertical separation of a sample of ith component with respect to the reference grid<br>
     * C type : OPJ_UINT32
     */
    public int dy;
    /**
     * data width<br>
     * C type : OPJ_UINT32
     */
    public int w;
    /**
     * data height<br>
     * C type : OPJ_UINT32
     */
    public int h;
    /**
     * x component offset compared to the whole image<br>
     * C type : OPJ_UINT32
     */
    public int x0;
    /**
     * y component offset compared to the whole image<br>
     * C type : OPJ_UINT32
     */
    public int y0;
    /**
     * precision<br>
     * C type : OPJ_UINT32
     */
    public int prec;
    /**
     * image depth in bits<br>
     * C type : OPJ_UINT32
     */
    public int bpp;
    /**
     * signed (1) / unsigned (0)<br>
     * C type : OPJ_UINT32
     */
    public int sgnd;

    public ImageComponentTParameters() {
        super();
    }
    /**
     * @param dx XRsiz: horizontal separation of a sample of ith component with respect to the reference grid<br>
     * C type : OPJ_UINT32<br>
     * @param dy YRsiz: vertical separation of a sample of ith component with respect to the reference grid<br>
     * C type : OPJ_UINT32<br>
     * @param w data width<br>
     * C type : OPJ_UINT32<br>
     * @param h data height<br>
     * C type : OPJ_UINT32<br>
     * @param x0 x component offset compared to the whole image<br>
     * C type : OPJ_UINT32<br>
     * @param y0 y component offset compared to the whole image<br>
     * C type : OPJ_UINT32<br>
     * @param prec precision<br>
     * C type : OPJ_UINT32<br>
     * @param bpp image depth in bits<br>
     * C type : OPJ_UINT32<br>
     * @param sgnd signed (1) / unsigned (0)<br>
     * C type : OPJ_UINT32
     */
    public ImageComponentTParameters(int dx, int dy, int w, int h, int x0, int y0, int prec, int bpp, int sgnd) {
        super();
        this.dx = dx;
        this.dy = dy;
        this.w = w;
        this.h = h;
        this.x0 = x0;
        this.y0 = y0;
        this.prec = prec;
        this.bpp = bpp;
        this.sgnd = sgnd;
    }
    public ImageComponentTParameters(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("dx", "dy", "w", "h", "x0", "y0", "prec", "bpp", "sgnd");
    }

    public static class ByReference extends ImageComponentTParameters implements Structure.ByReference { }
    public static class ByValue extends ImageComponentTParameters implements Structure.ByValue { }
}
