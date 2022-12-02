package de.cfranzen.adventofcode.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static de.cfranzen.adventofcode.day2.Shape.*;
import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void testParsing() {
        final InputParser parser = new InputParser();

        final List<Round> rounds = parser.parseInput(List.of(
                "A Y",
                "B X",
                "C Z"
        ));

        assertThat(rounds).containsExactly(
                new Round(ROCK, PAPER),
                new Round(PAPER, ROCK),
                new Round(SCISSORS, SCISSORS)
        );
    }

}