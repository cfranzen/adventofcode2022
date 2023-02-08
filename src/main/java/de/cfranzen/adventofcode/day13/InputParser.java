package de.cfranzen.adventofcode.day13;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

class InputParser {

    public List<Pair<ListSignalValue, ListSignalValue>> parseSignals(final List<String> lines) {
        final List<Pair<ListSignalValue, ListSignalValue>> pairs = new ArrayList<>();

        int index = 0;
        while (index < lines.size()) {
            final String line = lines.get(index);
            if (StringUtils.isBlank(line)) {
                index++;
            } else {
                var firstList = new PacketParser(line).parsePacket();
                var secondList = new PacketParser(lines.get(index + 1)).parsePacket();
                pairs.add(Pair.of(firstList, secondList));
                index += 2;
            }
        }

        return pairs;
    }

}
