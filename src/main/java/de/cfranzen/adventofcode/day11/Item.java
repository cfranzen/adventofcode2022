package de.cfranzen.adventofcode.day11;

public record Item(WorryLevel worryLevel) {

    public static Item of(final long worryLevel) {
        return new Item(new WorryLevel(worryLevel));
    }

    public Item updateWorryLevel(final WorryLevel newWorryLevel) {
        return new Item(newWorryLevel);
    }
}
