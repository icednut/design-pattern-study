package io.icednut.adapter.exercise.drawing.shape.delegate;

import io.icednut.adapter.exercise.drawing.Point;
import io.icednut.adapter.exercise.drawing.manipulator.Manipulator;
import io.icednut.adapter.exercise.drawing.manipulator.TextManipulator;
import io.icednut.adapter.exercise.drawing.shape.Shape;
import io.icednut.drawing.external.Coord;
import io.icednut.drawing.external.TextView;

public class TextShape implements Shape {
    private TextView textView;
    private Point bottomLeft;
    private Point topRight;

    public TextShape(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void boundingBox(Point bottomLeft, Point topRight) {
        Coord bottom = new Coord();
        Coord left = new Coord();
        Coord width = new Coord();
        Coord height = new Coord();

        textView.getOrigin(bottom, left);
        textView.getExtent(width, height);

        this.bottomLeft = new Point(bottom.getPosition(), left.getPosition());
        this.topRight = new Point(bottom.add(height), left.add(width));
    }

    @Override
    public Manipulator createManipulator() {
        return new TextManipulator(this);
    }

    public boolean isEmpty() {
        return textView.isEmpty();
    }
}
