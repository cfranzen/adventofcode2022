package de.cfranzen.adventofcode.day8;

import java.util.Arrays;

public class TreeHeightGrid {

    private final int[][] grid;

    public TreeHeightGrid(final int height, final int width) {
        this.grid = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(this.grid[i], 0);
        }
    }

    public int getGridHeight() {
        return this.grid.length;
    }

    public int getGridWidth() {
        return this.grid[0].length;
    }

    public void setTreeHeight(final int row, final int column, final int treeHeight) {
        validateGridPosition(row, column);
        if (treeHeight < 0 || treeHeight > 9) {
            throw new IllegalArgumentException("Tree height must be a value between 0 und 9, but value "
                    + treeHeight + " specified for position (" + row + ";" + column + ")");
        }
        this.grid[row][column] = treeHeight;
    }

    public boolean isVisibleTree(final int row, final int column) {
        validateGridPosition(row, column);
        return isVisibleFromEdge(row, column, 1, 0) ||
                isVisibleFromEdge(row, column, -1, 0) ||
                isVisibleFromEdge(row, column, 0, 1) ||
                isVisibleFromEdge(row, column, 0, -1);
    }

    public int getScenicScore(final int row, final int column) {
        validateGridPosition(row, column);
        return countTreesVisibleFromPosition(row, column, 1, 0) *
                countTreesVisibleFromPosition(row, column, -1, 0) *
                countTreesVisibleFromPosition(row, column, 0, 1) *
                countTreesVisibleFromPosition(row, column, 0, -1);
    }

    private void validateGridPosition(final int row, final int column) {
        if (row < 0 || row >= getGridHeight()) {
            throw new IllegalArgumentException("Invalid value " + row + " for row");
        }
        if (column < 0 || column >= getGridWidth()) {
            throw new IllegalArgumentException("Invalid value " + column + " for column");
        }
    }

    private boolean isVisibleFromEdge(final int row, final int column,
                                      final int rowIncrement, final int columnIncrement) {
        final int treeHeight = this.grid[row][column];
        int i = row + rowIncrement;
        int j = column + columnIncrement;
        while (i >= 0 && j >= 0 && i < getGridHeight() && j < getGridWidth()) {
            if (this.grid[i][j] >= treeHeight) {
                return false;
            }
            i += rowIncrement;
            j += columnIncrement;
        }
        return true;
    }

    private int countTreesVisibleFromPosition(final int row, final int column,
                                              final int rowIncrement, final int columnIncrement) {
        final int treeHeight = this.grid[row][column];
        int i = row + rowIncrement;
        int j = column + columnIncrement;
        int count = 0;
        while (i >= 0 && j >= 0 && i < getGridHeight() && j < getGridWidth()) {
            count++;
            if (this.grid[i][j] >= treeHeight) {
                break;
            }
            i += rowIncrement;
            j += columnIncrement;
        }
        return count;
    }
}
