package de.cfranzen.adventofcode.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyBusinessCalculatorTest {
    private final Monkey monkey0 = new Monkey(0, wl -> wl.multipleBy(19), wl -> wl.isDivisibleBy(23), 2, 3)
            .catchItem(Item.of(79))
            .catchItem(Item.of(98));
    private final Monkey monkey1 = new Monkey(1, wl -> wl.add(6), wl -> wl.isDivisibleBy(19), 2, 0)
            .catchItem(Item.of(54))
            .catchItem(Item.of(65))
            .catchItem(Item.of(75))
            .catchItem(Item.of(74));
    private final Monkey monkey2 = new Monkey(2, WorryLevel::squared, wl -> wl.isDivisibleBy(13), 1, 3)
            .catchItem(Item.of(79))
            .catchItem(Item.of(60))
            .catchItem(Item.of(97));
    private final Monkey monkey3 = new Monkey(3, wl -> wl.add(3), wl -> wl.isDivisibleBy(17), 0, 1)
            .catchItem(Item.of(74));

    private final long lcm = 96577L;

    private final List<Monkey> monkeys = List.of(monkey0, monkey1, monkey2, monkey3);

    @Test
    void testRoundOfMonkeyBusiness() {
        // Given
        final MonkeyBusinessCalculator calculator = new MonkeyBusinessCalculator(monkeys);

        // When
        calculator.performRound();

        // Then
        assertThat(monkey0.items()).containsExactly(
                Item.of(20),
                Item.of(23),
                Item.of(27),
                Item.of(26)
        );
        assertThat(monkey1.items()).containsExactly(
                Item.of(2080),
                Item.of(25),
                Item.of(167),
                Item.of(207),
                Item.of(401),
                Item.of(1046)
        );
        assertThat(monkey2.items()).isEmpty();
        assertThat(monkey3.items()).isEmpty();
    }

    @Test
    void testMultipleRoundsOfMonkeyBusiness() {
        // Given
        final MonkeyBusinessCalculator calculator = new MonkeyBusinessCalculator(monkeys);

        // When
        calculator.performMultipleRounds(20);

        // Then
        assertThat(monkey0.items()).containsExactly(
                Item.of(10),
                Item.of(12),
                Item.of(14),
                Item.of(26),
                Item.of(34)
        );
        assertThat(monkey1.items()).containsExactly(
                Item.of(245),
                Item.of(93),
                Item.of(53),
                Item.of(199),
                Item.of(115)
        );
        assertThat(monkey2.items()).isEmpty();
        assertThat(monkey3.items()).isEmpty();
    }

    @Test
    void testCalculationOfInspectedItems() {
        // Given
        final MonkeyBusinessCalculator calculator = new MonkeyBusinessCalculator(monkeys);

        // When
        calculator.performMultipleRounds(20);

        // Then
        assertThat(monkey0.inspectedItemsCount()).isEqualTo(101);
        assertThat(monkey1.inspectedItemsCount()).isEqualTo(95);
        assertThat(monkey2.inspectedItemsCount()).isEqualTo(7);
        assertThat(monkey3.inspectedItemsCount()).isEqualTo(105);
    }

    @Test
    void testCalculationOfMonkeyBusiness() {
        // Given
        final MonkeyBusinessCalculator calculator = new MonkeyBusinessCalculator(monkeys);

        // When
        calculator.performMultipleRounds(20);

        // Then
        assertThat(calculator.monkeyBusinessLevel()).isEqualTo(10605);
    }

    @Test
    void testCalculationOfInspectedItems_LCMReduction() {
        // Given
        final MonkeyBusinessCalculator calculator = new MonkeyBusinessCalculator(monkeys);

        // When
        calculator.performMultipleRounds(20, wl -> wl.modulo(lcm));

        // Then
        assertThat(monkey0.inspectedItemsCount()).isEqualTo(99);
        assertThat(monkey1.inspectedItemsCount()).isEqualTo(97);
        assertThat(monkey2.inspectedItemsCount()).isEqualTo(8);
        assertThat(monkey3.inspectedItemsCount()).isEqualTo(103);
    }

    @Test
    void testCalculationOfMonkeyBusiness_10000Rounds_LCMLevelReduction() {
        // Given
        final MonkeyBusinessCalculator calculator = new MonkeyBusinessCalculator(monkeys);

        // When
        calculator.performMultipleRounds(10000, wl -> wl.modulo(lcm));

        // Then
        assertThat(monkey0.inspectedItemsCount()).isEqualTo(52166);
        assertThat(monkey1.inspectedItemsCount()).isEqualTo(47830);
        assertThat(monkey2.inspectedItemsCount()).isEqualTo(1938);
        assertThat(monkey3.inspectedItemsCount()).isEqualTo(52013);
        assertThat(calculator.monkeyBusinessLevel()).isEqualTo(2713310158L);
    }
}