package de.cfranzen.adventofcode.day11;

import java.util.Objects;

public class WorryLevel {

    private final long value;

    public WorryLevel(final long value) {
        this.value = value;
    }

    public boolean isDivisibleBy(final long divisor) {
        return value % divisor == 0;
    }

    public WorryLevel squared() {
        return new WorryLevel(value * value);
    }

    public WorryLevel multipleBy(final long operand) {
        return new WorryLevel(value * operand);
    }

    public WorryLevel modulo(final long operand) {
        return new WorryLevel(value % operand);
    }

    public WorryLevel add(final long operand) {
        return new WorryLevel(value + operand);
    }

    public WorryLevel floorDivideBy(final int divisor) {
        return new WorryLevel(value / divisor);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WorryLevel that = (WorryLevel) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
