package de.cfranzen.adventofcode.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StackGroupTest {

    @Test
    void testManagingStacks() {
        final StackGroup group = new StackGroup(List.of('A', 'B', 'C'));

        assertThat(group.getStack('A')).isNotNull();
        assertThat(group.getStack('B')).isNotNull();
        assertThat(group.getStack('C')).isNotNull();
        assertThat(group.getStack('D')).isNull();
    }

    /**
     * This is the initial stack setup
     * <pre>
     *  [C]
     *  [B] [E]
     *  [A] [D] [F]
     *   1   2   3
     * </pre>
     */
    @Test
    void testMovingCrates() {
        final Crate crateA = new Crate('A');
        final Crate crateB = new Crate('B');
        final Crate crateC = new Crate('C');
        final Crate crateD = new Crate('D');
        final Crate crateE = new Crate('E');
        final Crate crateF = new Crate('F');

        final StackGroup group = new StackGroup(List.of('1', '2', '3'));
        final CratesStack stack1 = group.getStack('1');
        final CratesStack stack2 = group.getStack('2');
        final CratesStack stack3 = group.getStack('3');
        stack1.push(crateA).push(crateB).push(crateC);
        stack2.push(crateD).push(crateE);
        stack3.push(crateF);

        group.moveCrate('3', '2');
        group.moveCrate(3, '1', '3');
        group.moveCrate('2', '3');
        group.moveCrate(2, '2', '1');
        group.moveCrate('3', '2');

        assertThat(stack1.pop()).isEqualTo(crateD);
        assertThat(stack1.pop()).isEqualTo(crateE);
        assertThat(stack2.pop()).isEqualTo(crateF);
        assertThat(stack3.pop()).isEqualTo(crateA);
        assertThat(stack3.pop()).isEqualTo(crateB);
        assertThat(stack3.pop()).isEqualTo(crateC);
    }

    /**
     * This is the initial stack setup
     * <pre>
     *  [C]
     *  [B] [E]
     *  [A] [D] [F]
     *   1   2   3
     * </pre>
     */
    @Test
    void testMovingMultipleCrates() {
        final Crate crateA = new Crate('A');
        final Crate crateB = new Crate('B');
        final Crate crateC = new Crate('C');
        final Crate crateD = new Crate('D');
        final Crate crateE = new Crate('E');
        final Crate crateF = new Crate('F');

        final StackGroup group = new StackGroup(List.of('1', '2', '3'));
        final CratesStack stack1 = group.getStack('1');
        final CratesStack stack2 = group.getStack('2');
        final CratesStack stack3 = group.getStack('3');
        stack1.push(crateA).push(crateB).push(crateC);
        stack2.push(crateD).push(crateE);
        stack3.push(crateF);

        group.moveCrate('3', '2');
        group.moveMultipleCrate(3, '1', '3');
        group.moveCrate('2', '3');
        group.moveMultipleCrate(2, '2', '1');
        group.moveCrate('3', '2');

        assertThat(stack1.pop()).isEqualTo(crateE);
        assertThat(stack1.pop()).isEqualTo(crateD);
        assertThat(stack2.pop()).isEqualTo(crateF);
        assertThat(stack3.pop()).isEqualTo(crateC);
        assertThat(stack3.pop()).isEqualTo(crateB);
        assertThat(stack3.pop()).isEqualTo(crateA);
    }
}