package io.icednut.adapter.exercise.drawing.shape;

import io.icednut.adapter.exercise.drawing.manipulator.LineManipulator;
import io.icednut.adapter.exercise.drawing.manipulator.Manipulator;
import io.icednut.adapter.exercise.drawing.Point;

public class Line implements Shape {

    @Override
    public void boundingBox(Point bottomLeft, Point topRight) {
        // 구현하겠지
    }

    @Override
    public Manipulator createManipulator() {
        return new LineManipulator();
    }
}
