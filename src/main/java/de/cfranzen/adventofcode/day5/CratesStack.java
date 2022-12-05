package de.cfranzen.adventofcode.day5;

import java.util.ArrayDeque;
import java.util.Deque;

class CratesStack {

    private final Deque<Crate> stack = new ArrayDeque<>();

    CratesStack push(Crate crate) {
        stack.push(crate);
        return this;
    }

    Crate pop() {
        return stack.pop();
    }

    @Override
    public String toString() {
        return "CratesStack" + stack;
    }
}
