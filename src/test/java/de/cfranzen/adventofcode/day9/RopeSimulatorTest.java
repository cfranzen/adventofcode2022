package de.cfranzen.adventofcode.day9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static de.cfranzen.adventofcode.day9.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class RopeSimulatorTest {

    @Test
    void testTailPositionCounting_TwoKnots() {
        final List<Movement> movements = List.of(
                new Movement(RIGHT, 4),
                new Movement(UP, 4),
                new Movement(LEFT, 3),
                new Movement(DOWN, 1),
                new Movement(RIGHT, 4),
                new Movement(DOWN, 1),
                new Movement(LEFT, 5),
                new Movement(RIGHT, 2)
        );

        final RopeSimulator simulator = new RopeSimulator(2);

        for (var move : movements) {
            simulator.processMove(move);
        }

        assertThat(simulator.getTailPositionCount()).isEqualTo(13);
    }

    @Test
    void testTailPositionCounting_TenKnots() {
        final List<Movement> movements = List.of(
                new Movement(RIGHT, 5),
                new Movement(UP, 8),
                new Movement(LEFT, 8),
                new Movement(DOWN, 3),
                new Movement(RIGHT, 17),
                new Movement(DOWN, 10),
                new Movement(LEFT, 25),
                new Movement(UP, 20)
        );

        final RopeSimulator simulator = new RopeSimulator(10);

        for (var move : movements) {
            simulator.processMove(move);
        }

        assertThat(simulator.getTailPositionCount()).isEqualTo(36);
    }
}