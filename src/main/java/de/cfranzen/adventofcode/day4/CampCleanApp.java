package de.cfranzen.adventofcode.day4;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CampCleanApp {
    private static final Path inputFile = Paths.get("src/main/resources/day4/input.txt");


    public static void main(String[] args) {
        List<String> lines = getLines(inputFile);
        List<AssignmentPair> pairs = new InputParser().parseInput(lines);
        System.out.println("Part1: " + pairs.stream().filter(AssignmentPair::isOneRangeContainingTheOther).count());
        System.out.println("Part2: " + pairs.stream().filter(AssignmentPair::isOneRangeOverlappingTheOther).count());
    }

    private static List<String> getLines(Path inputFile) {
        try {
            return Files.readAllLines(inputFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
