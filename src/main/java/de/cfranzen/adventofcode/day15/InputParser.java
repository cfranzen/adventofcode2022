package de.cfranzen.adventofcode.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private final Pattern PATTERN = Pattern.compile("Sensor at x=([-+]?\\d+), y=([-+]?\\d+): closest beacon is at x=([-+]?\\d+), y=([-+]?\\d+)");

    public List<SensorBeaconPair> parsePairs(final List<String> lines) {
        final List<SensorBeaconPair> pairs = new ArrayList<>();
        lines.forEach(l -> parseLine(l, pairs));
        return pairs;
    }

    private void parseLine(final String line, final List<SensorBeaconPair> pairs) {
        final Matcher matcher = PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("unable to parse line: " + line);
        }

        var sensorX = Integer.parseInt(matcher.group(1));
        var sensorY = Integer.parseInt(matcher.group(2));
        var sensor = Coordinate.of(sensorX, sensorY);

        var beaconX = Integer.parseInt(matcher.group(3));
        var beaconY = Integer.parseInt(matcher.group(4));
        var beacon = Coordinate.of(beaconX, beaconY);

        pairs.add(new SensorBeaconPair(sensor, beacon));
    }
}
