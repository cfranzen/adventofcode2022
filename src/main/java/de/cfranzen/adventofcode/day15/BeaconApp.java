package de.cfranzen.adventofcode.day15;


import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;


public class BeaconApp {


    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 15);
        final List<SensorBeaconPair> pairs = new InputParser().parsePairs(lines);
        calculatePart1(pairs);
        calculatePart2(pairs);
    }

    private static void calculatePart1(final List<SensorBeaconPair> pairs) {
        final SensoreCoverageCalculator calculator = new SensoreCoverageCalculator(pairs);
        final int count = calculator.getRowCoveredCount(2000000);
        System.out.println("Part 1: " + count);
    }

    private static void calculatePart2(final List<SensorBeaconPair> pairs) {
        final SensoreCoverageCalculator calculator = new SensoreCoverageCalculator(pairs);
        final Coordinate uncovered = calculator.findUncoveredInArea(0, 0, 4000000, 4000000);
        var frequency = uncovered.x() * 4000000L + uncovered.y();
        System.out.println("Part 2: " + frequency);
    }


}
