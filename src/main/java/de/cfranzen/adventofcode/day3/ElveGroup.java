package de.cfranzen.adventofcode.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ElveGroup {

    private final List<Compartment> comparments;

    ElveGroup(Collection<Compartment> comparments) {
        this.comparments = new ArrayList<>(comparments);

        if (comparments.size() < 2) {
            throw new IllegalArgumentException("The must be at least 2 compartments in a ElveGroup");
        }
    }

    public ItemType findDuplicate() {
        return Compartment.findDuplicate(comparments);
    }

    @Override
    public String toString() {
        return "ElveGroup" + comparments;
    }
}
