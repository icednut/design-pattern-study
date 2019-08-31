package io.icednut.drawing.external;

public class Coord {

    private int position;

    public Coord() {
    }

    public Coord(int position) {
        this.position = position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int add(Coord c) {
        this.position = position + c.getPosition();
        return position;
    }
}
