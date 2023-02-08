package de.cfranzen.adventofcode.day13;

import java.util.Objects;

public class IntSignalValue implements SignalValue {

    private final int value;

    private IntSignalValue(final int value) {
        this.value = value;
    }

    public static IntSignalValue of(final int value) {
        return new IntSignalValue(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IntSignalValue that = (IntSignalValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
