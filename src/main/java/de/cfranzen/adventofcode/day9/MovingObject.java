package de.cfranzen.adventofcode.day9;

import java.util.Objects;

public class MovingObject {

    private int row = 0;

    private int column = 0;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public MovingObject move(final Direction direction) {
        this.row += direction.getRowIncrement();
        this.column += direction.getColumnIncrement();
        return this;
    }

    public int getRowDistanceTo(final MovingObject target) {
        return target.row - row;
    }

    public int getColumnDistanceTo(final MovingObject target) {
        return target.column - column;
    }

    public int getDistanceTo(final MovingObject target) {
        return Math.max(
                Math.abs(getRowDistanceTo(target)),
                Math.abs(getColumnDistanceTo(target))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingObject that = (MovingObject) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "MovingObject{row=" + row + ", column=" + column + '}';
    }
}
