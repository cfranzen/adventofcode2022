package de.cfranzen.adventofcode.day8;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class TreeHeightApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 8);
        final TreeHeightGrid grid = new InputParser().parseGrid(lines);
        calculatePart1(grid);
        calculatePart2(grid);
    }

    private static void calculatePart1(final TreeHeightGrid grid) {
        int visibleTrees = 0;
        for (int i = 0; i < grid.getGridHeight(); i++) {
            for (int j = 0; j < grid.getGridWidth(); j++) {
                if (grid.isVisibleTree(i, j)) {
                    visibleTrees++;
                }
            }
        }
        System.out.println("Part 1: " + visibleTrees);
    }

    private static void calculatePart2(TreeHeightGrid grid) {
        int maxScore = 0;
        for (int i = 0; i < grid.getGridHeight(); i++) {
            for (int j = 0; j < grid.getGridWidth(); j++) {
                final int score = grid.getScenicScore(i, j);
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }
        System.out.println("Part 2: " + maxScore);
    }

}
