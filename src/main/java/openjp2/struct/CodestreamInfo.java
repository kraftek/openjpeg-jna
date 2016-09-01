package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

public class CodestreamInfo extends Structure {
    /** maximum distortion reduction on the whole image (add for Marcela) */
    public double D_max;
    /** packet number */
    public int packno;
    /** writing the packet in the index with t2_encode_packets */
    public int index_write;
    /** image width */
    public int image_w;
    /** image height */
    public int image_h;
    /**
     * progression order
     * C type : OPJ_PROG_ORDER
     */
    public int prog;
    /** tile size in x */
    public int tile_x;
    /** tile size in y */
    public int tile_y;
    public int tile_Ox;
    public int tile_Oy;
    /** number of tiles in X */
    public int tw;
    /** number of tiles in Y */
    public int th;
    /** component numbers */
    public int numcomps;
    /** number of layer */
    public int numlayers;
    /**
     * number of decomposition for each component
     * C type : int*
     */
    public IntByReference numdecompos;
    /** number of markers */
    public int marknum;
    /**
     * list of markers
     * C type : opj_marker_info_t*
     */
    public MarkerInfo.ByReference marker;
    /** actual size of markers array */
    public int maxmarknum;
    /** main header position */
    public int main_head_start;
    /** main header position */
    public int main_head_end;
    /** codestream's size */
    public int codestream_size;
    /**
     * information regarding tiles inside image
     * C type : opj_tile_info_t*
     */
    public TileInfo.ByReference tile;

    public CodestreamInfo() {
        super();
    }
    public CodestreamInfo(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("D_max", "packno", "index_write", "image_w", "image_h", "prog", "tile_x", "tile_y", "tile_Ox", "tile_Oy", "tw", "th", "numcomps", "numlayers", "numdecompos", "marknum", "marker", "maxmarknum", "main_head_start", "main_head_end", "codestream_size", "tile");
    }

    public static class ByReference extends CodestreamInfo implements Structure.ByReference { }
    public static class ByValue extends CodestreamInfo implements Structure.ByValue { }
}
