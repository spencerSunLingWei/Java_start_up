package com.stage1.part2.task4;

public class Shape {
    private int x;
    private int y;

    public Shape() {
    }

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void print(){
        System.out.println("x = " + getX() + " / y = " + getY());
    }

    public static void test(){
        System.out.println("shape 类重的静态方法");
    }


}
