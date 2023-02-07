package de.cfranzen.adventofcode.day12;

import java.util.List;

class InputParser {

    public HeightMap parseHeightMap(final List<String> lines) {
        final char[][] map = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            map[i] = lines.get(i).toCharArray();
        }
        return new HeightMap(map);
    }

}
