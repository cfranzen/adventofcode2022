package de.cfranzen.adventofcode.day2;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static de.cfranzen.adventofcode.day2.Shape.*;

class InputParser {

    private static final Map<String, Shape> MAPPING = Map.of(
            "A", ROCK,
            "B", PAPER,
            "C", SCISSORS,
            "X", ROCK,
            "Y", PAPER,
            "Z", SCISSORS
    );
    private final static Pattern WHITESPACE = Pattern.compile("\\s+");

    public List<Round> parseInput(final List<String> lines) {
        return lines.stream().map(this::mapToRound).toList();
    }

    private Round mapToRound(final String line) {
        final String[] elements = WHITESPACE.split(line);
        final Shape player1 = MAPPING.get(elements[0]);
        final Shape player2 = MAPPING.get(elements[1]);
        return new Round(player1, player2);
    }
}
