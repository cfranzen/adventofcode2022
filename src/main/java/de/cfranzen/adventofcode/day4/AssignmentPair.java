package de.cfranzen.adventofcode.day4;

class AssignmentPair {

    private final IntRange range1;

    private final IntRange range2;

    AssignmentPair(IntRange range1, IntRange range2) {
        this.range1 = range1;
        this.range2 = range2;
    }

    boolean isOneRangeContainingTheOther() {
        return range1.contains(range2) || range2.contains(range1);
    }

    boolean isOneRangeOverlappingTheOther() {
        return range1.overlaps(range2);
    }
}
