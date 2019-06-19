package io.icednut.adapter.exercise.drawing.shape.delegate;

import io.icednut.adapter.exercise.drawing.Point;
import io.icednut.adapter.exercise.drawing.manipulator.Manipulator;
import io.icednut.adapter.exercise.drawing.manipulator.TextManipulator;
import io.icednut.adapter.exercise.drawing.shape.Shape;
import io.icednut.drawing.external.Coord;
import io.icednut.drawing.external.Coords;
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
        Coords bottomLeftCoord = textView.getOrigin(bottomLeft.getX(), bottomLeft.getY());
        Coords widthHeightCoord = textView.getExtent(topRight.getX(), topRight.getY());

        Coord bottom = bottomLeftCoord.getxCoord();
        Coord left = bottomLeftCoord.getyCoord();
        Coord width = widthHeightCoord.getxCoord();
        Coord height = widthHeightCoord.getyCoord();

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
