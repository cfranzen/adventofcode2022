package de.cfranzen.adventofcode.day9;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class RopeSimulationApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 9);
        final List<Movement> movements = new InputParser().parseMovements(lines);
        calculatePart1(movements);
        calculatePart2(movements);
    }

    private static void calculatePart1(final List<Movement> movements) {
        final RopeSimulator simulator = new RopeSimulator(2);
        for (var move : movements) {
            simulator.processMove(move);
        }

        System.out.println("Part 1: " + simulator.getTailPositionCount());
    }

    private static void calculatePart2(final List<Movement> movements) {
        final RopeSimulator simulator = new RopeSimulator(10);
        for (var move : movements) {
            simulator.processMove(move);
        }

        System.out.println("Part 2: " + simulator.getTailPositionCount());
    }
}
