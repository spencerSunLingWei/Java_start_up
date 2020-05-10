package com.stage1.part2.task4;

public class Circle extends Shape{

    private int radius;

    public Circle() {
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("radius = " + getRadius());
    }
}
