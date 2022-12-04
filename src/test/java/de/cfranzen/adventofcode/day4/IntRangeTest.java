package de.cfranzen.adventofcode.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntRangeTest {

    @Test
    void testConstruction() {
        IntRange range1 = new IntRange(2, 7);
        assertEquals(2, range1.getStartIncl());
        assertEquals(7, range1.getEndIncl());

        IntRange range2 = new IntRange(2, 2);
        assertEquals(2, range2.getStartIncl());
        assertEquals(2, range2.getEndIncl());
    }

    @Test
    void testConstructionFromString() {
        IntRange range1 = IntRange.fromString("2-7");
        assertEquals(2, range1.getStartIncl());
        assertEquals(7, range1.getEndIncl());

        IntRange range2 = IntRange.fromString("2-2");
        assertEquals(2, range2.getStartIncl());
        assertEquals(2, range2.getEndIncl());
    }

    @Test
    void testConstruction_FailIfEndSmallerStart() {
        assertThrows(IllegalArgumentException.class, () -> IntRange.fromString("2-1"));
    }

    @Test
    void testRangeContainsOtherRange() {
        assertTrue(IntRange.fromString("2-7").contains(IntRange.fromString("3-6")));
        assertTrue(IntRange.fromString("2-7").contains(IntRange.fromString("5-5")));
        assertTrue(IntRange.fromString("2-7").contains(IntRange.fromString("2-7")));
        assertTrue(IntRange.fromString("2-7").contains(IntRange.fromString("7-7")));
        assertTrue(IntRange.fromString("2-7").contains(IntRange.fromString("2-2")));
    }

    @Test
    void testRangeNotContainsOtherRange() {
        assertFalse(IntRange.fromString("2-5").contains(IntRange.fromString("6-7")));
        assertFalse(IntRange.fromString("2-5").contains(IntRange.fromString("1-1")));
        assertFalse(IntRange.fromString("2-5").contains(IntRange.fromString("1-2")));
        assertFalse(IntRange.fromString("2-5").contains(IntRange.fromString("1-3")));
        assertFalse(IntRange.fromString("2-5").contains(IntRange.fromString("5-6")));
        assertFalse(IntRange.fromString("2-5").contains(IntRange.fromString("4-6")));
    }

    @Test
    void testRangeOverlapsOtherRange() {
        assertTrue(IntRange.fromString("2-7").overlaps(IntRange.fromString("3-6")));
        assertTrue(IntRange.fromString("2-7").overlaps(IntRange.fromString("5-5")));
        assertTrue(IntRange.fromString("3-6").overlaps(IntRange.fromString("2-7")));
        assertTrue(IntRange.fromString("2-5").overlaps(IntRange.fromString("5-6")));
        assertTrue(IntRange.fromString("2-5").overlaps(IntRange.fromString("4-6")));
        assertTrue(IntRange.fromString("2-5").overlaps(IntRange.fromString("1-2")));
        assertTrue(IntRange.fromString("2-5").overlaps(IntRange.fromString("1-3")));
    }

    @Test
    void testRangeNotOverlapsOtherRange() {
        assertFalse(IntRange.fromString("2-5").overlaps(IntRange.fromString("6-7")));
        assertFalse(IntRange.fromString("2-5").overlaps(IntRange.fromString("1-1")));
        assertFalse(IntRange.fromString("3-5").overlaps(IntRange.fromString("1-2")));
        assertFalse(IntRange.fromString("2-5").overlaps(IntRange.fromString("6-7")));
    }
}