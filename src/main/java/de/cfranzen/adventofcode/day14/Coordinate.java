package de.cfranzen.adventofcode.day14;

public record Coordinate(int x, int y) {

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public Coordinate moveX(final int offset) {
        return new Coordinate(x + offset, y);
    }

    public Coordinate moveY(final int offset) {
        return new Coordinate(x, y + offset);
    }
}
