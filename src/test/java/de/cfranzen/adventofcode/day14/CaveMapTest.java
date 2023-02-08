package de.cfranzen.adventofcode.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CaveMapTest {

    private final List<Wall> walls = List.of(
            new Wall(Coordinate.of(498, 4), Coordinate.of(498, 6)),
            new Wall(Coordinate.of(498, 6), Coordinate.of(496, 6)),

            new Wall(Coordinate.of(503, 4), Coordinate.of(502, 4)),
            new Wall(Coordinate.of(502, 4), Coordinate.of(502, 9)),
            new Wall(Coordinate.of(502, 9), Coordinate.of(494, 9))
    );

    @Test
    void testDrawingMap() {
        final CaveMap map = new CaveMap(walls);
        assertThat(map.toString()).isEqualTo("""
                ......+...
                ..........
                ..........
                ..........
                ....#...##
                ....#...#.
                ..###...#.
                ........#.
                ........#.
                #########.
                """);
    }

    @Test
    void testBlockingByRocks() {
        final CaveMap map = new CaveMap(walls);

        assertThat(map.isBlocked(Coordinate.of(503, 4))).isTrue();
        assertThat(map.isBlocked(Coordinate.of(498, 9))).isTrue();
        assertThat(map.isBlocked(Coordinate.of(502, 6))).isTrue();

        assertThat(map.isBlocked(Coordinate.of(1, 1))).isFalse();
        assertThat(map.isBlocked(Coordinate.of(493, 9))).isFalse();
        assertThat(map.isBlocked(Coordinate.of(502, 3))).isFalse();
    }

    @Test
    void testBlockingBySand() {
        final CaveMap map = new CaveMap(walls);
        final Coordinate coordinate = Coordinate.of(493, 9);

        assertThat(map.isBlocked(coordinate)).isFalse();
        map.putSand(coordinate);
        assertThat(map.isBlocked(coordinate)).isTrue();

        System.out.println(map);
    }
}