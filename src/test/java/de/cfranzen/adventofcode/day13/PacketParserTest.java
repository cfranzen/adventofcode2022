package de.cfranzen.adventofcode.day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PacketParserTest {

    @Test
    void testEmptyLists() {
        final String sequence = "[]";
        final ListSignalValue result = new PacketParser(sequence).parsePacket();

        assertThat(result.values()).isEmpty();
    }

    @Test
    void testSingleValuedLists() {
        final String sequence = "[1]";
        final ListSignalValue result = new PacketParser(sequence).parsePacket();

        assertThat(result.values()).containsExactly(IntSignalValue.of(1));
    }

    @Test
    void testSingleValuedMultiDigitLists() {
        final String sequence = "[123]";
        final ListSignalValue result = new PacketParser(sequence).parsePacket();

        assertThat(result.values()).containsExactly(IntSignalValue.of(123));
    }

    @Test
    void testMultiValuedLists() {
        final String sequence = "[1,2,3]";
        final ListSignalValue result = new PacketParser(sequence).parsePacket();

        assertThat(result.values()).containsExactly(
                IntSignalValue.of(1),
                IntSignalValue.of(2),
                IntSignalValue.of(3)
        );
    }

    @Test
    void testListOfLists() {
        final String sequence = "[[1],[2],[]]";
        final ListSignalValue result = new PacketParser(sequence).parsePacket();

        assertThat(result.values()).containsExactly(
                ListSignalValue.of(IntSignalValue.of(1)),
                ListSignalValue.of(IntSignalValue.of(2)),
                ListSignalValue.empty()
        );
    }

    @Test
    void testComplexMixtureOfListsAndInts() {
        final String sequence = "[[1],[2,3],4,[5,[6,7]]]";
        final ListSignalValue result = new PacketParser(sequence).parsePacket();

        assertThat(result.values()).containsExactly(
                ListSignalValue.of(IntSignalValue.of(1)),
                ListSignalValue.of(
                        IntSignalValue.of(2),
                        IntSignalValue.of(3)
                ),
                IntSignalValue.of(4),
                ListSignalValue.of(
                        IntSignalValue.of(5),
                        ListSignalValue.of(
                                IntSignalValue.of(6),
                                IntSignalValue.of(7)
                        )
                )
        );
    }
}