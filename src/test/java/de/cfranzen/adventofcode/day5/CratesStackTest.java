package de.cfranzen.adventofcode.day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CratesStackTest {

    @Test
    void testPushingAndPoppingFromStack() {
        final Crate crateA = new Crate('A');
        final Crate crateB = new Crate('B');
        final Crate crateC = new Crate('C');

        final CratesStack stack = new CratesStack();
        stack.push(crateA).push(crateB).push(crateC);

        assertThat(stack.toString()).isEqualTo("CratesStack['C', 'B', 'A']");
        assertThat(stack.pop()).isEqualTo(crateC);
        assertThat(stack.pop()).isEqualTo(crateB);

        stack.push(crateC).push(crateB);

        assertThat(stack.pop()).isEqualTo(crateB);
        assertThat(stack.pop()).isEqualTo(crateC);
        assertThat(stack.pop()).isEqualTo(crateA);
    }

}