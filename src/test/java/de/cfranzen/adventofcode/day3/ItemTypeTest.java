package de.cfranzen.adventofcode.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTypeTest {

    private static final String ASCII_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    void testConstruction() {
        for (char ch : ASCII_LETTERS.toCharArray()) {
            assertDoesNotThrow(() -> new ItemType(ch));
        }
    }

    @Test
    void testConstructionWithInvalidType() {
        assertThrows(IllegalArgumentException.class, () -> new ItemType('!'));
    }

    @Test
    void testPriorityCalculation() {
        final char[] chars = ASCII_LETTERS.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final ItemType itemType = new ItemType(chars[i]);
            assertEquals(i + 1, itemType.getPriority());
        }
    }
}