package de.cfranzen.adventofcode.day15;

public record Coordinate(int x, int y) {

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public int distanceTo(final Coordinate other) {
        return Math.abs(x - other.x()) + Math.abs(y - other.y());
    }

    public int distanceTo(final int otherX, final int otherY) {
        return Math.abs(x - otherX) + Math.abs(y - otherY);
    }
}
