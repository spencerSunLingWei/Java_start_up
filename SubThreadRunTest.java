package com.stage1.part4.task3;

public class SubThreadRunTest {

    public static void main(String[] args) {

        Thread t1 = new SubThreadRun();
        //t1.run(); //相当于只是掉了一个普通的function
        t1.start(); //启动线程，自动调用run方法

        for (int i = 0; i<=20; i++){
            System.out.println("main methods: i = " + i);
        }
    }
}
