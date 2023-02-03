package de.cfranzen.adventofcode.day10;

public class NoopInstruction implements Instruction {

    @Override
    public void execute(final CpuPipeline cpu) {
        cpu.noop();
    }
}
