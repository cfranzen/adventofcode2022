package de.cfranzen.adventofcode.day10;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class CpuPipelineApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 10);
        final List<Instruction> instructions = new InputParser().parseInstructions(lines);
        calculatePart1(instructions);
        calculatePart2(instructions);
    }

    private static void calculatePart1(final List<Instruction> instructions) {
        final CpuPipeline cpu = new CpuPipeline();
        for (var instruction : instructions) {
            instruction.execute(cpu);
        }

        var sum = cpu.getSignalStrength(20)
                + cpu.getSignalStrength(60)
                + cpu.getSignalStrength(100)
                + cpu.getSignalStrength(140)
                + cpu.getSignalStrength(180)
                + cpu.getSignalStrength(220);
        System.out.println("Part 1:" + sum);
    }

    private static void calculatePart2(final List<Instruction> instructions) {
        final CpuPipeline cpu = new CpuPipeline();
        for (var instruction : instructions) {
            instruction.execute(cpu);
        }

        System.out.println("\n-------- Part 2 ---------");
        new CRT().print(cpu);
    }
}
