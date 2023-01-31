package de.cfranzen.adventofcode.day7;

import java.util.List;

class InputParser {

    public Directory parseFilesystem(final List<String> lines) {
        final Directory root = Directory.newRoot();
        processLines(root, lines);
        return root;
    }

    private void processLines(final Directory root, final List<String> lines) {
        var currentDir = root;
        for (final String line : lines) {
            if (line.startsWith("$ ")) {
                if ("$ cd /".equals(line)) {
                    currentDir = root;
                } else if ("$ ls".equals(line)) {
                    // Just move to next line
                } else if ("$ cd ..".equals(line)) {
                    currentDir = currentDir.getParent();
                } else if (line.startsWith("$ cd ")) {
                    currentDir = currentDir.getDir(line.substring(5));
                } else {
                    throw new IllegalArgumentException("Unknown command: " + line);
                }
            } else {
                if (line.startsWith("dir ")) {
                    currentDir.mkdir(line.substring(4));
                } else {
                    final int delimiter = line.indexOf(' ');
                    final long size = Long.parseLong(line.substring(0, delimiter));
                    final String name = line.substring(delimiter + 1);
                    currentDir.createFile(name, size);
                }
            }
        }
    }
}
