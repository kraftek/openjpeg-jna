package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class JP2Metadata extends Structure {
    /** C type : OPJ_INT32 */
    public int not_used;

    public JP2Metadata() {
        super();
    }
    /** @param not_used C type : OPJ_INT32 */
    public JP2Metadata(int not_used) {
        super();
        this.not_used = not_used;
    }
    public JP2Metadata(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("not_used");
    }

    public static class ByReference extends JP2Metadata implements Structure.ByReference { }
    public static class ByValue extends JP2Metadata implements Structure.ByValue { }
}
