package com.stage1.part2.task4;

public class RectTest {

    public static void main(String[] args) {
        Shape s = new Shape(1, 2);
        s.print();

        Rect r = new Rect(1, 2, 10, 10);
        r.print();

        //initiating using Shape, running using Rect
        Shape sr = new Rect(3,4,11,11);
        sr.print();

        //error when sr.getLen(), no function in shape class
        int ia = sr.getX();
        System.out.println("ia = " + ia);

        //sr is a type shape
        sr.test(); //static member, 不建议使用sr.
        Shape.test(); //better use this one

        //强制类型转换,来调用子类的fuction
        int ib = ((Rect)sr).getLen();
        System.out.println("ib = " + ib);

        /*
        circle a = (circle) sr; error when running the code, with null casting
        //判断sr指向的堆区内存中的对象是否位circle类型
        if(sr instanceof circle){
            circle a = (circle) sr;
        }
        */
    }

}
