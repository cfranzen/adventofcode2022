package de.cfranzen.adventofcode.day4;


import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class CampCleanApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2022, 4);
        List<AssignmentPair> pairs = new InputParser().parseInput(lines);
        System.out.println("Part1: " + pairs.stream().filter(AssignmentPair::isOneRangeContainingTheOther).count());
        System.out.println("Part2: " + pairs.stream().filter(AssignmentPair::isOneRangeOverlappingTheOther).count());
    }
}
