package de.cfranzen.adventofcode.day2;


import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class RockPaperScissorsApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2022, 2);
        List<Round> part1Rounds = new InputParser().parseInput(lines);
        System.out.println("Part1: " + part1Rounds.stream().mapToInt(Round::getPlayer2Score).sum());

        List<Round> part2Rounds = new InputParser2().parseInput(lines);
        System.out.println("Part2: " + part2Rounds.stream().mapToInt(Round::getPlayer2Score).sum());
    }
}
