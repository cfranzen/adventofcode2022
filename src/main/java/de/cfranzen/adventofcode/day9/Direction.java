package de.cfranzen.adventofcode.day9;

public enum Direction {
    UP(1, 0),
    DOWN(-1, 0),
    RIGHT(0, 1),
    LEFT(0, -1);
    private final int rowIncrement;
    private final int columnIncrement;

    Direction(int rowIncrement, int columnIncrement) {
        this.rowIncrement = rowIncrement;
        this.columnIncrement = columnIncrement;
    }

    public int getRowIncrement() {
        return rowIncrement;
    }

    public int getColumnIncrement() {
        return columnIncrement;
    }
}
