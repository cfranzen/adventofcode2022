package de.cfranzen.adventofcode.day2;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RockPaperScissorsApp {

    private static final Path inputFile = Paths.get("src/main/resources/day2/input.txt");


    public static void main(String[] args) {
        List<String> lines = getLines(inputFile);
        List<Round> part1Rounds = new InputParser().parseInput(lines);
        System.out.println("Part1: " + part1Rounds.stream().mapToInt(Round::getPlayer2Score).sum());

        List<Round> part2Rounds = new InputParser2().parseInput(lines);
        System.out.println("Part2: " + part2Rounds.stream().mapToInt(Round::getPlayer2Score).sum());
    }

    private static List<String> getLines(Path inputFile) {
        try {
            return Files.readAllLines(inputFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
