package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DParameters extends Structure {
    /**
     * Set the number of highest resolution levels to be discarded. 
     * The image resolution is effectively divided by 2 to the power of the number of discarded levels. 
     * The reduce factor is limited by the smallest total number of decomposition levels among tiles.
     * if != 0, then original dimension divided by 2^(reduce); 
     * if == 0 or not used, image is decoded to the full resolution
     * C type : OPJ_UINT32
     */
    public int cp_reduce;
    /**
     * Set the maximum number of quality layers to decode. 
     * If there are less quality layers than the specified number, all the quality layers are decoded.
     * if != 0, then only the first "layer" layers are decoded; 
     * if == 0 or not used, all the quality layers are decoded
     * C type : OPJ_UINT32
     */
    public int cp_layer;
    /**
     * input file name
     * C type : char[4096]
     */
    public byte[] infile = new byte[4096];
    /**
     * output file name
     * C type : char[4096]
     */
    public byte[] outfile = new byte[4096];
    /** input file format 0: J2K, 1: JP2, 2: JPT */
    public int decod_format;
    /** output file format 0: PGX, 1: PxM, 2: BMP */
    public int cod_format;
    /**
     * Decoding area left boundary
     * C type : OPJ_UINT32
     */
    public int DA_x0;
    /**
     * Decoding area right boundary
     * C type : OPJ_UINT32
     */
    public int DA_x1;
    /**
     * Decoding area up boundary
     * C type : OPJ_UINT32
     */
    public int DA_y0;
    /**
     * Decoding area bottom boundary
     * C type : OPJ_UINT32
     */
    public int DA_y1;
    /**
     * Verbose mode
     * C type : OPJ_BOOL
     */
    public int m_verbose;
    /**
     * tile number ot the decoded tile
     * C type : OPJ_UINT32
     */
    public int tile_index;
    /**
     * Nb of tile to decode
     * C type : OPJ_UINT32
     */
    public int nb_tile_to_decode;
    /**
     * activates the JPWL correction capabilities
     * C type : OPJ_BOOL
     */
    public int jpwl_correct;
    /** expected number of components */
    public int jpwl_exp_comps;
    /** maximum number of tiles */
    public int jpwl_max_tiles;
    public int flags;

    public DParameters() {
        super();
    }
    public DParameters(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("cp_reduce", "cp_layer", "infile", "outfile", "decod_format", "cod_format", "DA_x0", "DA_x1", "DA_y0", "DA_y1", "m_verbose", "tile_index", "nb_tile_to_decode", "jpwl_correct", "jpwl_exp_comps", "jpwl_max_tiles", "flags");
    }

    public static class ByReference extends DParameters implements Structure.ByReference { }
    public static class ByValue extends DParameters implements Structure.ByValue { }
}
