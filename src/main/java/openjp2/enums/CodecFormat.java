package openjp2.enums;

/**
 * Created by kraftek on 9/1/2016.
 */
public interface CodecFormat {
    /**
     * < place-holder
     */
     int OPJ_CODEC_UNKNOWN = -1;
    /**
     * < JPEG-2000 codestream : read/write
     */
     int OPJ_CODEC_J2K = 0;
    /**
     * < JPT-stream (JPEG 2000, JPIP) : read only
     */
     int OPJ_CODEC_JPT = 1;
    /**
     * < JP2 file format : read/write
     */
     int OPJ_CODEC_JP2 = 2;
    /**
     * < JPP-stream (JPEG 2000, JPIP) : to be coded
     */
     int OPJ_CODEC_JPP = 3;
    /**
     * < JPX file format (JPEG 2000 Part-2) : to be coded
     */
     int OPJ_CODEC_JPX = 4;
}
