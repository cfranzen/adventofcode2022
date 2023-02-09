package de.cfranzen.adventofcode.day15;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SensoreCoverageCalculatorTest {

    private final List<SensorBeaconPair> pairs = List.of(
            new SensorBeaconPair(Coordinate.of(2, 18), Coordinate.of(-2, 15)),
            new SensorBeaconPair(Coordinate.of(9, 16), Coordinate.of(10, 16)),
            new SensorBeaconPair(Coordinate.of(13, 2), Coordinate.of(15, 3)),
            new SensorBeaconPair(Coordinate.of(12, 14), Coordinate.of(10, 16)),
            new SensorBeaconPair(Coordinate.of(10, 20), Coordinate.of(10, 16)),
            new SensorBeaconPair(Coordinate.of(14, 17), Coordinate.of(10, 16)),
            new SensorBeaconPair(Coordinate.of(8, 7), Coordinate.of(2, 10)),
            new SensorBeaconPair(Coordinate.of(2, 0), Coordinate.of(2, 10)),
            new SensorBeaconPair(Coordinate.of(0, 11), Coordinate.of(2, 10)),
            new SensorBeaconPair(Coordinate.of(20, 14), Coordinate.of(25, 17)),
            new SensorBeaconPair(Coordinate.of(17, 20), Coordinate.of(21, 22)),
            new SensorBeaconPair(Coordinate.of(16, 7), Coordinate.of(15, 3)),
            new SensorBeaconPair(Coordinate.of(14, 3), Coordinate.of(15, 3)),
            new SensorBeaconPair(Coordinate.of(20, 1), Coordinate.of(15, 3))
    );

    @Test
    void testCoverageCount() {
        final SensoreCoverageCalculator calculator = new SensoreCoverageCalculator(pairs);
        final int count = calculator.getRowCoveredCount(10);
        assertThat(count).isEqualTo(26);
    }

    @Test
    void testFindingUncovered() {
        final SensoreCoverageCalculator calculator = new SensoreCoverageCalculator(pairs);
        final Coordinate uncovered = calculator.findUncoveredInArea(0, 0, 20, 20);
        assertThat(uncovered).isEqualTo(Coordinate.of(14, 11));
    }
}