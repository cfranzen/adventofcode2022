package de.cfranzen.adventofcode.day7;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.ArrayList;
import java.util.List;

public class FilesystemApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 7);
        final Directory root = new InputParser().parseFilesystem(lines);
        calculatePart1(root);
        calculatePart2(root);
    }

    private static void calculatePart1(final Directory root) {
        final List<Directory> allDirs = new ArrayList<>();
        allDirs.add(root);

        for (int i = 0; i < allDirs.size(); i++) {
            final List<Directory> subdirs = allDirs.get(i).getSubDirs();
            allDirs.addAll(subdirs);
        }

        long totalSize = 0;
        for (var dir : allDirs) {
            final long size = dir.getSize();
            if (size <= 100000) {
                totalSize += size;
            }
        }
        System.out.println("Part 1: " + totalSize);
    }

    private static void calculatePart2(final Directory root) {
        final long diskSpace = 70000000;
        final long requiredSpace = 30000000;
        final long usedSpace = root.getSize();
        final long unusedSpace = diskSpace - usedSpace;
        final long missingSpace = requiredSpace - unusedSpace;

        final List<Directory> allDirs = new ArrayList<>();
        allDirs.add(root);

        for (int i = 0; i < allDirs.size(); i++) {
            final List<Directory> subdirs = allDirs.get(i).getSubDirs();
            allDirs.addAll(subdirs);
        }

        long minSize = Long.MAX_VALUE;
        for (var dir : allDirs) {
            final long size = dir.getSize();
            if (size <= minSize && size >= missingSpace) {
                minSize = size;
            }
        }
        System.out.println("Part 2: " + minSize);
    }
}
