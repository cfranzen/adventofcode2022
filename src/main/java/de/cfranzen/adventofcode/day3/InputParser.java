package de.cfranzen.adventofcode.day3;

import java.util.List;

class InputParser {

    public List<Rucksack> parseInput(final List<String> lines) {
        return lines.stream().map(this::mapToRucksack).toList();
    }

    private Rucksack mapToRucksack(final String line) {
        final int splitPos = line.length() / 2;
        final String first = line.substring(0, splitPos);
        final String second = line.substring(splitPos);
        return Rucksack.fromStrings(first, second);
    }
}
