package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class CodestreamInfo2 extends Structure {
    /**
     * tile origin in x = XTOsiz
     * C type : OPJ_UINT32
     */
    public int tx0;
    /**
     * tile origin in y = YTOsiz
     * C type : OPJ_UINT32
     */
    public int ty0;
    /**
     * tile size in x = XTsiz
     * C type : OPJ_UINT32
     */
    public int tdx;
    /**
     * tile size in y = YTsiz
     * C type : OPJ_UINT32
     */
    public int tdy;
    /**
     * number of tiles in X
     * C type : OPJ_UINT32
     */
    public int tw;
    /**
     * number of tiles in Y
     * C type : OPJ_UINT32
     */
    public int th;
    /**
     * number of components
     * C type : OPJ_UINT32
     */
    public int nbcomps;
    /**
     * Default information regarding tiles inside image
     * C type : opj_tile_info_v2_t
     */
    public TileInfo2 m_default_tile_info;
    /**
     * information regarding tiles inside image
     * FIXME not used for the moment
     * C type : opj_tile_info_v2_t*
     */
    public TileInfo2.ByReference tile_info;
    
    public CodestreamInfo2() {
        super();
    }
    /**
     * @param tx0 tile origin in x = XTOsiz
     * C type : OPJ_UINT32
     * @param ty0 tile origin in y = YTOsiz
     * C type : OPJ_UINT32
     * @param tdx tile size in x = XTsiz
     * C type : OPJ_UINT32
     * @param tdy tile size in y = YTsiz
     * C type : OPJ_UINT32
     * @param tw number of tiles in X
     * C type : OPJ_UINT32
     * @param th number of tiles in Y
     * C type : OPJ_UINT32
     * @param nbcomps number of components
     * C type : OPJ_UINT32
     * @param m_default_tile_info Default information regarding tiles inside image
     * C type : opj_tile_info_v2_t
     * @param tile_info information regarding tiles inside image
     * FIXME not used for the moment
     * C type : opj_tile_info_v2_t*
     */
    public CodestreamInfo2(int tx0, int ty0, int tdx, int tdy, int tw, int th, int nbcomps, TileInfo2 m_default_tile_info, TileInfo2.ByReference tile_info) {
        super();
        this.tx0 = tx0;
        this.ty0 = ty0;
        this.tdx = tdx;
        this.tdy = tdy;
        this.tw = tw;
        this.th = th;
        this.nbcomps = nbcomps;
        this.m_default_tile_info = m_default_tile_info;
        this.tile_info = tile_info;
    }
    public CodestreamInfo2(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("tx0", "ty0", "tdx", "tdy", "tw", "th", "nbcomps", "m_default_tile_info", "tile_info");
    }
    
    public static class ByReference extends CodestreamInfo2 implements Structure.ByReference { }
    public static class ByValue extends CodestreamInfo2 implements Structure.ByValue { }
}
