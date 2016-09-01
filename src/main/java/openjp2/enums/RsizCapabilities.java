package openjp2.enums;

/**
 * Created by kraftek on 9/1/2016.
 */
public interface RsizCapabilities {
    /**
     * Standard JPEG2000 profile
     */
    int OPJ_STD_RSIZ = 0;
    /**
     * Profile name for a 2K image
     */
    int OPJ_CINEMA2K = 3;
    /**
     * Profile name for a 4K image
     */
    int OPJ_CINEMA4K = 4;

    int OPJ_MCT = 0x8100;
};
