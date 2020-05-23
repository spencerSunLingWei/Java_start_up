package com.stage1.part4.task3;

/**
 * 匿名内部类
 */

public class ThreadAnonymousTest {

    public static void main(String[] args) {

/*
        Thread t1 = new Thread() {
            @Override
            public void run () {
                System.out.println("1");
            }
        };
        t1.start();
*/

        new Thread() {
            @Override
            public void run() {
                System.out.println("1");
            }
        }.start();

/*
        Runnable ra = new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        };
        Thread t2 = new Thread(ra);
        t2.start();
*/

/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        }).start();
*/

/*
        Runnable ra = ()-> System.out.println("2");
        new Thread(ra).start();
*/

        new Thread(()-> System.out.println("2")).start();
    }
}
