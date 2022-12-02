package de.cfranzen.adventofcode.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static de.cfranzen.adventofcode.day2.Shape.*;
import static org.assertj.core.api.Assertions.assertThat;

class InputParser2Test {

    @Test
    void testParsing() {
        final InputParser2 parser = new InputParser2();

        final List<Round> rounds = parser.parseInput(List.of(
                "A Y",
                "B X",
                "C Z"
        ));

        assertThat(rounds).containsExactly(
                new Round(ROCK, ROCK),
                new Round(PAPER, ROCK),
                new Round(SCISSORS, ROCK)
        );
    }

}