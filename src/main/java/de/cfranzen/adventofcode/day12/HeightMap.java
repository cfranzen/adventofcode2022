package de.cfranzen.adventofcode.day12;

import java.util.HashSet;
import java.util.Set;

public class HeightMap {

    public static final char START_MARKER = 'S';
    public static final char END_MARKER = 'E';

    private final char[][] map;

    private final int height;

    private final int width;

    private final Coordinate start;

    private final Coordinate end;

    private final Set<Coordinate> alternativeStarts = new HashSet<>();

    public HeightMap(final char[][] map) {
        this.map = map;
        this.height = map.length;
        this.width = map[0].length;

        Coordinate start = null;
        Coordinate end = null;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == START_MARKER) {
                    start = new Coordinate(x, y);
                } else if (map[y][x] == END_MARKER) {
                    end = new Coordinate(x, y);
                } else if (map[y][x] == 'a') {
                    alternativeStarts.add(new Coordinate(x, y));
                }
            }
        }
        this.start = start;
        this.end = end;
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public Coordinate start() {
        return start;
    }

    public Coordinate end() {
        return end;
    }

    public Set<Coordinate> alternativeStarts() {
        return Set.copyOf(alternativeStarts);
    }

    public boolean canMove(final int fromX, final int fromY, final Direction direction) {
        return canMove(new Coordinate(fromX, fromY), direction);
    }

    public boolean canMove(final Coordinate from, final Direction direction) {
        final Coordinate to = from.move(direction);
        if (to.x() < 0 || to.x() >= width || to.y() < 0 || to.y() >= height) {
            return false;
        }

        char start = map[from.y()][from.x()];
        char end = map[to.y()][to.x()];
        if (start == START_MARKER) {
            start = 'a';
        }
        if (end == START_MARKER) {
            end = 'a';
        } else if (end == END_MARKER) {
            end = 'z';
        }
        return start + 1 >= end;
    }
}
