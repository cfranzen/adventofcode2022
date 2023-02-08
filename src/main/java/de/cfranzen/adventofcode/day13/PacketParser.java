package de.cfranzen.adventofcode.day13;

import java.util.ArrayList;
import java.util.List;

public class PacketParser {

    private static final char LIST_START = '[';
    private static final char LIST_END = ']';
    private static final char DELIMITER = ',';

    private final String sequence;

    private int index;

    public PacketParser(final String sequence) {
        this.sequence = sequence;
    }

    public ListSignalValue parsePacket() {
        return parseList();
    }

    private SignalValue parseValue() {
        if (currentChar() == LIST_START) {
            return parseList();
        } else {
            return parseInt();
        }
    }

    private IntSignalValue parseInt() {
        final int startIndex = index;
        while (Character.isDigit(currentChar())) {
            index++;
        }
        final int value = Integer.parseInt(sequence.substring(startIndex, index));
        return IntSignalValue.of(value);
    }

    private ListSignalValue parseList() {
        // Skip list start symbol
        index++;

        final List<SignalValue> values = new ArrayList<>();
        while (index < sequence.length()) {
            if (currentChar() == LIST_END) {
                // Skip list end symbol
                index++;
                break;
            } else if (currentChar() == DELIMITER) {
                // Skip delimiter symbol
                index++;
                continue;
            } else {
                final SignalValue value = parseValue();
                values.add(value);
            }
        }
        return ListSignalValue.of(values);
    }


    private char currentChar() {
        return sequence.charAt(index);
    }
}
