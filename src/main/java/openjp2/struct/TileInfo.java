package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.DoubleByReference;
import java.util.Arrays;
import java.util.List;

public class TileInfo extends Structure {
    /**
     * value of thresh for each layer by tile cfr. Marcela<br>
     * C type : double*
     */
    public DoubleByReference thresh;
    /** number of tile */
    public int tileno;
    /** start position */
    public int start_pos;
    /** end position of the header */
    public int end_header;
    /** end position */
    public int end_pos;
    /**
     * precinct number for each resolution level (width)<br>
     * C type : int[33]
     */
    public int[] pw = new int[33];
    /**
     * precinct number for each resolution level (height)<br>
     * C type : int[33]
     */
    public int[] ph = new int[33];
    /**
     * precinct size (in power of 2), in X for each resolution level<br>
     * C type : int[33]
     */
    public int[] pdx = new int[33];
    /**
     * precinct size (in power of 2), in Y for each resolution level<br>
     * C type : int[33]
     */
    public int[] pdy = new int[33];
    /**
     * information concerning packets inside tile<br>
     * C type : opj_packet_info_t*
     */
    public PacketInfo.ByReference packet;
    /** add fixed_quality */
    public int numpix;
    /** add fixed_quality */
    public double distotile;
    /** number of markers */
    public int marknum;
    /**
     * list of markers<br>
     * C type : opj_marker_info_t*
     */
    public MarkerInfo.ByReference marker;
    /** actual size of markers array */
    public int maxmarknum;
    /** number of tile parts */
    public int num_tps;
    /**
     * information concerning tile parts<br>
     * C type : opj_tp_info_t*
     */
    public TPInfo.ByReference tp;

    public TileInfo() {
        super();
    }
    public TileInfo(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("thresh", "tileno", "start_pos", "end_header", "end_pos", "pw", "ph", "pdx", "pdy", "packet", "numpix", "distotile", "marknum", "marker", "maxmarknum", "num_tps", "tp");
    }

    public static class ByReference extends TileInfo implements Structure.ByReference { }
    public static class ByValue extends TileInfo implements Structure.ByValue { }
}
