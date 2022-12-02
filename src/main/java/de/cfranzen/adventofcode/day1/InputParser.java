package de.cfranzen.adventofcode.day1;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

class InputParser {
    private int elveCounter = 0;

    public List<Elve> parseInput(final List<String> lines) {
        Elve currentElve = createNewElve();

        final List<Elve> elves = new ArrayList<>();

        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                elves.add(currentElve);
                currentElve = createNewElve();
            } else {
                int calories = Integer.parseInt(line);
                currentElve.addCalories(calories);
            }
        }

        if (currentElve.getCalories() > 0) {
            elves.add(currentElve);
        }

        return elves;
    }

    private Elve createNewElve() {
        elveCounter++;
        return new Elve("elve" + elveCounter);
    }
}
