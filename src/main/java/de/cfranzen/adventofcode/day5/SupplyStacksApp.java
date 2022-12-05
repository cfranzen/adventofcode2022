package de.cfranzen.adventofcode.day5;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SupplyStacksApp {

    private static final Path inputFile = Paths.get("src/main/resources/day5/input.txt");


    public static void main(String[] args) {
        final List<String> lines = getLines(inputFile);
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

    private static List<String> getLines(Path inputFile) {
        try {
            return Files.readAllLines(inputFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
