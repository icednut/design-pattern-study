package io.icednut.drawing.external;

public class TextView {

    public void getOrigin(Coord x, Coord y) {
        System.out.println("경계 시작 점인 x, y 좌표 얻기");
    }

    public void getExtent(Coord width, Coord height) {
        System.out.println("넓이, 길이를 바탕으로 경계가 있는 상자를 만듬");
    }

    public boolean isEmpty() {
        return false;
    }
}
