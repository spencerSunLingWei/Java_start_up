package com.stage1.part2.task5;

public class NormalOuterTest {

    public static void main(String[] args) {

        NormalOuter no = new NormalOuter();
        NormalOuter.NormalInner ni = no.new NormalInner();

        ni.show();
        ni.show1(10);
    }

}
;
