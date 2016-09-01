package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

import openjp2.callback.Callbacks.StartCompressCallback;
import openjp2.callback.Callbacks.EncodeCallback;
import openjp2.callback.Callbacks.WriteTileCallback;
import openjp2.callback.Callbacks.EndCompressCallback;
import openjp2.callback.Callbacks.DestroyCallback;
import openjp2.callback.Callbacks.SetupEncoderCallback;

public class Compression extends Structure {
    public StartCompressCallback opj_start_compress;
    public EncodeCallback opj_encode;
    public WriteTileCallback opj_write_tile;
    public EndCompressCallback opj_end_compress;
    public DestroyCallback opj_destroy;
    public SetupEncoderCallback opj_setup_encoder;

    public Compression(StartCompressCallback opj_start_compress, EncodeCallback opj_encode, WriteTileCallback opj_write_tile, EndCompressCallback opj_end_compress, DestroyCallback opj_destroy, SetupEncoderCallback opj_setup_encoder) {
        super();
        this.opj_start_compress = opj_start_compress;
        this.opj_encode = opj_encode;
        this.opj_write_tile = opj_write_tile;
        this.opj_end_compress = opj_end_compress;
        this.opj_destroy = opj_destroy;
        this.opj_setup_encoder = opj_setup_encoder;
    }

    public Compression() {
        super();
    }
    public Compression(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("opj_start_compress", "opj_encode", "opj_write_tile", "opj_end_compress", "opj_destroy", "opj_setup_encoder");
    }

    public static class ByReference extends Compression implements Structure.ByReference { }
    public static class ByValue extends Compression implements Structure.ByValue { }
}
