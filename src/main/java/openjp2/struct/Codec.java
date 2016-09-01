package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

import openjp2.types.EventManagerPointer;
import openjp2.callback.Callbacks.DumpCodecCallback;
import openjp2.callback.Callbacks.GenericCallback;

public class Codec extends Structure {
    public CodecUnion m_codec_data;
    public PointerByReference m_codec;
    public EventManagerPointer m_event_mgr;
    public int is_decompressor;
    public DumpCodecCallback opj_dump_codec;
    public GenericCallback opj_get_codec_info;
    public GenericCallback opj_get_codec_index;

    public Codec() {
        super();
        m_event_mgr = new EventManagerPointer();
        is_decompressor = 1;
    }
    /**
     * @param m_codec C type : void*<br>
     * @param m_event_mgr Event handler<br>
     * C type : opj_event_mgr_t<br>
     * @param is_decompressor Flag to indicate if the codec is used to decode or encode<br>
     * C type : OPJ_BOOL<br>
     * @param opj_dump_codec C type : DumpCodecCallback*<br>
     * @param opj_get_codec_info C type : GetCodecInfoCallback*<br>
     * @param opj_get_codec_index C type : GetCodecIndexCallback*
     */
    public Codec(CodecUnion m_codec_data, PointerByReference m_codec, EventManagerPointer m_event_mgr, int is_decompressor, DumpCodecCallback opj_dump_codec, GenericCallback opj_get_codec_info, GenericCallback opj_get_codec_index) {
        super();
        this.m_codec_data = m_codec_data;
        this.m_codec = m_codec;
        this.m_event_mgr = m_event_mgr;
        this.is_decompressor = is_decompressor;
        this.opj_dump_codec = opj_dump_codec;
        this.opj_get_codec_info = opj_get_codec_info;
        this.opj_get_codec_index = opj_get_codec_index;
    }

    public Codec(Pointer peer) {
        super(peer);
    }

    @Override
    public void read() {
        super.read();
    }

    @Override
    protected List<?> getFieldOrder() {
        return Arrays.asList("m_codec_data", "m_codec", "m_event_mgr", "is_decompressor", "opj_dump_codec", "opj_get_codec_info", "opj_get_codec_index");
    }

    public static class ByReference extends Codec implements Structure.ByReference { }

    public static class ByValue extends Codec implements Structure.ByValue { }

    public static class CodecUnion extends Union {
        public Decompression m_decompression;
        public Compression m_compression;
        public CodecUnion() {
            setType(Decompression.class);
        }

        public CodecUnion(Pointer peer) {
            super(peer);
            setType(Decompression.class);
        }

        public static class ByReference extends CodecUnion implements Structure.ByReference { }
    }
}
