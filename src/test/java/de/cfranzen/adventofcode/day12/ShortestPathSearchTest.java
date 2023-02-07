package de.cfranzen.adventofcode.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestPathSearchTest {

    private final char[][] data = {
            //0    1    2    3    4    5    6    7
            {'S', 'a', 'b', 'q', 'p', 'o', 'n', 'm'}, // 0
            {'a', 'b', 'c', 'r', 'y', 'x', 'x', 'l'}, // 1
            {'a', 'c', 'c', 's', 'z', 'E', 'x', 'k'}, // 2
            {'a', 'c', 'c', 't', 'u', 'v', 'w', 'j'}, // 3
            {'a', 'b', 'd', 'e', 'f', 'g', 'h', 'i'}  // 4
    };

    @Test
    void testSearchingShortestPath() {
        final HeightMap map = new HeightMap(data);
        final ShortestPathSearch search = new ShortestPathSearch(map);
        final int costs = search.findMinCostShortestPath();
        assertThat(costs).isEqualTo(31);
    }
}