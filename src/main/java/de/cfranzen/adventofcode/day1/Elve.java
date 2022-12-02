package de.cfranzen.adventofcode.day1;

import java.util.Objects;

class Elve {

    private final String name;

    private int calories;

    public Elve(String name) {
        this(name, 0);
    }

    public Elve(String name, int initialCalories) {
        this.name = name;
        this.calories = initialCalories;
    }

    public int getCalories() {
        return calories;
    }

    public void addCalories(int calories) {
        this.calories += calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elve elve = (Elve) o;
        return calories == elve.calories && name.equals(elve.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories);
    }

    @Override
    public String toString() {
        return "Elve{name='" + name + '\'' + ", calories=" + calories + '}';
    }
}
