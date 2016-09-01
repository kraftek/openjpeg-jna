package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

import openjp2.callback.Callbacks.ReadHeaderCallback;
import openjp2.callback.Callbacks.DecodeCallback;
import openjp2.callback.Callbacks.ReadTileHeaderCallback;
import openjp2.callback.Callbacks.DecodeTileDataCallback;
import openjp2.callback.Callbacks.EndDecompressCallback;
import openjp2.callback.Callbacks.DestroyCallback;
import openjp2.callback.Callbacks.SetupDecoderCallback;
import openjp2.callback.Callbacks.SetDecodeAreaCallback;
import openjp2.callback.Callbacks.GetDecodedTileCallback;
import openjp2.callback.Callbacks.SetDecodedResolutionFactorCallback;

public class Decompression extends Structure {

    public ReadHeaderCallback opj_read_header;
    public DecodeCallback opj_decode;
    public ReadTileHeaderCallback opj_read_tile_header;
    public DecodeTileDataCallback opj_decode_tile_data;
    public EndDecompressCallback opj_end_decompress;
    public DestroyCallback opj_destroy;
    public SetupDecoderCallback opj_setup_decoder;
    public SetDecodeAreaCallback opj_set_decode_area;
    public GetDecodedTileCallback opj_get_decoded_tile;
    public SetDecodedResolutionFactorCallback opj_set_decoded_resolution_factor;

    public Decompression() {
        super();
    }

    public Decompression(Pointer peer) {
        super(peer);
    }

    public Decompression(ReadHeaderCallback opj_read_header, DecodeCallback opj_decode, ReadTileHeaderCallback opj_read_tile_header, DecodeTileDataCallback opj_decode_tile_data, EndDecompressCallback opj_end_decompress, DestroyCallback opj_destroy, SetupDecoderCallback opj_setup_decoder, SetDecodeAreaCallback opj_set_decode_area, GetDecodedTileCallback opj_get_decoded_tile, SetDecodedResolutionFactorCallback opj_set_decoded_resolution_factor) {
        super();
        this.opj_read_header = opj_read_header;
        this.opj_decode = opj_decode;
        this.opj_read_tile_header = opj_read_tile_header;
        this.opj_decode_tile_data = opj_decode_tile_data;
        this.opj_end_decompress = opj_end_decompress;
        this.opj_destroy = opj_destroy;
        this.opj_setup_decoder = opj_setup_decoder;
        this.opj_set_decode_area = opj_set_decode_area;
        this.opj_get_decoded_tile = opj_get_decoded_tile;
        this.opj_set_decoded_resolution_factor = opj_set_decoded_resolution_factor;
    }

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("opj_read_header", "opj_decode", "opj_read_tile_header", "opj_decode_tile_data", "opj_end_decompress", "opj_destroy", "opj_setup_decoder", "opj_set_decode_area", "opj_get_decoded_tile", "opj_set_decoded_resolution_factor");
    }

    public static class ByReference extends Decompression implements Structure.ByReference { }
    public static class ByValue extends Decompression implements Structure.ByValue { }
}
