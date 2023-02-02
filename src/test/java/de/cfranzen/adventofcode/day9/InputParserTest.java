package de.cfranzen.adventofcode.day9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void testParsing() {
        // Given
        final var lines = List.of("U 3", "D 2", "L 4", "R 1");

        // When
        final var movements = new InputParser().parseMovements(lines);

        // Then
        assertThat(movements).containsExactly(
                new Movement(Direction.UP, 3),
                new Movement(Direction.DOWN, 2),
                new Movement(Direction.LEFT, 4),
                new Movement(Direction.RIGHT, 1)
        );
    }

}