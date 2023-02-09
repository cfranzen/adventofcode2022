package de.cfranzen.adventofcode.day15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SensorBeaconPairTest {

    @Test
    void testDistanceCalculation() {
        var sensor = Coordinate.of(8, 7);
        var beacon = Coordinate.of(2, 10);
        var pair = new SensorBeaconPair(sensor, beacon);
        assertThat(pair.distance()).isEqualTo(9);
    }
}