package de.cfranzen.adventofcode.day11;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;

public class MonkeyBusinessApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 11);
        final InputParser parser = new InputParser();
        final List<Monkey> monkeys = parser.parseMonkeys(lines);
        final long lcm = parser.parseLCM(lines);
        calculatePart1(monkeys);
        calculatePart2(monkeys, lcm);
    }

    private static void calculatePart1(final List<Monkey> monkeys) {
        var calculator = new MonkeyBusinessCalculator(monkeys);
        calculator.performMultipleRounds(20);
        System.out.println("Part 1: " + calculator.monkeyBusinessLevel());
    }

    private static void calculatePart2(final List<Monkey> monkeys, final long lcm) {
        var calculator = new MonkeyBusinessCalculator(monkeys);
        calculator.performMultipleRounds(10000, wl -> wl.modulo(lcm));
        System.out.println("Part 2: " + calculator.monkeyBusinessLevel());
    }
}
