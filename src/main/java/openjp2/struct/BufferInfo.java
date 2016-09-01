package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import openjp2.types.NativeSize;

import java.util.Arrays;
import java.util.List;

public class BufferInfo extends Structure {
    /** C type : OPJ_BYTE* */
    public Pointer buf;
    /** C type : OPJ_BYTE* */
    public Pointer cur;
    /** C type : OPJ_SIZE_T */
    public NativeSize len;

    public BufferInfo() {
        super();
    }
    public BufferInfo(Pointer peer) {
        super(peer);
    }

    /**
     * @param buf C type : OPJ_BYTE*
     * @param cur C type : OPJ_BYTE*
     * @param len C type : OPJ_SIZE_T
     */
    public BufferInfo(Pointer buf, Pointer cur, NativeSize len) {
        super();
        this.buf = buf;
        this.cur = cur;
        this.len = len;
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("buf", "cur", "len");
    }

    public static class ByReference extends BufferInfo implements Structure.ByReference { }

    public static class ByValue extends BufferInfo implements Structure.ByValue { }
}
