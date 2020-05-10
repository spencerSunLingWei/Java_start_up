package com.stage1.part2.task5;

/**
 * 静态内部类
 */

public class StaticOuter {
    private int cnt = 1;
    private static int snt = 2;

    public static void show(){
        System.out.println("outer static show");
    }

    public void show2(){
        System.out.println("outer dynamic show");
    }

    public static class StaticInner{
        private int ia = 3;
        private static int snt = 4;

        public StaticInner(){
            System.out.println("inner constructor");
        }

        public void show(){
            //cannot access dynamic
            System.out.println("outer snt = " + snt);
            System.out.println("inner ia = " + ia);
        }

        public void show1(int snt){
            System.out.println("input snt = " + snt);
            System.out.println("inner snt = " + StaticInner.snt);
            System.out.println("outer snt = " + StaticOuter.snt);
            StaticOuter.show();
            new StaticOuter().show();
        }

    }
}
