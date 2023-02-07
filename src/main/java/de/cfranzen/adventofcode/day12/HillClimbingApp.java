package de.cfranzen.adventofcode.day12;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class HillClimbingApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 12);
        final HeightMap map = new InputParser().parseHeightMap(lines);
        calculatePart1(map);
        calculatePart2(map);
    }

    private static void calculatePart1(final HeightMap map) {
        final ShortestPathSearch search = new ShortestPathSearch(map);
        final int costs = search.findMinCostShortestPath();
        System.out.println("Part 1: " + costs);
    }

    private static void calculatePart2(final HeightMap map) {
        final ShortestPathSearch search = new ShortestPathSearch(map);
        final int costs = search.findAlternativeMinCostShortestPath();
        System.out.println("Part 2: " + costs);
    }
}
