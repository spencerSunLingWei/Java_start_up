package com.stage1.part2.task5;

/**
 * 编程实现普通内部类的定义和使用
 */

public class NormalOuter {

    private int cnt = 1;

    //定义普通内部类
    public class NormalInner{
        private int ia = 2;
        private int cnt = 3;

        public NormalInner(){
            System.out.println("inner constructor");
        }

        public void show(){
            System.out.println("outer cnt = " + cnt);
            System.out.println("inner ia = " + ia);
        }

        public void show1(int cnt){
            System.out.println("input value cnt = " + cnt);
            System.out.println("inner cnt = " + this.cnt);
            System.out.println("outer cnt = " + NormalOuter.this.cnt);
        }
    }

}
