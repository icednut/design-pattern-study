package io.icednut.adapter.exercise.drawing.shape;

import io.icednut.adapter.exercise.drawing.manipulator.Manipulator;
import io.icednut.adapter.exercise.drawing.Point;

public interface Shape {

    void boundingBox(Point bottomLeft, Point topRight);

    Manipulator createManipulator();
}
