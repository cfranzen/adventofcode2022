package de.cfranzen.adventofcode.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SandSimulatorTest {

    private final List<Wall> walls = List.of(
            new Wall(Coordinate.of(498, 4), Coordinate.of(498, 6)),
            new Wall(Coordinate.of(498, 6), Coordinate.of(496, 6)),

            new Wall(Coordinate.of(503, 4), Coordinate.of(502, 4)),
            new Wall(Coordinate.of(502, 4), Coordinate.of(502, 9)),
            new Wall(Coordinate.of(502, 9), Coordinate.of(494, 9))
    );

    private final CaveMap map = new CaveMap(walls);

    @Test
    public void testSimulation() {
        final SandSimulator simulator = new SandSimulator(map);
        simulator.simulate();
        assertThat(simulator.sandCount()).isEqualTo(24);
    }
}