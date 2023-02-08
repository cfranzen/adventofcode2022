package de.cfranzen.adventofcode.day13;

import java.util.Comparator;

public class SignalValueComparator implements Comparator<SignalValue> {

    @Override
    public int compare(final SignalValue v1, final SignalValue v2) {
        if (v1 instanceof IntSignalValue iv1 && v2 instanceof IntSignalValue iv2) {
            return compareInternal(iv1, iv2);
        } else if (v1 instanceof ListSignalValue lv1 && v2 instanceof ListSignalValue lv2) {
            return compareInternal(lv1, lv2);
        } else if (v1 instanceof IntSignalValue iv1 && v2 instanceof ListSignalValue lv2) {
            return -1 * compareInternal(lv2, iv1);
        } else if (v1 instanceof ListSignalValue lv1 && v2 instanceof IntSignalValue iv2) {
            return compareInternal(lv1, iv2);
        } else {
            throw new IllegalArgumentException("Only IntSignalValue and ListSignalValue are supported as arguments");
        }
    }

    private int compareInternal(final IntSignalValue iv1, final IntSignalValue iv2) {
        return Integer.compare(iv1.value(), iv2.value());
    }

    private int compareInternal(final ListSignalValue lv1, final IntSignalValue iv2) {
        return compare(lv1, ListSignalValue.of(iv2));
    }

    private int compareInternal(final ListSignalValue lv1, final ListSignalValue lv2) {
        final var maxSize = Math.max(lv1.size(), lv2.size());
        for (int i = 0; i < maxSize; i++) {
            if (i == lv1.size()) {
                return -1;
            }
            if (i == lv2.size()) {
                return 1;
            }
            var result = compare(lv1.values().get(i), lv2.values().get(i));
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
