package io.icednut.drawing.external;

public class Coords {
    private Coord xCoord;
    private Coord yCoord;

    public Coords(Coord xCoord, Coord yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Coord getxCoord() {
        return xCoord;
    }

    public Coord getyCoord() {
        return yCoord;
    }
}
