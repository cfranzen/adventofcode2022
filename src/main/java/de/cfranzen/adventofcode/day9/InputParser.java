package de.cfranzen.adventofcode.day9;

import java.util.ArrayList;
import java.util.List;

class InputParser {

    public List<Movement> parseMovements(final List<String> lines) {
        var movements = new ArrayList<Movement>(lines.size());
        for (var line : lines) {
            final int pos = line.indexOf(' ');
            var direction = determineDirection(line.substring(0, pos));
            var distance = Integer.parseInt(line.substring(pos + 1));
            movements.add(new Movement(direction, distance));
        }
        return movements;
    }

    private Direction determineDirection(String direction) {
        return switch (direction) {
            case "U" -> Direction.UP;
            case "D" -> Direction.DOWN;
            case "R" -> Direction.RIGHT;
            case "L" -> Direction.LEFT;
            default -> throw new IllegalArgumentException("Unable to handle direction " + direction);
        };
    }

}
