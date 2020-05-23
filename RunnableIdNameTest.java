package com.stage1.part4.task3;

public class RunnableIdNameTest implements Runnable{

    @Override
    public void run() {
        Thread t1 = Thread.currentThread();
        System.out.println("子线程编号是： " + t1.getId()
                + " , 名称是： " + t1.getName());
    }

    public static void main(String[] args) {

        RunnableIdNameTest rint = new RunnableIdNameTest();
        Thread t2 = new Thread(rint,"fjsdklfjl");
        t2.start();

        Thread t1 = Thread.currentThread();
        System.out.println("主线程编号是： " + t1.getId()
                + " , 名称是： " + t1.getName());
    }
}
