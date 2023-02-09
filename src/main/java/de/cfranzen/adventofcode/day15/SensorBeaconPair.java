package de.cfranzen.adventofcode.day15;


import java.util.ArrayList;
import java.util.Collection;

public class SensorBeaconPair {

    private final Coordinate sensor;

    private final Coordinate beacon;

    private final int distance;

    public SensorBeaconPair(final Coordinate sensor, final Coordinate beacon) {
        this.sensor = sensor;
        this.beacon = beacon;
        this.distance = sensor.distanceTo(beacon);
    }

    public Coordinate sensor() {
        return sensor;
    }

    public Coordinate beacon() {
        return beacon;
    }

    public int distance() {
        return distance;
    }

    public Collection<Coordinate> uncoveredBorder() {
        var border = new ArrayList<Coordinate>();
        var borderDistance = distance + 1;

        var offsetX = borderDistance;
        for (int offsetY = 0; offsetY <= borderDistance; offsetY++) {
            border.add(Coordinate.of(sensor.x() + offsetX, sensor.y() + offsetY));
            border.add(Coordinate.of(sensor.x() - offsetX, sensor.y() + offsetY));
            border.add(Coordinate.of(sensor.x() + offsetX, sensor.y() - offsetY));
            border.add(Coordinate.of(sensor.x() - offsetX, sensor.y() - offsetY));
            offsetX--;
        }
        return border;
    }

    public boolean covers(final Coordinate other) {
        return sensor.distanceTo(other) <= distance;
    }

    public boolean covers(final int otherX, final int otherY) {
        return sensor.distanceTo(otherX, otherY) <= distance;
    }
}
