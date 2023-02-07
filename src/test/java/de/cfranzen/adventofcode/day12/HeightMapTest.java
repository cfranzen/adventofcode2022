package de.cfranzen.adventofcode.day12;

import org.junit.jupiter.api.Test;

import static de.cfranzen.adventofcode.day12.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class HeightMapTest {

    private final char[][] data = {
            //0    1    2    3    4    5    6    7
            {'S', 'a', 'b', 'q', 'p', 'o', 'n', 'm'}, // 0
            {'a', 'b', 'c', 'r', 'y', 'x', 'x', 'l'}, // 1
            {'a', 'c', 'c', 's', 'z', 'E', 'x', 'k'}, // 2
            {'a', 'c', 'c', 't', 'u', 'v', 'w', 'j'}, // 3
            {'a', 'b', 'd', 'e', 'f', 'g', 'h', 'i'}  // 4
    };

    @Test
    void testMoving() {
        final HeightMap map = new HeightMap(data);

        assertThat(map.canMove(0, 0, UP)).isFalse();
        assertThat(map.canMove(0, 0, DOWN)).isTrue();
        assertThat(map.canMove(0, 0, LEFT)).isFalse();
        assertThat(map.canMove(0, 0, RIGHT)).isTrue();

        assertThat(map.canMove(5, 3, UP)).isFalse();
        assertThat(map.canMove(5, 1, DOWN)).isFalse();
        assertThat(map.canMove(6, 2, LEFT)).isFalse();
        assertThat(map.canMove(4, 2, RIGHT)).isTrue();

        assertThat(map.canMove(2, 2, UP)).isTrue();
        assertThat(map.canMove(2, 2, DOWN)).isTrue();
        assertThat(map.canMove(2, 2, LEFT)).isTrue();
        assertThat(map.canMove(2, 2, RIGHT)).isFalse();
    }

    @Test
    void testCalculationOfStartAndEnd() {
        final HeightMap map = new HeightMap(data);

        assertThat(map.start()).isEqualTo(Coordinate.of(0, 0));
        assertThat(map.end()).isEqualTo(Coordinate.of(5, 2));
    }
}