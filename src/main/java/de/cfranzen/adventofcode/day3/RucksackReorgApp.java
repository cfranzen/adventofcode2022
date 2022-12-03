package de.cfranzen.adventofcode.day3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class RucksackReorgApp {

    private static final Path inputFile = Paths.get("src/main/resources/day3/input.txt");


    public static void main(String[] args) {
        List<String> lines = getLines(inputFile);
        List<Rucksack> rucksacks = new InputParser().parseInput(lines);
        System.out.println("Part1: " + rucksacks.stream().mapToInt(r -> r.findDuplicate().getPriority()).sum());

        List<ElveGroup> elveGroups = new InputParser2().parseInput(lines);
        System.out.println("Part2: " + elveGroups.stream().mapToInt(g -> g.findDuplicate().getPriority()).sum());
    }

    private static List<String> getLines(Path inputFile) {
        try {
            return Files.readAllLines(inputFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
