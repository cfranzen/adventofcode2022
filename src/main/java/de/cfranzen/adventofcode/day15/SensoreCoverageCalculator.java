package de.cfranzen.adventofcode.day15;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SensoreCoverageCalculator {
    private final List<SensorBeaconPair> pairs;

    private final int minX;
    private final int maxX;

    public SensoreCoverageCalculator(final Collection<SensorBeaconPair> pairs) {
        this.pairs = List.copyOf(pairs);
        var maxX = 0;
        var minX = Integer.MAX_VALUE;
        for (var pair : pairs) {
            var sensor = pair.sensor();
            var distance = pair.distance();
            maxX = Math.max(maxX, sensor.x() + distance);
            minX = Math.min(minX, sensor.x() - distance);
        }
        this.minX = minX;
        this.maxX = maxX;
    }

    public Coordinate findUncoveredInArea(final int startX, final int startY, final int endX, final int endY) {
        final List<Coordinate> uncovered = pairs.stream()
                .flatMap(p -> p.uncoveredBorder().stream())
                .distinct()
                .filter(c -> c.x() >= startX && c.x() <= endX)
                .filter(c -> c.y() >= startY && c.y() <= endY)
                .filter(c -> pairs.stream().noneMatch(p -> p.covers(c)))
                .toList();

        if (uncovered.size() != 1) {
            throw new IllegalArgumentException("Could not find unique uncovered point in area: " + uncovered);
        }
        return uncovered.get(0);
    }

    public int getRowCoveredCount(final int y) {
        var count = 0;
        for (int x = minX; x <= maxX; x++) {
            for (var pair : pairs) {
                if (pair.covers(x, y)) {
                    count++;
                    break;
                }
            }
        }

        // Remove fields with sensor or beacon on it
        final Set<Coordinate> sensorsAndBeaconsOnRow = new HashSet<>();
        for (var pair : pairs) {
            if (pair.sensor().y() == y) {
                sensorsAndBeaconsOnRow.add(pair.sensor());
            }
            if (pair.beacon().y() == y) {
                sensorsAndBeaconsOnRow.add(pair.beacon());
            }
        }
        count -= sensorsAndBeaconsOnRow.size();
        return count;
    }
}
