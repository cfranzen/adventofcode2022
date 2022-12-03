package de.cfranzen.adventofcode.day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompartmentTest {

    @Test
    void testDuplicateDetection() {
        // given
        Compartment c1 = Compartment.fromString("abcd");
        Compartment c2 = Compartment.fromString("efga");

        // when
        ItemType duplicate = Compartment.findDuplicate(c1, c2);

        // then
        assertThat(duplicate).isEqualTo(new ItemType('a'));
    }

    @Test
    void testDuplicateDetection_MultipleDuplicates() {
        // given
        Compartment c1 = Compartment.fromString("abcd");
        Compartment c2 = Compartment.fromString("efab");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> Compartment.findDuplicate(c1, c2));
    }

    @Test
    void testDuplicateDetection_NoDuplicate() {
        // given
        Compartment c1 = Compartment.fromString("abcd");
        Compartment c2 = Compartment.fromString("efgh");

        // when / then
        assertThrows(IllegalArgumentException.class, () -> Compartment.findDuplicate(c1, c2));
    }
}