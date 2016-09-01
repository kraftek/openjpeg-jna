package openjp2.enums;

/**
 * Created by kraftek on 9/1/2016.
 */
public interface ProgOrder {
    /**
     * < place-holder
     */
    int OPJ_PROG_UNKNOWN = -1;
    /**
     * < layer-resolution-component-precinct order
     */
    int OPJ_LRCP = 0;
    /**
     * < resolution-layer-component-precinct order
     */
    int OPJ_RLCP = 1;
    /**
     * < resolution-precinct-component-layer order
     */
    int OPJ_RPCL = 2;
    /**
     * < precinct-component-resolution-layer order
     */
    int OPJ_PCRL = 3;
    /**
     * < component-precinct-resolution-layer order
     */
    int OPJ_CPRL = 4;
}