package de.cfranzen.adventofcode.day14;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;


public class SandyCaveApp {

    private static final Coordinate ENTRY = Coordinate.of(500, 0);

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 14);
        final List<Wall> walls = new InputParser().parseWalls(lines);
        calculatePart1(walls);
        calculatePart2(walls);
    }

    private static void calculatePart1(final List<Wall> walls) {
        final CaveMap map = new CaveMap(walls, ENTRY);
        final SandSimulator simulator = new SandSimulator(map, ENTRY);
        simulator.simulate();
        System.out.println("Part 1: " + simulator.sandCount());
    }

    private static void calculatePart2(final List<Wall> walls) {
        var maxY = 0;
        for (var wall : walls) {
            maxY = Math.max(maxY, wall.start().y());
            maxY = Math.max(maxY, wall.end().y());
        }
        var floorWall = new Wall(Coordinate.of(0, maxY + 2), Coordinate.of(ENTRY.x() * 2, maxY + 2));
        walls.add(floorWall);

        final CaveMap map = new CaveMap(walls, ENTRY);
        final SandSimulator simulator = new SandSimulator(map, ENTRY);
        simulator.simulate();
        System.out.println("Part 2: " + simulator.sandCount());
    }


}
