package de.cfranzen.adventofcode.day12;

public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    RIGHT(0, 1),
    LEFT(0, -1);
    private final int heightIncrement;
    private final int widthIncrement;

    Direction(int heightIncrement, int widthIncrement) {
        this.heightIncrement = heightIncrement;
        this.widthIncrement = widthIncrement;
    }

    public int getHeightIncrement() {
        return heightIncrement;
    }

    public int getWidthIncrement() {
        return widthIncrement;
    }
}
