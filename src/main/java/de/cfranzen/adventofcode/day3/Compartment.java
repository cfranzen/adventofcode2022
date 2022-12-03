package de.cfranzen.adventofcode.day3;

import java.util.*;
import java.util.stream.Collectors;

class Compartment {

    private final Set<ItemType> items;

    Compartment(Collection<ItemType> items) {
        this.items = new LinkedHashSet<>(items);
    }

    static Compartment fromString(String typeString) {
        return new Compartment(typeString.chars().mapToObj(t -> new ItemType((char) t)).toList());
    }

    static ItemType findDuplicate(Compartment c1, Compartment c2) {
        return findDuplicate(List.of(c1, c2));
    }

    static ItemType findDuplicate(List<Compartment> comparments) {
        final Set<ItemType> intersection = new HashSet<>(comparments.get(0).items);
        for (int i = 1; i < comparments.size(); i++) {
            intersection.retainAll(comparments.get(i).items);
        }
        if (intersection.size() != 1) {
            throw new IllegalArgumentException("Unable to find a single duplicate in " +
                    "provided compartments found " + intersection.size());
        }
        return intersection.iterator().next();
    }

    @Override
    public String toString() {
        return "Compartment{'" + items.stream().map(it -> String.valueOf(it.type())).collect(Collectors.joining()) + "'}";
    }
}
