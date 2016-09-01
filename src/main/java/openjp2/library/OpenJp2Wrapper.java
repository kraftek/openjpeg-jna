package openjp2.library;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import openjp2.struct.Codec;
import openjp2.struct.DParameters;
import openjp2.struct.Image;
import openjp2.struct.ImageComponentTParameters;
import openjp2.types.NativeSize;
import openjp2.callback.Callbacks;

/**
 * JNA Wrapper for library <b>OpenJP2</b>.
 * This file was generated with the help of <a href="http://jnaerator.googlecode.com/">JNAerator</a>.
 */
public class OpenJp2Wrapper implements StdCallLibrary {
    private static final String JNA_LIBRARY_NAME = "openjp2";

    static {
        Native.register(OpenJp2Wrapper.class, JNA_LIBRARY_NAME);
        if (!Native.isProtected()) {
            Native.setProtected(true);
        }
    }

    /**
     * Get the version of the struct library<br>
     * Original signature : <code>char* opj_version()</code><br>
     */
    public static native Pointer opj_version();
    /**
     * Create an image<br>
     * * @param numcmpts      number of components<br>
     * @param cmptparms     components parameters<br>
     * @param clrspc        image color space<br>
     * @return returns      a new image structure if successful, returns NULL otherwise<br>
     * Original signature : <code>opj_image_t* opj_image_create(OPJ_UINT32, opj_image_cmptparm_t*, OPJ_COLOR_SPACE)</code><br>
     */
    public static native Image opj_image_create(int numcmpts, ImageComponentTParameters cmptparms, int clrspc);
    /**
     * Deallocate any resources associated with an image<br>
     * * @param image         image to be destroyed<br>
     * Original signature : <code>void opj_image_destroy(opj_image_t*)</code><br>
     * <i>native declaration : line 1097</i>
     */
    public static native void opj_image_destroy(PointerByReference image);
    /**
     * Creates an image without allocating memory for the image (used in the new version of the library).<br>
     * * @param	numcmpts    the number of components<br>
     * @param	cmptparms   the components parameters<br>
     * @param	clrspc      the image color space<br>
     * * @return	a new image structure if successful, NULL otherwise.<br>
     * Original signature : <code>opj_image_t* opj_image_tile_create(OPJ_UINT32, opj_image_cmptparm_t*, OPJ_COLOR_SPACE)</code><br>
     */
    public static native Image opj_image_tile_create(int numcmpts, ImageComponentTParameters cmptparms, int clrspc);
    /**
     * Creates an abstract stream. This function does nothing except allocating memory and initializing the abstract stream.<br>
     * * @param	p_is_input		if set to true then the stream will be an input stream, an output stream else.<br>
     * * @return	a stream object.<br>
     * Original signature : <code>opj_stream_t* opj_stream_default_create(OPJ_BOOL)</code><br>
     */
    public static native PointerByReference opj_stream_default_create(int p_is_input);
    /**
     * Creates an abstract stream. This function does nothing except allocating memory and initializing the abstract stream.<br>
     * * @param	p_buffer_size  <br>
     * @param	p_is_input		if set to true then the stream will be an input stream, an output stream else.<br>
     * * @return	a stream object.<br>
     * Original signature : <code>opj_stream_t* opj_stream_create(OPJ_SIZE_T, OPJ_BOOL)</code><br>
     */
    public static native PointerByReference opj_stream_create(NativeSize p_buffer_size, int p_is_input);
    /**
     * Destroys a stream created by opj_create_stream. This function does NOT close the abstract stream. If needed the user must<br>
     * close its own implementation of the stream.<br>
     * * @param	p_stream	the stream to destroy.<br>
     * Original signature : <code>void opj_stream_destroy(opj_stream_t*)</code><br>
     */
    public static native void opj_stream_destroy(PointerByReference p_stream);
    /**
     * Sets the given function to be used as a read function.<br>
     * @param		p_stream	the stream to modify<br>
     * @param		p_function	the function to use a read function.<br>
     * Original signature : <code>void opj_stream_set_read_function(opj_stream_t*, StreamReadFunction)</code><br>
     */
    public static native void opj_stream_set_read_function(PointerByReference p_stream, Callbacks.StreamReadFunction p_function);
    /**
     * Sets the given function to be used as a write function.<br>
     * @param		p_stream	the stream to modify<br>
     * @param		p_function	the function to use a write function.<br>
     * Original signature : <code>void opj_stream_set_write_function(opj_stream_t*, StreamWriteFunction)</code><br>
     */
    public static native void opj_stream_set_write_function(PointerByReference p_stream, Callbacks.StreamWriteFunction p_function);
    /**
     * Sets the given function to be used as a skip function.<br>
     * @param		p_stream	the stream to modify<br>
     * @param		p_function	the function to use a skip function.<br>
     * Original signature : <code>void opj_stream_set_skip_function(opj_stream_t*, StreamSkipFunction)</code><br>
     */
    public static native void opj_stream_set_skip_function(PointerByReference p_stream, Callbacks.StreamSkipFunction p_function);
    /**
     * Sets the given function to be used as a seek function, the stream is then seekable.<br>
     * @param		p_stream	the stream to modify<br>
     * @param		p_function	the function to use a skip function.<br>
     * Original signature : <code>void opj_stream_set_seek_function(opj_stream_t*, StreamSeekFunction)</code><br>
     */
    public static native void opj_stream_set_seek_function(PointerByReference p_stream, Callbacks.StreamSeekFunction p_function);
    /**
     * Sets the given data to be used as a user data for the stream.<br>
     * @param		p_stream	the stream to modify<br>
     * @param		p_data		the data to set.<br>
     * @param		p_function	the function to free p_data when opj_stream_destroy() is called.<br>
     * Original signature : <code>void opj_stream_set_user_data(opj_stream_t*, void*, StreamFreeUserDataFunction)</code><br>
     */
    public static native void opj_stream_set_user_data(PointerByReference p_stream, Pointer p_data, Callbacks.StreamFreeUserDataFunction p_function);
    /**
     * Sets the length of the user data for the stream.<br>
     * * @param p_stream    the stream to modify<br>
     * @param data_length length of the user_data.<br>
     * Original signature : <code>void opj_stream_set_user_data_length(opj_stream_t*, OPJ_UINT64)</code><br>
     */
    public static native void opj_stream_set_user_data_length(PointerByReference p_stream, long data_length);
    /**
     * Create a stream from a file identified with its filename with default parameters (helper function)<br>
     * @param fname             the filename of the file to stream<br>
     * @param p_is_read_stream  whether the stream is a read stream (true) or not (false)<br>
     * Original signature : <code>opj_stream_t* opj_stream_create_default_file_stream(const char*, OPJ_BOOL)</code><br>
     * @deprecated use the safer methods {@link #opj_stream_create_default_file_stream(java.lang.String, int)} and {@link #opj_stream_create_default_file_stream(com.sun.jna.Pointer, int)} instead
     */
    @Deprecated
    public static native PointerByReference opj_stream_create_default_file_stream(Pointer fname, int p_is_read_stream);
    /**
     * Create a stream from a file identified with its filename with default parameters (helper function)<br>
     * @param fname             the filename of the file to stream<br>
     * @param p_is_read_stream  whether the stream is a read stream (true) or not (false)<br>
     * Original signature : <code>opj_stream_t* opj_stream_create_default_file_stream(const char*, OPJ_BOOL)</code><br>
     */
    public static native PointerByReference opj_stream_create_default_file_stream(String fname, int p_is_read_stream);
    /**
     * Create a stream from a file identified with its filename with a specific buffer size<br>
     * @param fname             the filename of the file to stream<br>
     * @param p_buffer_size     size of the chunk used to stream<br>
     * @param p_is_read_stream  whether the stream is a read stream (true) or not (false)<br>
     * Original signature : <code>opj_stream_t* opj_stream_create_file_stream(const char*, OPJ_SIZE_T, OPJ_BOOL)</code><br>
     * @deprecated use the safer methods {@link #opj_stream_create_file_stream(java.lang.String, NativeSize, int)} and {@link #opj_stream_create_file_stream(com.sun.jna.Pointer, NativeSize, int)} instead
     */
    @Deprecated
    public static native PointerByReference opj_stream_create_file_stream(Pointer fname, NativeSize p_buffer_size, int p_is_read_stream);
    /**
     * Create a stream from a file identified with its filename with a specific buffer size<br>
     * @param fname             the filename of the file to stream<br>
     * @param p_buffer_size     size of the chunk used to stream<br>
     * @param p_is_read_stream  whether the stream is a read stream (true) or not (false)<br>
     * Original signature : <code>opj_stream_t* opj_stream_create_file_stream(const char*, OPJ_SIZE_T, OPJ_BOOL)</code><br>
     */
    public static native PointerByReference opj_stream_create_file_stream(String fname, NativeSize p_buffer_size, int p_is_read_stream);
    /**
     * Set the info handler use by struct.<br>
     * @param p_codec       the codec previously initialise<br>
     * @param p_callback    the callback function which will be used<br>
     * @param p_user_data   client object where will be returned the message<br>
     * Original signature : <code>OPJ_BOOL opj_set_info_handler(opj_codec_t*, MessageFunction, void*)</code><br>
     */
    public static native int opj_set_info_handler(Codec p_codec, Callbacks.MessageFunction p_callback, Pointer p_user_data);
    /**
     * Set the warning handler use by struct.<br>
     * @param p_codec       the codec previously initialise<br>
     * @param p_callback    the callback function which will be used<br>
     * @param p_user_data   client object where will be returned the message<br>
     * Original signature : <code>OPJ_BOOL opj_set_warning_handler(opj_codec_t*, MessageFunction, void*)</code><br>
     */
    public static native int opj_set_warning_handler(Codec p_codec, Callbacks.MessageFunction p_callback, Pointer p_user_data);
    /**
     * Set the error handler use by struct.<br>
     * @param p_codec       the codec previously initialise<br>
     * @param p_callback    the callback function which will be used<br>
     * @param p_user_data   client object where will be returned the message<br>
     * Original signature : <code>OPJ_BOOL opj_set_error_handler(opj_codec_t*, MessageFunction, void*)</code><br>
     */
    public static native int opj_set_error_handler(Codec p_codec, Callbacks.MessageFunction p_callback, Pointer p_user_data);
    /**
     * Creates a J2K/JP2 decompression structure<br>
     * @param format 		Decoder to select<br>
     * * @return Returns a handle to a decompressor if successful, returns NULL otherwise<br>
     * Original signature : <code>opj_codec_t* opj_create_decompress(OPJ_CODEC_FORMAT)</code><br>
     */
    public static native Codec.ByReference opj_create_decompress(int format);
    /**
     * Destroy a decompressor handle<br>
     * * @param	p_codec			decompressor handle to destroy<br>
     * Original signature : <code>void opj_destroy_codec(opj_codec_t*)</code><br>
     */
    public static native void opj_destroy_codec(Codec p_codec);
    /**
     * Read after the codestream if necessary<br>
     * @param	p_codec			the JPEG2000 codec to read.<br>
     * @param	p_stream		the JPEG2000 stream.<br>
     * Original signature : <code>OPJ_BOOL opj_end_decompress(opj_codec_t*, opj_stream_t*)</code><br>
     */
    public static native int opj_end_decompress(Codec p_codec, PointerByReference p_stream);
    /**
     * Set decoding parameters to default values<br>
     * @param parameters Decompression parameters<br>
     * Original signature : <code>void opj_set_default_decoder_parameters(opj_dparameters_t*)</code><br>
     */
    public static native void opj_set_default_decoder_parameters(DParameters parameters);
    /**
     * Setup the decoder with decompression parameters provided by the user and with the message handler<br>
     * provided by the user.<br>
     * * @param p_codec 		decompressor handler<br>
     * @param parameters 	decompression parameters<br>
     * * @return true			if the decoder is correctly set<br>
     * Original signature : <code>OPJ_BOOL opj_setup_decoder(opj_codec_t*, opj_dparameters_t*)</code><br>
     */
    public static native int opj_setup_decoder(Codec p_codec, DParameters parameters);
    /**
     * Decodes an image header.<br>
     * * @param	p_stream		the jpeg2000 stream.<br>
     * @param	p_codec			the jpeg2000 codec to read.<br>
     * @param	p_image			the image structure initialized with the characteristics of encoded image.<br>
     * * @return true				if the main header of the codestream and the JP2 header is correctly read.<br>
     * Original signature : <code>OPJ_BOOL opj_read_header(opj_stream_t*, opj_codec_t*, opj_image_t**)</code><br>
     */
    public static native int opj_read_header(PointerByReference p_stream, Codec p_codec, PointerByReference p_image);
    /**
     * Sets the given area to be decoded. This function should be called right after opj_read_header and before any tile header reading.<br>
     * * @param	p_codec			the jpeg2000 codec.<br>
     * @param	p_image         the decoded image previously setted by opj_read_header<br>
     * @param	p_start_x		the left position of the rectangle to decode (in image coordinates).<br>
     * @param	p_end_x			the right position of the rectangle to decode (in image coordinates).<br>
     * @param	p_start_y		the up position of the rectangle to decode (in image coordinates).<br>
     * @param	p_end_y			the bottom position of the rectangle to decode (in image coordinates).<br>
     * * @return	true			if the area could be set.<br>
     * Original signature : <code>OPJ_BOOL opj_set_decode_area(opj_codec_t*, opj_image_t*, OPJ_INT32, OPJ_INT32, OPJ_INT32, OPJ_INT32)</code><br>
     */
    public static native int opj_set_decode_area(Codec p_codec, Image p_image, int p_start_x, int p_start_y, int p_end_x, int p_end_y);
    /**
     * Decode an image from a JPEG-2000 codestream<br>
     * * @param p_decompressor 	decompressor handle<br>
     * @param p_stream			Input buffer stream<br>
     * @param p_image 			the decoded image<br>
     * @return 					true if success, otherwise false<br>
     * Original signature : <code>OPJ_BOOL opj_decode(opj_codec_t*, opj_stream_t*, opj_image_t*)</code><br>
     */
    public static native int opj_decode(Codec p_decompressor, PointerByReference p_stream, Image p_image);
    /**
     * Get the decoded tile from the codec<br>
     * * @param	p_codec			the jpeg2000 codec.<br>
     * @param	p_stream		input streamm<br>
     * @param	p_image			output image<br>
     * @param	tile_index		index of the tile which will be decode<br>
     * * @return					true if success, otherwise false<br>
     * Original signature : <code>OPJ_BOOL opj_get_decoded_tile(opj_codec_t*, opj_stream_t*, opj_image_t*, OPJ_UINT32)</code><br>
     */
    public static native int opj_get_decoded_tile(Codec p_codec, PointerByReference p_stream, Image p_image, int tile_index);
}
