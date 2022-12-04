package de.cfranzen.adventofcode.day4;

import java.util.regex.Pattern;

class IntRange {

    private static final Pattern NON_DIGIT = Pattern.compile("\\D+");

    private final int startIncl;

    private final int endIncl;

    public IntRange(int startIncl, int endIncl) {
        this.startIncl = startIncl;
        this.endIncl = endIncl;

        if (endIncl < startIncl) {
            throw new IllegalArgumentException("End of range can not be smaller than its start");
        }
    }

    public int getStartIncl() {
        return startIncl;
    }

    public int getEndIncl() {
        return endIncl;
    }

    static IntRange fromString(String range) {
        final String[] split = NON_DIGIT.split(range);
        if (split.length != 2) {
            throw new IllegalArgumentException("Expecting string of form '2-4' but string '" + range + "' has been provided");
        }
        final int start = Integer.parseInt(split[0]);
        final int end = Integer.parseInt(split[1]);
        return new IntRange(start, end);
    }

    public boolean contains(IntRange otherRange) {
        return (startIncl <= otherRange.startIncl) && (endIncl >= otherRange.endIncl);
    }

    public boolean overlaps(IntRange otherRange) {
        return between(startIncl, otherRange.startIncl, endIncl) ||
                between(startIncl, otherRange.endIncl, endIncl) ||
                between(otherRange.startIncl, startIncl, otherRange.endIncl) ||
                between(otherRange.startIncl, endIncl, otherRange.endIncl);
    }

    private static boolean between(int start, int value, int end) {
        return (start <= value) && (value <= end);
    }
}
