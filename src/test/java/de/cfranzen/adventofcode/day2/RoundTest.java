package de.cfranzen.adventofcode.day2;

import org.junit.jupiter.api.Test;

import static de.cfranzen.adventofcode.day2.RoundResult.*;
import static de.cfranzen.adventofcode.day2.Shape.*;
import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    void testRockDefeatsScissors() {
        // Given / When
        final Round round = new Round(ROCK, SCISSORS);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(PLAYER1_WINS);
        assertThat(round.getPlayer1Score()).isEqualTo(7);
        assertThat(round.getPlayer2Score()).isEqualTo(3);
    }

    @Test
    void testScissorsIsDefeadtedByRock() {
        // Given / When
        final Round round = new Round(SCISSORS, ROCK);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(PLAYER2_WINS);
        assertThat(round.getPlayer1Score()).isEqualTo(3);
        assertThat(round.getPlayer2Score()).isEqualTo(7);
    }

    @Test
    void testScissorsDefeatsPaper() {
        // Given / When
        final Round round = new Round(SCISSORS, PAPER);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(PLAYER1_WINS);
        assertThat(round.getPlayer1Score()).isEqualTo(9);
        assertThat(round.getPlayer2Score()).isEqualTo(2);
    }

    @Test
    void testPaperIsDefeatedByScissors() {
        // Given / When
        final Round round = new Round(PAPER, SCISSORS);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(PLAYER2_WINS);
        assertThat(round.getPlayer1Score()).isEqualTo(2);
        assertThat(round.getPlayer2Score()).isEqualTo(9);
    }

    @Test
    void testPaperDefeatsRock() {
        // Given / When
        final Round round = new Round(PAPER, ROCK);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(PLAYER1_WINS);
        assertThat(round.getPlayer1Score()).isEqualTo(8);
        assertThat(round.getPlayer2Score()).isEqualTo(1);
    }

    @Test
    void testRockIsDefeatedByPaper() {
        // Given / When
        final Round round = new Round(ROCK, PAPER);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(PLAYER2_WINS);
        assertThat(round.getPlayer1Score()).isEqualTo(1);
        assertThat(round.getPlayer2Score()).isEqualTo(8);
    }

    @Test
    void testRockDraw() {
        // Given / When
        final Round round = new Round(ROCK, ROCK);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(DRAW);
        assertThat(round.getPlayer1Score()).isEqualTo(4);
        assertThat(round.getPlayer2Score()).isEqualTo(4);
    }

    @Test
    void testPaperDraw() {
        // Given / When
        final Round round = new Round(PAPER, PAPER);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(DRAW);
        assertThat(round.getPlayer1Score()).isEqualTo(5);
        assertThat(round.getPlayer2Score()).isEqualTo(5);
    }

    @Test
    void testScissorsDraw() {
        // Given / When
        final Round round = new Round(SCISSORS, SCISSORS);

        // Then
        assertThat(round.getRoundResult()).isEqualTo(DRAW);
        assertThat(round.getPlayer1Score()).isEqualTo(6);
        assertThat(round.getPlayer2Score()).isEqualTo(6);
    }
}