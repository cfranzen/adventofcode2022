package de.cfranzen.adventofcode.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void testCountingCalories() {
        // given
        final var lines = List.of("1000", "2000", "", "4000", "", "1000", "4000", "");
        final var parser = new InputParser();

        // when
        final List<Elve> elves = parser.parseInput(lines);

        // then
        assertThat(elves).containsExactly(
                new Elve("elve1", 3000),
                new Elve("elve2", 4000),
                new Elve("elve3", 5000)
        );
    }
}