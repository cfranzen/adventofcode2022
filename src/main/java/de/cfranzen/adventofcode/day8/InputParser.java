package de.cfranzen.adventofcode.day8;

import java.util.List;

class InputParser {

    public TreeHeightGrid parseGrid(final List<String> lines) {
        final int height = lines.size();
        final int width = lines.get(0).length();

        final TreeHeightGrid grid = new TreeHeightGrid(height, width);
        for (int i = 0; i < height; i++) {
            final String line = lines.get(i);
            for (int j = 0; j < width; j++) {
                final int treeHeigth = Integer.parseInt(line.substring(j, j + 1));
                grid.setTreeHeight(i, j, treeHeigth);
            }
        }
        return grid;
    }

}
