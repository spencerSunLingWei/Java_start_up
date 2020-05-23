package com.stage1.part4.task3;

public class SubThreadTest {

    public static void main(String[] args) {

        SubThread1 st1 = new SubThread1();
        SubThread2 st2 = new SubThread2();

        st1.start();
        st2.start();

        System.out.println("main waiting.....");

        try {
            st1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main finished waiting.....");
    }
}
