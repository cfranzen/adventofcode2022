package de.cfranzen.adventofcode.day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SignalValueComparatorTest {

    private final SignalValueComparator sut = new SignalValueComparator();

    @Test
    void testComparingInts() {
        var first = IntSignalValue.of(1);
        var second = IntSignalValue.of(2);

        assertThat(sut.compare(first, second)).isEqualTo(-1);
        assertThat(sut.compare(first, first)).isEqualTo(0);
        assertThat(sut.compare(second, first)).isEqualTo(1);
    }

    @Test
    void testComparingSingleValuedLists() {
        var first = ListSignalValue.of(IntSignalValue.of(1));
        var second = ListSignalValue.of(IntSignalValue.of(2));

        assertThat(sut.compare(first, second)).isEqualTo(-1);
        assertThat(sut.compare(first, first)).isEqualTo(0);
        assertThat(sut.compare(second, first)).isEqualTo(1);
    }

    @Test
    void testComparingMultiValuedLists() {
        var first = ListSignalValue.of(
                IntSignalValue.of(1),
                IntSignalValue.of(1),
                IntSignalValue.of(1)
        );
        var second = ListSignalValue.of(
                IntSignalValue.of(1),
                IntSignalValue.of(1),
                IntSignalValue.of(2)
        );

        assertThat(sut.compare(first, second)).isEqualTo(-1);
        assertThat(sut.compare(first, first)).isEqualTo(0);
        assertThat(sut.compare(second, first)).isEqualTo(1);
    }

    @Test
    void testComparingListsOfDifferentSize() {
        var first = ListSignalValue.of(
                IntSignalValue.of(1),
                IntSignalValue.of(1)
        );
        var second = ListSignalValue.of(
                IntSignalValue.of(1),
                IntSignalValue.of(1),
                IntSignalValue.of(1)
        );

        assertThat(sut.compare(first, second)).isEqualTo(-1);
        assertThat(sut.compare(first, first)).isEqualTo(0);
        assertThat(sut.compare(second, first)).isEqualTo(1);
    }

    @Test
    void testComparingIntToList() {
        var first = IntSignalValue.of(1);
        var second = ListSignalValue.of(IntSignalValue.of(2));

        assertThat(sut.compare(first, second)).isEqualTo(-1);
        assertThat(sut.compare(first, first)).isEqualTo(0);
        assertThat(sut.compare(second, first)).isEqualTo(1);
    }

}