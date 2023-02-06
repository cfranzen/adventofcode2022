package de.cfranzen.adventofcode.day11;

import java.util.*;
import java.util.function.Function;

public class MonkeyBusinessCalculator {

    private final List<Monkey> sortedMonkeys;
    private final Map<Integer, Monkey> mapIdToMonkey = new HashMap<>();

    public MonkeyBusinessCalculator(final Collection<Monkey> monkeys) {
        this.sortedMonkeys = monkeys.stream().sorted(Comparator.comparing(Monkey::id)).toList();
        for (var monkey : monkeys) {
            this.mapIdToMonkey.put(monkey.id(), monkey);
        }
    }

    public void performMultipleRounds(final int rounds) {
        for (int i = 0; i < rounds; i++) {
            performRound();
        }
    }

    public void performMultipleRounds(final int rounds, final Function<WorryLevel, WorryLevel> worryLevelReduction) {
        for (int i = 0; i < rounds; i++) {
            performRound(worryLevelReduction);
        }
    }

    public void performRound() {
        for (var monkey : sortedMonkeys) {
            final List<ThrownItem> thrownItems = monkey.performTurn();
            distributeItemsToMonkeys(thrownItems);
        }
    }

    public void performRound(final Function<WorryLevel, WorryLevel> worryLevelReduction) {
        for (var monkey : sortedMonkeys) {
            final List<ThrownItem> thrownItems = monkey.performTurn(worryLevelReduction);
            distributeItemsToMonkeys(thrownItems);
        }
    }

    private void distributeItemsToMonkeys(final List<ThrownItem> thrownItems) {
        for (var thrownItem : thrownItems) {
            mapIdToMonkey.get(thrownItem.targetMonkey()).catchItem(thrownItem.item());
        }
    }

    public long monkeyBusinessLevel() {
        final List<Monkey> mostActiveMonkeys = sortedMonkeys.stream()
                .sorted(Comparator.comparing(Monkey::inspectedItemsCount).reversed())
                .limit(2)
                .toList();
        return mostActiveMonkeys.get(0).inspectedItemsCount() * mostActiveMonkeys.get(1).inspectedItemsCount();
    }
}
