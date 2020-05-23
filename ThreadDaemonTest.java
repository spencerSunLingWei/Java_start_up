package com.stage1.part4.task3;

public class ThreadDaemonTest extends Thread {

    @Override
    public void run() {
        //默认不是守护线程
        //System.out.println(isDaemon() ? "是守护线程" : "不是守护线程");

        //当子线程不是守护线程时，虽然主线程结束了，子线程还是会继续执行直到结束
        for (int i = 0; i<=50; i++){
            System.out.println("sub methods: i = " + i);
        }
    }

    public static void main(String[] args) {

        ThreadDaemonTest tdt = new ThreadDaemonTest();
        tdt.setDaemon(true);
        tdt.start();

        for (int i = 0; i<=20; i++){
            System.out.println("main methods: i = " + i);
        }
    }
}
