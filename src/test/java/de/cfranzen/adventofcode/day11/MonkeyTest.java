package de.cfranzen.adventofcode.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyTest {

    @Test
    void testPerformingTurn() {
        // Given
        final Monkey monkey = new Monkey(0, wl -> wl.multipleBy(19), wl -> wl.isDivisibleBy(23), 2, 3)
                .catchItem(Item.of(79)).catchItem(Item.of(98));

        // When
        final List<ThrownItem> thrownItems = monkey.performTurn();

        // Then
        assertThat(thrownItems).containsExactly(
                new ThrownItem(3, Item.of(500)),
                new ThrownItem(3, Item.of(620))
        );
    }

}