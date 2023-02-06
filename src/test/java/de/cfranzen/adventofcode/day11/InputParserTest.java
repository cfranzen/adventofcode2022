package de.cfranzen.adventofcode.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    private final List<String> lines = List.of(
            "Monkey 0:",
            "  Starting items: 79, 98",
            "  Operation: new = old * 19",
            "  Test: divisible by 23",
            "    If true: throw to monkey 2",
            "    If false: throw to monkey 3",
            "");

    @Test
    void testParsingMonkeys() {
        final List<Monkey> monkeys = new InputParser().parseMonkeys(lines);
        assertThat(monkeys).hasSize(1);

        final Monkey monkey = monkeys.get(0);
        assertThat(monkey.id()).isEqualTo(0);
        assertThat(monkey.items()).containsExactly(Item.of(79), Item.of(98));

        final List<ThrownItem> thrownItems = monkey.performTurn();
        assertThat(thrownItems).containsExactly(
                new ThrownItem(3, Item.of(500)),
                new ThrownItem(3, Item.of(620))
        );
    }

    @Test
    void testLCMCaluclation() {
        var lcmLines = List.of(
                "  Test: divisible by 23",
                "  Test: divisible by 19",
                "  Test: divisible by 13",
                "  Test: divisible by 17"
        );

        final long lcm = new InputParser().parseLCM(lcmLines);

        assertThat(lcm).isEqualTo(96577);
    }
}