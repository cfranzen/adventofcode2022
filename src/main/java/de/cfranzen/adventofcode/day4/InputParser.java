package de.cfranzen.adventofcode.day4;


import java.util.List;

class InputParser {

    public List<AssignmentPair> parseInput(final List<String> lines) {
        return lines.stream().map(this::mapToAssignmentPair).toList();
    }

    private AssignmentPair mapToAssignmentPair(final String line) {
        final int commaPos = line.indexOf(',');
        if (commaPos < 0) {
            throw new IllegalArgumentException("Found line without a comma: " + line);
        }
        final String firstRange = line.substring(0, commaPos);
        final String secondRange = line.substring(commaPos + 1);
        return new AssignmentPair(IntRange.fromString(firstRange), IntRange.fromString(secondRange));
    }
}
