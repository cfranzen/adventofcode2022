package de.cfranzen.adventofcode.day3;

class Rucksack {

    private final Compartment first;

    private final Compartment second;

    Rucksack(Compartment first, Compartment second) {
        this.first = first;
        this.second = second;
    }

    static Rucksack fromStrings(String firstComparment, String secondComparment) {
        return new Rucksack(Compartment.fromString(firstComparment), Compartment.fromString(secondComparment));
    }

    public ItemType findDuplicate() {
        return Compartment.findDuplicate(first, second);
    }

    @Override
    public String toString() {
        return "Rucksack{" + first + " / " + second + '}';
    }
}
