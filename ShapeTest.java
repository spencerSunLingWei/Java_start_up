package com.stage1.part2.task4;

public class ShapeTest {

    public static void draw(Rect r){
        r.print();
    }

    public static void draw(Circle c){
        c.print();
    }

    public static void draw2(Shape s){
        s.print();
    }

    public static void main(String[] args) {
        ShapeTest.draw(new Rect(1, 2, 3, 4));
        ShapeTest.draw(new Circle(2, 3, 4));
        ShapeTest.draw2(new Shape(3, 4));
        ShapeTest.draw2(new Rect(1, 2, 3, 4));
        ShapeTest.draw2(new Circle(2, 3, 4));
    }

}
