package openjp2.enums;

/**
 * Created by kraftek on 9/1/2016.
 */
public interface ColorSpace {
    /**
     * < not supported by the library
     */
     int OPJ_CLRSPC_UNKNOWN = -1;
    /**
     * < not specified in the codestream
     */
     int OPJ_CLRSPC_UNSPECIFIED = 0;
    /**
     * < sRGB
     */
     int OPJ_CLRSPC_SRGB = 1;
    /**
     * < grayscale
     */
     int OPJ_CLRSPC_GRAY = 2;
    /**
     * < YUV
     */
     int OPJ_CLRSPC_SYCC = 3;
    /**
     * < e-YCC
     */
     int OPJ_CLRSPC_EYCC = 4;
    /**
     * < CMYK
     */
     int OPJ_CLRSPC_CMYK = 5;
}
