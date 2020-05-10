package com.stage1.part2.task5;

public class StaticOuterTest {

    public static void main(String[] args) {
        StaticOuter.StaticInner si = new StaticOuter.StaticInner();
        si.show();
        si.show1(444);
    }

}
