package de.cfranzen.adventofcode.day14;

import java.util.Arrays;
import java.util.Collection;

public class CaveMap {

    public static final char SYMBOL_AIR = '.';
    public static final char SYMBOL_ROCK = '#';
    public static final char SYMBOL_SAND = 'o';
    public static final char SYMBOL_START = '+';

    private final Coordinate entry;

    private final char[][] map;

    public CaveMap(final Collection<Wall> walls) {
        this(walls, Coordinate.of(500, 0));
    }

    public CaveMap(final Collection<Wall> walls, final Coordinate entry) {
        this.entry = entry;
        var maxX = entry.x();
        var maxY = entry.y();
        for (var wall : walls) {
            maxX = Math.max(maxX, wall.start().x());
            maxX = Math.max(maxX, wall.end().x());
            maxY = Math.max(maxY, wall.start().y());
            maxY = Math.max(maxY, wall.end().y());
        }
        this.map = new char[maxY + 1][maxX + 1];
        fillMap(walls);
    }

    public boolean isBlocked(final Coordinate coordinate) {
        final char mapValue = map[coordinate.y()][coordinate.x()];
        return mapValue == SYMBOL_ROCK || mapValue == SYMBOL_SAND;
    }

    public void putSand(final Coordinate coordinate) {
        map[coordinate.y()][coordinate.x()] = SYMBOL_SAND;
    }

    public int height() {
        return map.length;
    }

    public int width() {
        return map[0].length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(map.length * map[0].length);
        final int minX = findMinXWithoutAir();

        for (int y = 0; y < map.length; y++) {
            for (int x = minX; x < map[y].length; x++) {
                sb.append(map[y][x]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private void fillMap(final Collection<Wall> walls) {
        for (int y = 0; y < map.length; y++) {
            Arrays.fill(map[y], SYMBOL_AIR);
        }
        walls.forEach(this::drawWall);
        map[entry.y()][entry.x()] = SYMBOL_START;
    }

    private void drawWall(final Wall wall) {
        final Coordinate start = wall.start();
        final Coordinate end = wall.end();
        var deltaX = start.x() - end.x();
        var deltaY = start.y() - end.y();

        if (deltaX == 0) {
            // Move in y direction
            var offset = -1 * Integer.signum(deltaY);
            var x = start.x();
            for (int y = start.y(); y != end.y() + offset; y += offset) {
                map[y][x] = SYMBOL_ROCK;
            }
        } else if (deltaY == 0) {
            // Move in x direction
            var offset = -1 * Integer.signum(deltaX);
            var y = start.y();
            for (int x = start.x(); x != end.x() + offset; x += offset) {
                map[y][x] = SYMBOL_ROCK;
            }
        } else {
            throw new IllegalArgumentException("Diagonal walls are not supported");
        }
    }

    private int findMinXWithoutAir() {
        for (int x = 0; x < map[0].length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (map[y][x] != SYMBOL_AIR) {
                    return x;
                }
            }
        }
        return 0;
    }
}
