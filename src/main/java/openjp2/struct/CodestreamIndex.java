package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
 
public class CodestreamIndex extends Structure {
    /**
     * main header start position (SOC position)
     * C type : OPJ_OFF_T
     */
    public long main_head_start;
    /**
     * main header end position (first SOT position)
     * C type : OPJ_OFF_T
     */
    public long main_head_end;
    /**
     * codestream's size
     * C type : OPJ_UINT64
     */
    public long codestream_size;
    /**
     * number of markers
     * C type : OPJ_UINT32
     */
    public int marknum;
    /**
     * list of markers
     * C type : opj_marker_info_t*
     */
    public MarkerInfo.ByReference marker;
    /**
     * actual size of markers array
     * C type : OPJ_UINT32
     */
    public int maxmarknum;
    /** C type : OPJ_UINT32 */
    public int nb_of_tiles;
    /**
     * C type : opj_tile_index_t*
     */
    public TileIndex.ByReference tile_index;

    public CodestreamIndex() {
        super();
    }
    /**
     * @param main_head_start main header start position (SOC position)
     * C type : OPJ_OFF_T
     * @param main_head_end main header end position (first SOT position)
     * C type : OPJ_OFF_T
     * @param codestream_size codestream's size
     * C type : OPJ_UINT64
     * @param marknum number of markers
     * C type : OPJ_UINT32
     * @param marker list of markers
     * C type : opj_marker_info_t*
     * @param maxmarknum actual size of markers array
     * C type : OPJ_UINT32
     * @param nb_of_tiles C type : OPJ_UINT32
     * @param tile_index FIXME not used for the moment
     * C type : opj_tile_index_t*
     */
    public CodestreamIndex(long main_head_start, long main_head_end, long codestream_size, int marknum, MarkerInfo.ByReference marker, int maxmarknum, int nb_of_tiles, TileIndex.ByReference tile_index) {
        super();
        this.main_head_start = main_head_start;
        this.main_head_end = main_head_end;
        this.codestream_size = codestream_size;
        this.marknum = marknum;
        this.marker = marker;
        this.maxmarknum = maxmarknum;
        this.nb_of_tiles = nb_of_tiles;
        this.tile_index = tile_index;
    }
    public CodestreamIndex(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("main_head_start", "main_head_end", "codestream_size", "marknum", "marker", "maxmarknum", "nb_of_tiles", "tile_index");
    }

    public static class ByReference extends CodestreamIndex implements Structure.ByReference { }
    public static class ByValue extends CodestreamIndex implements Structure.ByValue { }
}
