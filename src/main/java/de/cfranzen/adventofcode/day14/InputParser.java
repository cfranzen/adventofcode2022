package de.cfranzen.adventofcode.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<Wall> parseWalls(final List<String> lines) {
        final List<Wall> walls = new ArrayList<>();
        lines.forEach(l -> parseLine(l, walls));
        return walls;
    }

    private void parseLine(final String line, final List<Wall> walls) {
        final List<Coordinate> coordinates = Arrays.stream(line.split(" -> "))
                .map(InputParser::parseCoordinates)
                .toList();

        for (int i = 1; i < coordinates.size(); i++) {
            final Coordinate start = coordinates.get(i - 1);
            final Coordinate end = coordinates.get(i);
            walls.add(new Wall(start, end));
        }
    }

    private static Coordinate parseCoordinates(final String str) {
        final int pos = str.indexOf(',');
        final int x = Integer.parseInt(str.substring(0, pos));
        final int y = Integer.parseInt(str.substring(pos + 1));
        return Coordinate.of(x, y);
    }
}
