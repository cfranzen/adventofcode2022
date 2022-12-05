package de.cfranzen.adventofcode.day5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class StackGroup {

    private final Map<Character, CratesStack> stacks;

    public StackGroup(Collection<Character> stackIds) {
        this.stacks = stackIds.stream().collect(Collectors.toMap(Function.identity(), id -> new CratesStack()));
    }

    CratesStack getStack(char id) {
        return stacks.get(id);
    }

    List<Character> getStackIds() {
        return stacks.keySet().stream().sorted().toList();
    }

    void moveCrate(char fromId, char toId) {
        CratesStack from = getStack(fromId);
        CratesStack to = getStack(toId);
        to.push(from.pop());
    }

    void moveCrate(int repeat, char fromId, char toId) {
        for (int i = 0; i < repeat; i++) {
            moveCrate(fromId, toId);
        }
    }

    void moveMultipleCrate(int count, char fromId, char toId) {
        CratesStack from = getStack(fromId);
        CratesStack to = getStack(toId);

        final List<Crate> temp = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            temp.add(from.pop());
        }

        Collections.reverse(temp);
        for (Crate crate : temp) {
            to.push(crate);
        }
    }

    @Override
    public String toString() {
        return stacks.keySet().stream().sorted().map(c -> c + "->" + stacks.get(c)).collect(Collectors.joining("\n"));
    }
}
