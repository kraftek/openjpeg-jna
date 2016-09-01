package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

import java.util.Arrays;
import java.util.List;

public class Image extends Structure {
    /**
     * XOsiz: horizontal offset from the origin of the reference grid to the left side of the image area
     * C type : OPJ_UINT32
     */
    public int x0;
    /**
     * YOsiz: vertical offset from the origin of the reference grid to the top side of the image area
     * C type : OPJ_UINT32
     */
    public int y0;
    /**
     * Xsiz: width of the reference grid
     * C type : OPJ_UINT32
     */
    public int x1;
    /**
     * Ysiz: height of the reference grid
     * C type : OPJ_UINT32
     */
    public int y1;
    /**
     * number of components in the image
     * C type : OPJ_UINT32
     */
    public int numcomps;
    /**
     * color space: sRGB, Greyscale or YUV
     * C type : OPJ_COLOR_SPACE
     */
    public int color_space;
    /**
     * image components
     * C type : opj_image_comp_t*
     */
    public ImageComponent.ByReference comps;
    /**
     * 'restricted' ICC profile
     * C type : OPJ_BYTE*
     */
    public ByteByReference icc_profile_buf;
    /**
     * size of ICC profile
     * C type : OPJ_UINT32
     */
    public int icc_profile_len;

    public Image() {
        super();
        comps = new ImageComponent.ByReference();
    }
    /**
     * @param x0 XOsiz: horizontal offset from the origin of the reference grid to the left side of the image area
     * C type : OPJ_UINT32
     * @param y0 YOsiz: vertical offset from the origin of the reference grid to the top side of the image area
     * C type : OPJ_UINT32
     * @param x1 Xsiz: width of the reference grid
     * C type : OPJ_UINT32
     * @param y1 Ysiz: height of the reference grid
     * C type : OPJ_UINT32
     * @param numcomps number of components in the image
     * C type : OPJ_UINT32
     * @param color_space color space: sRGB, Greyscale or YUV
     * C type : OPJ_COLOR_SPACE
     * @param comps image components
     * C type : opj_image_comp_t*
     * @param icc_profile_buf 'restricted' ICC profile
     * C type : OPJ_BYTE*
     * @param icc_profile_len size of ICC profile
     * C type : OPJ_UINT32
     */
    public Image(int x0, int y0, int x1, int y1, int numcomps, int color_space, ImageComponent.ByReference comps, ByteByReference icc_profile_buf, int icc_profile_len) {
        super();
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.numcomps = numcomps;
        this.color_space = color_space;
        this.comps = comps;
        this.icc_profile_buf = icc_profile_buf;
        this.icc_profile_len = icc_profile_len;
    }
    public Image(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("x0", "y0", "x1", "y1", "numcomps", "color_space", "comps", "icc_profile_buf", "icc_profile_len");
    }
    
    public static class ByReference extends Image implements Structure.ByReference { }
    public static class ByValue extends Image implements Structure.ByValue { }
}
