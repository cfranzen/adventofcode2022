package de.cfranzen.adventofcode.day3;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

class RucksackReorgApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2022, 3);
        List<Rucksack> rucksacks = new InputParser().parseInput(lines);
        System.out.println("Part1: " + rucksacks.stream().mapToInt(r -> r.findDuplicate().getPriority()).sum());

        List<ElveGroup> elveGroups = new InputParser2().parseInput(lines);
        System.out.println("Part2: " + elveGroups.stream().mapToInt(g -> g.findDuplicate().getPriority()).sum());
    }
}
