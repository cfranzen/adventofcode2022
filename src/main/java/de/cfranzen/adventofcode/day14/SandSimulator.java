package de.cfranzen.adventofcode.day14;

public class SandSimulator {

    private final Coordinate entry;

    private final CaveMap map;

    private int sandCount = 0;

    public SandSimulator(final CaveMap map) {
        this(map, Coordinate.of(500, 0));
    }

    public SandSimulator(final CaveMap map, final Coordinate entry) {
        this.entry = entry;
        this.map = map;
    }

    public void simulate() {
        Coordinate restPoint;
        while ((restPoint = findNextPointOfRest()) != null) {
            map.putSand(restPoint);
            sandCount++;

            if (restPoint == entry) {
                return;
            }
        }
    }

    public int sandCount() {
        return sandCount;
    }

    private Coordinate findNextPointOfRest() {
        var current = entry;

        while (true) {
            var next = current.moveY(1);
            if (next.y() >= map.height()) {
                // We are falling off the map
                return null;
            } else if (!map.isBlocked(next)) {
                current = next;
                continue;
            }

            next = next.moveX(-1);
            if (next.x() < 0) {
                // We are falling off the map
                return null;
            } else if (!map.isBlocked(next)) {
                current = next;
                continue;
            }

            next = next.moveX(2);
            if (next.x() >= map.width()) {
                // We are falling off the map
                return null;
            } else if (!map.isBlocked(next)) {
                current = next;
            } else {
                break;
            }
        }
        return current;
    }
}
