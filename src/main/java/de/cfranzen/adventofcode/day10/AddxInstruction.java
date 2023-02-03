package de.cfranzen.adventofcode.day10;

public class AddxInstruction implements Instruction {
    private final int argument;

    public AddxInstruction(int argument) {
        this.argument = argument;
    }

    @Override
    public void execute(final CpuPipeline cpu) {
        cpu.addx(this.argument);
    }
}
