package io.icednut.adapter.exercise.drawing.shape.inherit;

import io.icednut.adapter.exercise.drawing.manipulator.Manipulator;
import io.icednut.adapter.exercise.drawing.Point;
import io.icednut.adapter.exercise.drawing.manipulator.TextManipulator;
import io.icednut.adapter.exercise.drawing.shape.Shape;
import io.icednut.drawing.external.Coord;
import io.icednut.drawing.external.Coords;
import io.icednut.drawing.external.TextView;

public class TextShape extends TextView implements Shape {
    private Point bottomLeft;
    private Point topRight;

    @Override
    public void boundingBox(Point bottomLeft, Point topRight) {
        Coords bottomLeftCoord = getOrigin(bottomLeft.getX(), bottomLeft.getY());
        Coords widthHeightCoord = getExtent(topRight.getX(), topRight.getY());

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

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
