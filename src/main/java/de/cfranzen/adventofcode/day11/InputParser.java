package de.cfranzen.adventofcode.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputParser {


    public List<Monkey> parseMonkeys(final List<String> lines) {
        var monkeys = new ArrayList<Monkey>();
        for (var iter = lines.listIterator(); iter.hasNext(); ) {
            final String line = iter.next().trim();
            if (line.startsWith("Monkey ")) {
                var monkeyId = Integer.parseInt(line.substring(7).replace(":", ""));
                monkeys.add(parseMonkey(monkeyId, iter));
            }
        }
        return monkeys;
    }

    public long parseLCM(final List<String> lines) {
        final List<Long> values = new ArrayList<>();
        for (var line : lines) {
            final String trimmedLine = line.trim();
            if (trimmedLine.startsWith("Test: divisible by ")) {
                var divisor = Long.parseLong(trimmedLine.substring(19));
                values.add(divisor);
            }
        }
        return values.stream().mapToLong(Long::longValue).reduce((a, b) -> a * b).orElse(1);
    }

    private Monkey parseMonkey(final int monkeyId, final ListIterator<String> iter) {
        final List<Item> startingItems = parseStartingItems(monkeyId, iter.next().trim());
        final Function<WorryLevel, WorryLevel> operation = parseOperation(monkeyId, iter.next().trim());
        final Predicate<WorryLevel> predicate = parsePredicate(monkeyId, iter.next().trim());
        final int newMonkeyOnTrue = parseNextMonkey(monkeyId, iter.next().trim());
        final int newMonkeyOnFalse = parseNextMonkey(monkeyId, iter.next().trim());
        return new Monkey(monkeyId, operation, predicate, newMonkeyOnTrue, newMonkeyOnFalse)
                .catchItems(startingItems);
    }

    private List<Item> parseStartingItems(final int monkeyId, final String line) {
        if (line.startsWith("Starting items: ")) {
            return Arrays.stream(line.substring(16).split(","))
                    .mapToLong(s -> Long.parseLong(s.trim()))
                    .mapToObj(WorryLevel::new)
                    .map(Item::new)
                    .toList();
        } else {
            throw new IllegalArgumentException("Could not find starting items for monkey " + monkeyId + ": " + line);
        }
    }

    private Function<WorryLevel, WorryLevel> parseOperation(final int monkeyId, String line) {
        if (line.equals("Operation: new = old * old")) {
            return WorryLevel::squared;
        } else if (line.startsWith("Operation: new = old * ")) {
            var operand = Long.parseLong(line.substring(23));
            return wl -> wl.multipleBy(operand);
        } else if (line.startsWith("Operation: new = old + ")) {
            var operand = Long.parseLong(line.substring(23));
            return wl -> wl.add(operand);
        } else {
            throw new IllegalArgumentException("Could not find operation for monkey " + monkeyId + ": " + line);
        }
    }

    private Predicate<WorryLevel> parsePredicate(final int monkeyId, final String line) {
        if (line.startsWith("Test: divisible by ")) {
            var divisor = Long.parseLong(line.substring(19));
            return wl -> wl.isDivisibleBy(divisor);
        } else {
            throw new IllegalArgumentException("Could not find predicate for monkey " + monkeyId + ": " + line);
        }
    }

    private int parseNextMonkey(final int monkeyId, final String line) {
        final Pattern regex = Pattern.compile("If (true|false): throw to monkey (\\d+)");
        final Matcher matcher = regex.matcher(line);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Could not find next monkey for monkey " + monkeyId + ": " + line);
        }
    }
}
