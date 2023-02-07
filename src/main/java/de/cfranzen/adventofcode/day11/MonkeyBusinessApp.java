package de.cfranzen.adventofcode.day11;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class MonkeyBusinessApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 11);
        calculatePart1(lines);
        calculatePart2(lines);
    }

    private static void calculatePart1(final List<String> lines) {
        var monkeys = new InputParser().parseMonkeys(lines);
        var calculator = new MonkeyBusinessCalculator(monkeys);
        calculator.performMultipleRounds(20);
        System.out.println("Part 1: " + calculator.monkeyBusinessLevel());
    }

    private static void calculatePart2(final List<String> lines) {
        var parser = new InputParser();
        var monkeys = parser.parseMonkeys(lines);
        var lcm = parser.parseLCM(lines);

        var calculator = new MonkeyBusinessCalculator(monkeys);
        calculator.performMultipleRounds(10000, wl -> wl.modulo(lcm));
        System.out.println("Part 2: " + calculator.monkeyBusinessLevel());
    }
}
