package openjp2;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import openjp2.struct.ImageComponent;

/**
 * Created by kraftek on 8/18/2016.
 */
public class Util {

    public static int clampInt(final int value, final int prec, final int sgnd) {
        if (sgnd > 0) {
            if (prec <= 8)
                return clamp(value, Byte.MIN_VALUE, Byte.MAX_VALUE);
            else if (prec <= 16)
                return clamp(value, Short.MIN_VALUE, Short.MAX_VALUE);
            else
                return clamp(value, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            if (prec <= 8)
                return clamp(value, 0, 255);
            else if (prec <= 16)
                return clamp(value, 0, 65535);
            else
                return value;
        }
    }

    public static ImageComponent[] fromArrayPointer(Pointer pointer, int numComps) {
        ImageComponent[] arr = new ImageComponent[numComps];
        int offset = 0;
        for (int i = 0; i < numComps; i++) {
            arr[i] = fromPointer(pointer, offset);
            offset += 50;
        }
        return arr;
    }

    public static ImageComponent fromPointer(Pointer pointer, int offset) {
        ImageComponent inst = new ImageComponent();
        inst.dx = pointer.getInt(offset);
        offset += 4;
        inst.dy = pointer.getInt(offset);
        offset += 4;
        inst.w = pointer.getInt(offset);
        offset += 4;
        inst.h = pointer.getInt(offset);
        offset += 4;
        inst.x0 = pointer.getInt(offset);
        offset += 4;
        inst.y0 = pointer.getInt(offset);
        offset += 4;
        inst.prec = pointer.getInt(offset);
        offset += 4;
        inst.bpp = pointer.getInt(offset);
        offset += 4;
        inst.sgnd = pointer.getInt(offset);
        offset += 4;
        inst.resno_decoded = pointer.getInt(offset);
        offset += 4;
        inst.factor = pointer.getInt(offset);
        offset += 4;
        inst.data = new IntByReference(pointer.getPointer(offset).getInt(0));
        offset += 4;
        inst.alpha = pointer.getShort(offset);
        return inst;
    }

    private static int clamp(final int x, final int a, final int b) {
        return x < a ? a : (x > b ? b : x);
    }
}
