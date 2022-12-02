package de.cfranzen.adventofcode.day2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.Objects;

import static de.cfranzen.adventofcode.day2.RoundResult.*;
import static de.cfranzen.adventofcode.day2.Shape.*;

class Round {

    private static final Map<Pair<Shape, Shape>, RoundResult> RESULT_MAPPING = Map.of(
            Pair.of(ROCK, ROCK), DRAW,
            Pair.of(ROCK, PAPER), PLAYER2_WINS,
            Pair.of(ROCK, SCISSORS), PLAYER1_WINS,
            Pair.of(PAPER, ROCK), PLAYER1_WINS,
            Pair.of(PAPER, PAPER), DRAW,
            Pair.of(PAPER, SCISSORS), PLAYER2_WINS,
            Pair.of(SCISSORS, ROCK), PLAYER2_WINS,
            Pair.of(SCISSORS, PAPER), PLAYER1_WINS,
            Pair.of(SCISSORS, SCISSORS), DRAW
    );
    public static final int SCORE_WIN = 6;
    public static final int SCORE_LOST = 0;
    public static final int SCORE_DRAW = 3;

    private final Shape player1Shape;

    private final Shape player2Shape;

    private final RoundResult roundResult;

    public Round(Shape player1Shape, Shape player2Shape) {
        this.player1Shape = player1Shape;
        this.player2Shape = player2Shape;
        this.roundResult = RESULT_MAPPING.get(Pair.of(player1Shape, player2Shape));
    }

    public RoundResult getRoundResult() {
        return roundResult;
    }

    public int getPlayer1Score() {
        return player1Shape.getScore() + switch (roundResult) {
            case PLAYER1_WINS -> SCORE_WIN;
            case PLAYER2_WINS -> SCORE_LOST;
            case DRAW -> SCORE_DRAW;
        };
    }

    public int getPlayer2Score() {
        return player2Shape.getScore() + switch (roundResult) {
            case PLAYER1_WINS -> SCORE_LOST;
            case PLAYER2_WINS -> SCORE_WIN;
            case DRAW -> SCORE_DRAW;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return player1Shape == round.player1Shape && player2Shape == round.player2Shape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Shape, player2Shape);
    }

    @Override
    public String toString() {
        return "Round{player1=" + player1Shape + ", player2=" + player2Shape + '}';
    }
}
