package openjp2.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.LongByReference;
import java.util.Arrays;
import java.util.List;

import openjp2.types.NativeSize;
import openjp2.types.NativeSizeByReference;
import openjp2.types.FilePointer;

public class SegmentedFileInfo extends Structure {
    /** C type : char[4096] */
    public byte[] infile = new byte[4096];
    /** C type : FilePointer* */
    public FilePointer p_file;
    /** C type : OPJ_SIZE_T */
    public NativeSize dataLength;
    /** C type : OPJ_SIZE_T */
    public NativeSize dataRead;
    public int numSegmentsMinusOne;
    /** C type : OPJ_OFF_T* */
    public LongByReference p_segmentPositionsList;
    /** C type : OPJ_SIZE_T* */
    public NativeSizeByReference p_segmentLengths;
    /** C type : OPJ_OFF_T */
    public long curPos;
    public int curSegment;

    public SegmentedFileInfo() {
        super();
    }
    /**
     * @param infile C type : char[4096]<br>
     * @param p_file C type : FilePointer*<br>
     * @param dataLength C type : OPJ_SIZE_T<br>
     * @param dataRead C type : OPJ_SIZE_T<br>
     * @param p_segmentPositionsList C type : OPJ_OFF_T*<br>
     * @param p_segmentLengths C type : OPJ_SIZE_T*<br>
     * @param curPos C type : OPJ_OFF_T
     */
    public SegmentedFileInfo(byte infile[], FilePointer p_file, NativeSize dataLength, NativeSize dataRead, int numSegmentsMinusOne, LongByReference p_segmentPositionsList, NativeSizeByReference p_segmentLengths, long curPos, int curSegment) {
        super();
        if ((infile.length != this.infile.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.infile = infile;
        this.p_file = p_file;
        this.dataLength = dataLength;
        this.dataRead = dataRead;
        this.numSegmentsMinusOne = numSegmentsMinusOne;
        this.p_segmentPositionsList = p_segmentPositionsList;
        this.p_segmentLengths = p_segmentLengths;
        this.curPos = curPos;
        this.curSegment = curSegment;
    }
    public SegmentedFileInfo(Pointer peer) {
        super(peer);
    }

    protected List<? > getFieldOrder() {
        return Arrays.asList("infile", "p_file", "dataLength", "dataRead", "numSegmentsMinusOne", "p_segmentPositionsList", "p_segmentLengths", "curPos", "curSegment");
    }

    public static class ByReference extends SegmentedFileInfo implements Structure.ByReference { }
    public static class ByValue extends SegmentedFileInfo implements Structure.ByValue { }
}
