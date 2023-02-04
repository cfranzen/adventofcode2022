package de.cfranzen.adventofcode.day10;

import java.util.ArrayList;
import java.util.List;

public class CpuPipeline {

    private int x = 1;

    private final List<Integer> history = new ArrayList<>();

    public void noop() {
        history.add(x);
    }

    public void addx(final int value) {
        history.add(x);
        history.add(x);
        x += value;
    }

    public int getSignalStrength(final int cycle) {
        return cycle * history.get(cycle - 1);
    }

    public int getValueXAtCycle(final int cycle) {
        return history.get(cycle - 1);
    }
}
