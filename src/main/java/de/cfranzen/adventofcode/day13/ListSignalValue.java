package de.cfranzen.adventofcode.day13;

import java.util.*;

public class ListSignalValue implements SignalValue {

    private final List<SignalValue> values;

    private ListSignalValue(final Collection<SignalValue> values) {
        this.values = List.copyOf(values);
    }

    public static ListSignalValue of(final Collection<SignalValue> values) {
        return new ListSignalValue(values);
    }

    public static ListSignalValue of(final SignalValue... values) {
        return new ListSignalValue(Arrays.asList(values));
    }

    public static ListSignalValue empty() {
        return new ListSignalValue(Collections.emptyList());
    }

    public List<SignalValue> values() {
        return values;
    }

    public int size() {
        return values.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ListSignalValue that = (ListSignalValue) o;
        return values.equals(that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
