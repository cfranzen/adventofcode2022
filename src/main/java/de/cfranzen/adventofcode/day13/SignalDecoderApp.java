package de.cfranzen.adventofcode.day13;

import de.cfranzen.adventofcode.util.InputDownloader;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Stream;

public class SignalDecoderApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 13);
        final List<Pair<ListSignalValue, ListSignalValue>> pairs = new InputParser().parseSignals(lines);
        calculatePart1(pairs);
        calculatePart2(pairs);
    }

    private static void calculatePart1(final List<Pair<ListSignalValue, ListSignalValue>> pairs) {
        final var comparator = new SignalValueComparator();
        var indexSum = 0;
        for (int i = 0; i < pairs.size(); i++) {
            final var pair = pairs.get(i);
            final int result = comparator.compare(pair.getLeft(), pair.getRight());
            if (result < 1) {
                indexSum += (i + 1);
            }
        }

        System.out.println("Part 1: " + indexSum);
    }

    private static void calculatePart2(final List<Pair<ListSignalValue, ListSignalValue>> pairs) {
        final var divider1 = ListSignalValue.of(ListSignalValue.of(IntSignalValue.of(2)));
        final var divider2 = ListSignalValue.of(ListSignalValue.of(IntSignalValue.of(6)));
        final var comparator = new SignalValueComparator();

        final var sorted = Stream.concat(
                        Stream.of(divider1, divider2),
                        pairs.stream().flatMap(p -> Stream.of(p.getLeft(), p.getRight()))
                )
                .sorted(comparator)
                .toList();

        final var index1 = sorted.indexOf(divider1) + 1;
        final var index2 = sorted.indexOf(divider2) + 1;
        System.out.println("Part 2: " + (index1 * index2));
    }
}
