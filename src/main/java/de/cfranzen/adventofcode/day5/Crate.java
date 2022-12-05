package de.cfranzen.adventofcode.day5;

record Crate(char id) {

    @Override
    public String toString() {
        return "'" + id + "'";
    }
}
