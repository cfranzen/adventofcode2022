package de.cfranzen.adventofcode.day1;

import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.Comparator;
import java.util.List;

public class CalorieCountingApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2022, 1);
        List<Elve> elves = new InputParser().parseInput(lines);

        List<Elve> sortedElves = elves.stream().sorted(Comparator.comparing(Elve::getCalories).reversed()).toList();
        System.out.println("Max calories elve: " + sortedElves.get(0));
        System.out.println("Sum calories of top3 elves: " + sortedElves.stream()
                .limit(3)
                .mapToInt(Elve::getCalories)
                .sum());
    }
}
