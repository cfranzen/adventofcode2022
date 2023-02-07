package de.cfranzen.adventofcode.day12;

import java.util.*;

public class ShortestPathSearch {

    private final HeightMap map;

    private final Set<Label> pendingLabels;

    private final Set<Coordinate> visitedNodes;

    private final Map<Coordinate, Label> mapNodeToLabel;

    public ShortestPathSearch(final HeightMap map) {
        this.map = map;
        this.pendingLabels = new HashSet<>(map.width() * map.height());
        this.visitedNodes = new HashSet<>(map.width() * map.height());
        this.mapNodeToLabel = new HashMap<>(map.width() * map.height());
    }

    public int findAlternativeMinCostShortestPath() {
        int minCosts = findMinCostShortestPath(map.start());
        for (var alternativeStart : map.alternativeStarts()) {
            final int costs = findMinCostShortestPath(alternativeStart);
            if (costs < minCosts) {
                minCosts = costs;
            }
        }
        return minCosts;
    }

    public int findMinCostShortestPath() {
        return findMinCostShortestPath(map.start());
    }

    public int findMinCostShortestPath(final Coordinate startNode) {
        pendingLabels.clear();
        visitedNodes.clear();
        mapNodeToLabel.clear();

        pendingLabels.add(new Label(startNode, 0));

        while (!pendingLabels.isEmpty()) {
            final Label currentLabel = pollLowestCostLabel();
            for (Coordinate neighbor : findNeighborhood(currentLabel.node)) {
                if (!visitedNodes.contains(neighbor)) {
                    var neighborLabel = mapNodeToLabel.computeIfAbsent(neighbor, k -> new Label(k, Integer.MAX_VALUE));
                    if (currentLabel.costs + 1 < neighborLabel.costs) {
                        neighborLabel.costs = currentLabel.costs + 1;
                    }
                    pendingLabels.add(neighborLabel);
                }
            }
            visitedNodes.add(currentLabel.node);
        }
        final Label endLabel = mapNodeToLabel.get(map.end());
        return (endLabel == null) ? Integer.MAX_VALUE : endLabel.costs;
    }

    private List<Coordinate> findNeighborhood(final Coordinate node) {
        final List<Coordinate> neighborhood = new ArrayList<>(Direction.values().length);
        for (var direction : Direction.values()) {
            if (map.canMove(node, direction)) {
                neighborhood.add(node.move(direction));
            }
        }
        return neighborhood;
    }

    private Label pollLowestCostLabel() {
        Label lowestCostLabel = null;
        int lowestCost = Integer.MAX_VALUE;
        for (Label label : pendingLabels) {
            if (label.costs < lowestCost) {
                lowestCost = label.costs;
                lowestCostLabel = label;
            }
        }
        pendingLabels.remove(lowestCostLabel);
        return lowestCostLabel;
    }

    private static class Label {

        private final Coordinate node;

        private int costs;

        public Label(final Coordinate node, final int costs) {
            this.node = node;
            this.costs = costs;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Label label = (Label) o;
            return node.equals(label.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }

        @Override
        public String toString() {
            return "Label{" +
                    "node=" + node +
                    ", costs=" + costs +
                    '}';
        }
    }
}
