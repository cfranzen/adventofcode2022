package de.cfranzen.adventofcode.day6;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class DatastreamDecoderApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 6);
        final DataStreamBuffer ds = new DataStreamBuffer(lines.get(0));
        System.out.println("Part 1: " + ds.findFirstMarker(4));
        System.out.println("Part 2: " + ds.findFirstMarker(14));
    }
}
