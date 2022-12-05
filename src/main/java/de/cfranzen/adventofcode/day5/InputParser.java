package de.cfranzen.adventofcode.day5;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class InputParser {

    private static final Pattern WHITESPACE = Pattern.compile("\\s+");

    public StackGroup parseStackGroup(final List<String> lines) {
        final int separatorLineIndex = findSeparatorLine(lines);
        final List<Character> stackIds = findStackIds(lines.get(separatorLineIndex - 1));
        final StackGroup group = new StackGroup(stackIds);

        for (int i = separatorLineIndex - 2; i >= 0; i--) {
            final String line = lines.get(i);

            for (int j = 0; j < stackIds.size(); j++) {
                final int charPos = j * 4 + 1;
                char charAtPos = line.charAt(charPos);
                if (!Character.isSpaceChar(charAtPos)) {
                    group.getStack(stackIds.get(j)).push(new Crate(charAtPos));
                }
            }
        }
        return group;
    }

    public List<CrateMovement> parseMovements(final List<String> lines) {
        final int separatorLineIndex = findSeparatorLine(lines);
        return lines.stream().skip(separatorLineIndex + 1).map(InputParser::mapToMovement).toList();
    }

    private static List<Character> findStackIds(final String line) {
        return Arrays.stream(WHITESPACE.split(line.trim())).map(s -> s.charAt(0)).toList();
    }

    private static int findSeparatorLine(final List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (StringUtils.isBlank(lines.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private static CrateMovement mapToMovement(String line) {
        try {
            final String[] split = WHITESPACE.split(line);
            final int repeat = Integer.parseInt(split[1]);
            final char from = split[3].charAt(0);
            final char to = split[5].charAt(0);
            return new CrateMovement(repeat, from, to);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to parse movement from line '" + line + "'", e);
        }
    }
}
