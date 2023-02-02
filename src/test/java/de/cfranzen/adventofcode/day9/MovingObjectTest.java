package de.cfranzen.adventofcode.day9;

import org.junit.jupiter.api.Test;

import static de.cfranzen.adventofcode.day9.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class MovingObjectTest {

    @Test
    void testMovingUp() {
        final MovingObject obj = new MovingObject();
        obj.move(UP).move(UP).move(UP);

        assertThat(obj.getRow()).isEqualTo(3);
        assertThat(obj.getColumn()).isEqualTo(0);
    }

    @Test
    void testMovingDown() {
        final MovingObject obj = new MovingObject();
        obj.move(DOWN).move(DOWN).move(DOWN);

        assertThat(obj.getRow()).isEqualTo(-3);
        assertThat(obj.getColumn()).isEqualTo(0);
    }

    @Test
    void testMovingRight() {
        final MovingObject obj = new MovingObject();
        obj.move(RIGHT).move(RIGHT).move(RIGHT);

        assertThat(obj.getRow()).isEqualTo(0);
        assertThat(obj.getColumn()).isEqualTo(3);
    }

    @Test
    void testMovingLeft() {
        final MovingObject obj = new MovingObject();
        obj.move(LEFT).move(LEFT).move(LEFT);

        assertThat(obj.getRow()).isEqualTo(0);
        assertThat(obj.getColumn()).isEqualTo(-3);
    }

    @Test
    void testMovingUpRight() {
        final MovingObject obj = new MovingObject();
        obj.move(UP).move(UP).move(UP)
                .move(RIGHT).move(RIGHT).move(RIGHT);

        assertThat(obj.getRow()).isEqualTo(3);
        assertThat(obj.getColumn()).isEqualTo(3);
    }

    @Test
    void testMovingDownLeft() {
        final MovingObject obj = new MovingObject();
        obj.move(DOWN).move(DOWN).move(DOWN)
                .move(LEFT).move(LEFT).move(LEFT);

        assertThat(obj.getRow()).isEqualTo(-3);
        assertThat(obj.getColumn()).isEqualTo(-3);
    }

    @Test
    void testDistanceCalculationWhenMovingUp() {
        // Given
        final var reference = new MovingObject();
        final var target = new MovingObject().move(UP).move(UP);

        // When
        final int rowDistance = reference.getRowDistanceTo(target);
        final int columnDistance = reference.getColumnDistanceTo(target);
        final int distance = reference.getDistanceTo(target);

        // Then
        assertThat(rowDistance).isEqualTo(2);
        assertThat(columnDistance).isEqualTo(0);
        assertThat(distance).isEqualTo(2);
    }

    @Test
    void testDistanceCalculationWhenMovingDown() {
        // Given
        final var reference = new MovingObject();
        final var target = new MovingObject().move(DOWN).move(DOWN);

        // When
        final int rowDistance = reference.getRowDistanceTo(target);
        final int columnDistance = reference.getColumnDistanceTo(target);
        final int distance = reference.getDistanceTo(target);

        // Then
        assertThat(rowDistance).isEqualTo(-2);
        assertThat(columnDistance).isEqualTo(0);
        assertThat(distance).isEqualTo(2);
    }

    @Test
    void testDistanceCalculationWhenMovingRight() {
        // Given
        final var reference = new MovingObject();
        final var target = new MovingObject().move(RIGHT).move(RIGHT);

        // When
        final int rowDistance = reference.getRowDistanceTo(target);
        final int columnDistance = reference.getColumnDistanceTo(target);
        final int distance = reference.getDistanceTo(target);

        // Then
        assertThat(rowDistance).isEqualTo(0);
        assertThat(columnDistance).isEqualTo(2);
        assertThat(distance).isEqualTo(2);
    }

    @Test
    void testDistanceCalculationWhenMovingLeft() {
        // Given
        final var reference = new MovingObject();
        final var target = new MovingObject().move(LEFT).move(LEFT);

        // When
        final int rowDistance = reference.getRowDistanceTo(target);
        final int columnDistance = reference.getColumnDistanceTo(target);
        final int distance = reference.getDistanceTo(target);

        // Then
        assertThat(rowDistance).isEqualTo(0);
        assertThat(columnDistance).isEqualTo(-2);
        assertThat(distance).isEqualTo(2);
    }

    @Test
    void testDistanceCalculationWhenMovingUpRight() {
        // Given
        final var reference = new MovingObject();
        final var target = new MovingObject().move(UP).move(UP)
                .move(RIGHT).move(RIGHT);

        // When
        final int rowDistance = reference.getRowDistanceTo(target);
        final int columnDistance = reference.getColumnDistanceTo(target);
        final int distance = reference.getDistanceTo(target);

        // Then
        assertThat(rowDistance).isEqualTo(2);
        assertThat(columnDistance).isEqualTo(2);
        assertThat(distance).isEqualTo(2);
    }

    @Test
    void testDistanceCalculationWhenMovingDownLeft() {
        // Given
        final var reference = new MovingObject();
        final var target = new MovingObject().move(DOWN).move(DOWN)
                .move(LEFT).move(LEFT);

        // When
        final int rowDistance = reference.getRowDistanceTo(target);
        final int columnDistance = reference.getColumnDistanceTo(target);
        final int distance = reference.getDistanceTo(target);

        // Then
        assertThat(rowDistance).isEqualTo(-2);
        assertThat(columnDistance).isEqualTo(-2);
        assertThat(distance).isEqualTo(2);
    }
}