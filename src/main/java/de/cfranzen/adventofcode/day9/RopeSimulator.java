package de.cfranzen.adventofcode.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RopeSimulator {

    private final List<MovingObject> knots;

    private final Set<Position> tailPositions = new HashSet<>();

    public RopeSimulator(final int knotsCount) {
        if (knotsCount < 2) {
            throw new IllegalArgumentException("Knots count must be at least 2");
        }

        this.knots = new ArrayList<>(knotsCount);
        for (int i = 0; i < knotsCount; i++) {
            this.knots.add(new MovingObject());
        }

        markTailPosition();
    }

    public void processMove(final Movement movement) {
        for (int i = 0; i < movement.distance(); i++) {
            moveHeadWithFollowingKnots(movement.direction());
        }
    }

    public int getTailPositionCount() {
        return tailPositions.size();
    }

    private void moveHeadWithFollowingKnots(final Direction direction) {
        head().move(direction);

        for (int i = 0; i < knots.size() - 1; i++) {
            moveFollowingKnot(knots.get(i), knots.get(i + 1));
        }

        markTailPosition();
    }

    private static void moveFollowingKnot(
            final MovingObject firstKnot,
            final MovingObject secondKnot
    ) {
        final int distance = firstKnot.getDistanceTo(secondKnot);
        if (distance <= 1) {
            return;
        }

        final int rowDistance = secondKnot.getRowDistanceTo(firstKnot);
        final int columnDistance = secondKnot.getColumnDistanceTo(firstKnot);

        if (rowDistance > 0) {
            secondKnot.move(Direction.UP);
        } else if (rowDistance < 0) {
            secondKnot.move(Direction.DOWN);
        }
        if (columnDistance > 0) {
            secondKnot.move(Direction.RIGHT);
        } else if (columnDistance < 0) {
            secondKnot.move(Direction.LEFT);
        }
    }

    private void markTailPosition() {
        tailPositions.add(new Position(tail().getRow(), tail().getColumn()));
    }

    private MovingObject head() {
        return knots.get(0);
    }

    private MovingObject tail() {
        return knots.get(knots.size() - 1);
    }

    private record Position(int row, int column) {
    }
}
