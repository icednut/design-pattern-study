package io.icednut.adapter.exercise.drawing.shape.inherit;

import io.icednut.adapter.exercise.drawing.manipulator.Manipulator;
import io.icednut.adapter.exercise.drawing.Point;
import io.icednut.adapter.exercise.drawing.manipulator.TextManipulator;
import io.icednut.adapter.exercise.drawing.shape.Shape;
import io.icednut.drawing.external.Coord;
import io.icednut.drawing.external.TextView;

public class TextShape extends TextView implements Shape {
    private Point bottomLeft;
    private Point topRight;

    @Override
    public void boundingBox(Point bottomLeft, Point topRight) {
        Coord bottom = new Coord();
        Coord left = new Coord();
        Coord width = new Coord();
        Coord height = new Coord();

        getOrigin(bottom, left);
        getExtent(width, height);

        this.bottomLeft = new Point(bottom.getPosition(), left.getPosition());
        this.topRight = new Point(bottom.add(height), left.add(width));
    }

    @Override
    public Manipulator createManipulator() {
        return new TextManipulator(this);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
