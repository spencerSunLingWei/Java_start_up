package com.stage1.part4.task3;

public class ThreadPriorityTest extends Thread{

    @Override
    public void run() {
        System.out.println("sub priority: " + getPriority());

        for (int i = 0; i<=20; i++){
            System.out.println("sub methods: i = " + i);
        }
    }

    public static void main(String[] args) {

        ThreadPriorityTest tpt = new ThreadPriorityTest();
        tpt.setPriority(Thread.MAX_PRIORITY);
        tpt.start();

        Thread t1 = Thread.currentThread();
        System.out.println("main priority: " + t1.getPriority());

        for (int i = 0; i<=20; i++){
            System.out.println("main methods: i = " + i);
        }
    }
}
