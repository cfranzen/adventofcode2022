package de.cfranzen.adventofcode.day3;

import java.util.ArrayList;
import java.util.List;

class InputParser2 {

    public List<ElveGroup> parseInput(final List<String> lines) {
        final List<Compartment> compartments = lines.stream().map(Compartment::fromString).toList();

        final List<ElveGroup> groups = new ArrayList<>();
        for (int i = 0; i < compartments.size(); i += 3) {
            groups.add(new ElveGroup(compartments.subList(i, i + 3)));
        }
        return groups;
    }
}
