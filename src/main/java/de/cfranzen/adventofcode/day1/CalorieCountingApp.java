package de.cfranzen.adventofcode.day1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class CalorieCountingApp {

    private static final Path inputFile = Paths.get("src/main/resources/day1/input.txt");

    public static void main(String[] args) {
        List<String> lines = getLines(inputFile);
        List<Elve> elves = new InputParser().parseInput(lines);

        List<Elve> sortedElves = elves.stream().sorted(Comparator.comparing(Elve::getCalories).reversed()).toList();
        System.out.println("Max calories elve: " + sortedElves.get(0));
        System.out.println("Sum calories of top3 elves: " + sortedElves.stream()
                .limit(3)
                .mapToInt(Elve::getCalories)
                .sum());
    }

    private static List<String> getLines(Path inputFile) {
        try {
            return Files.readAllLines(inputFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
