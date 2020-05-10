package com.stage1.part2.task5;

/**
 * 局部内部类
 */

public class AreaOuter {

    private int cnt = 1;

    public void show(){

        final int ic = 4;

        class AreaInner{
            private int ia = 2;
            public AreaInner(){
                System.out.println("inner constructor");
            }

            public void test(){
                System.out.println("ia = " + ia);
                System.out.println("cnt = " + cnt);
                System.out.println("ic = " + ic);
                //ic cannot change, must be final
            }
        }

        AreaInner ai = new AreaInner();
        ai.test();
    }

    public static void main(String[] args) {
        AreaOuter ao = new AreaOuter();
        ao.show();
    }
}
