package de.cfranzen.adventofcode.day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeHeightGridTest {

    private final int[][] grid = new int[][]{
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5, 3, 9, 0}
    };

    @Test
    void testVisibilityCalculation() {
        final TreeHeightGrid treeHeightGrid = createGrid();

        int visibleTrees = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (treeHeightGrid.isVisibleTree(i, j)) {
                    visibleTrees++;
                }
            }
        }

        assertThat(visibleTrees).isEqualTo(21);
    }

    @Test
    void testScenicScoreCalculation() {
        final TreeHeightGrid treeHeightGrid = createGrid();

        int maxScore = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                final int score = treeHeightGrid.getScenicScore(i, j);
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }

        assertThat(maxScore).isEqualTo(8);
    }

    private TreeHeightGrid createGrid() {
        final TreeHeightGrid treeHeightGrid = new TreeHeightGrid(grid.length, grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                treeHeightGrid.setTreeHeight(i, j, grid[i][j]);
            }
        }
        return treeHeightGrid;
    }
}