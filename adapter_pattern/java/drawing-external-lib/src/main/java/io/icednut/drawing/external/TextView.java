package io.icednut.drawing.external;

public class TextView {

    public Coords getOrigin(int x, int y) {
        System.out.println("경계 시작 점인 x, y 좌표 얻기");
        return new Coords(new Coord(x), new Coord(y));
    }

    public Coords getExtent(int width, int height) {
        System.out.println("넓이, 길이를 바탕으로 경계가 있는 상자를 만듬");
        return new Coords(new Coord(width), new Coord(height));
    }

    public boolean isEmpty() {
        return false;
    }
}
