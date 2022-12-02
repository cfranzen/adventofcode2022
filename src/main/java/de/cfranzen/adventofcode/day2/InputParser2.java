package de.cfranzen.adventofcode.day2;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static de.cfranzen.adventofcode.day2.RoundResult.*;
import static de.cfranzen.adventofcode.day2.Shape.*;

class InputParser2 {

    private static final Map<String, Shape> SHAPE_MAPPING = Map.of(
            "A", ROCK,
            "B", PAPER,
            "C", SCISSORS
    );

    private static final Map<String, RoundResult> RESULT_MAPPING = Map.of(
            "X", PLAYER1_WINS,
            "Y", DRAW,
            "Z", PLAYER2_WINS
    );
    private final static Pattern WHITESPACE = Pattern.compile("\\s+");

    public List<Round> parseInput(final List<String> lines) {
        return lines.stream().map(this::mapToRound).toList();
    }

    private Round mapToRound(final String line) {
        final String[] elements = WHITESPACE.split(line);
        final Shape player1 = SHAPE_MAPPING.get(elements[0]);
        final RoundResult result = RESULT_MAPPING.get(elements[1]);
        return switch(result){
            case PLAYER1_WINS -> new Round(player1, winsAgainst(player1));
            case PLAYER2_WINS -> new Round(player1, losesAgainst(player1));
            case DRAW -> new Round(player1, player1);
        };
    }

    private Shape winsAgainst(Shape shape) {
        return switch (shape){
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    private Shape losesAgainst(Shape shape) {
        return switch (shape){
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }
}
