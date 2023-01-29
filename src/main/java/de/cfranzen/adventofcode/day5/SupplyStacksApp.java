package de.cfranzen.adventofcode.day5;


import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;
import java.util.stream.Collectors;

public class SupplyStacksApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 5);
        solvePart1(lines);
        solvePart2(lines);
    }

    private static void solvePart1(List<String> lines) {
        final InputParser parser = new InputParser();
        final StackGroup group = parser.parseStackGroup(lines);

        final List<CrateMovement> movements = parser.parseMovements(lines);
        for (final CrateMovement movement : movements) {
            group.moveCrate(movement.repeat(), movement.from(), movement.to());
        }

        System.out.println("Part 1: " + group.getStackIds()
                .stream()
                .map(id -> String.valueOf(group.getStack(id).pop().id()))
                .collect(Collectors.joining()));
    }

    private static void solvePart2(List<String> lines) {
        final InputParser parser = new InputParser();
        final StackGroup group = parser.parseStackGroup(lines);

        final List<CrateMovement> movements = parser.parseMovements(lines);
        for (final CrateMovement movement : movements) {
            group.moveMultipleCrate(movement.repeat(), movement.from(), movement.to());
        }

        System.out.println("Part 2: " + group.getStackIds()
                .stream()
                .map(id -> String.valueOf(group.getStack(id).pop().id()))
                .collect(Collectors.joining()));
    }
}
