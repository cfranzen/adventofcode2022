package de.cfranzen.adventofcode.day12;

public record Coordinate(int x, int y) {

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public Coordinate move(final Direction direction) {
        return new Coordinate(x + direction.getWidthIncrement(), y + direction.getHeightIncrement());
    }
}
