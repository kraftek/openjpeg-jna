package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class TPInfo extends Structure {
    /** start position of tile part */
    public int tp_start_pos;
    /** end position of tile part header */
    public int tp_end_header;
    /** end position of tile part */
    public int tp_end_pos;
    /** start packet of tile part */
    public int tp_start_pack;
    /** number of packets of tile part */
    public int tp_numpacks;

    public TPInfo() {
        super();
    }
    /**
     * @param tp_start_pos start position of tile part<br>
     * @param tp_end_header end position of tile part header<br>
     * @param tp_end_pos end position of tile part<br>
     * @param tp_start_pack start packet of tile part<br>
     * @param tp_numpacks number of packets of tile part
     */
    public TPInfo(int tp_start_pos, int tp_end_header, int tp_end_pos, int tp_start_pack, int tp_numpacks) {
        super();
        this.tp_start_pos = tp_start_pos;
        this.tp_end_header = tp_end_header;
        this.tp_end_pos = tp_end_pos;
        this.tp_start_pack = tp_start_pack;
        this.tp_numpacks = tp_numpacks;
    }
    public TPInfo(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("tp_start_pos", "tp_end_header", "tp_end_pos", "tp_start_pack", "tp_numpacks");
    }

    public static class ByReference extends TPInfo implements Structure.ByReference { }
    public static class ByValue extends TPInfo implements Structure.ByValue { }
}
