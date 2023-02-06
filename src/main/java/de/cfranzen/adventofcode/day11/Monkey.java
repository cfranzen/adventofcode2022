package de.cfranzen.adventofcode.day11;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Monkey {

    private final int id;

    private final Function<WorryLevel, WorryLevel> worryLevelTransform;

    private final Predicate<WorryLevel> nextMonkeyPredicate;

    private final int nextMonkeyOnTrue;

    private final int nextMonkeyOnFalse;
    private final Deque<Item> items = new ArrayDeque<>();

    private long inspectedItemsCount = 0;

    public Monkey(final int id,
                  final Function<WorryLevel, WorryLevel> worryLevelTransform,
                  final Predicate<WorryLevel> nextMonkeyPredicate,
                  final int nextMonkeyOnTrue,
                  final int nextMonkeyOnFalse) {
        this.id = id;
        this.worryLevelTransform = worryLevelTransform;
        this.nextMonkeyPredicate = nextMonkeyPredicate;
        this.nextMonkeyOnTrue = nextMonkeyOnTrue;
        this.nextMonkeyOnFalse = nextMonkeyOnFalse;
    }


    public int id() {
        return id;
    }

    public long inspectedItemsCount() {
        return inspectedItemsCount;
    }

    public List<Item> items() {
        return List.copyOf(items);
    }

    public Monkey catchItem(final Item item) {
        items.addLast(item);
        return this;
    }

    public Monkey catchItems(final Collection<Item> items) {
        this.items.addAll(items);
        return this;
    }

    public List<ThrownItem> performTurn() {
        return performTurn(wl -> wl.floorDivideBy(3));
    }

    public List<ThrownItem> performTurn(final Function<WorryLevel, WorryLevel> worryLevelReduction) {
        final List<ThrownItem> thrownItems = new ArrayList<>(items.size());

        while (!items.isEmpty()) {
            var item = items.pollFirst();
            var newWorryLevel = worryLevelReduction.apply(worryLevelTransform.apply(item.worryLevel()));
            var updatedItem = item.updateWorryLevel(newWorryLevel);
            if (nextMonkeyPredicate.test(newWorryLevel)) {
                thrownItems.add(new ThrownItem(nextMonkeyOnTrue, updatedItem));
            } else {
                thrownItems.add(new ThrownItem(nextMonkeyOnFalse, updatedItem));
            }
        }

        inspectedItemsCount += thrownItems.size();

        return thrownItems;
    }
}
