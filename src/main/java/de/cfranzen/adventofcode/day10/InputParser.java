package de.cfranzen.adventofcode.day10;

import java.util.ArrayList;
import java.util.List;

class InputParser {

    public List<Instruction> parseInstructions(final List<String> lines) {
        var instructions = new ArrayList<Instruction>(lines.size());
        for (var line : lines) {
            if (line.startsWith("noop")) {
                instructions.add(new NoopInstruction());
            } else if (line.startsWith("addx ")) {
                final var arg = Integer.parseInt(line.substring(5));
                instructions.add(new AddxInstruction(arg));
            } else {
                throw new IllegalArgumentException("Unknown instruction " + line);
            }
        }
        return instructions;
    }

}
