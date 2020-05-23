package com.stage1.part4.task3;

public class ThreadIdNameTest extends Thread{

    public ThreadIdNameTest(String pckk) {
        super(pckk);
    }

    @Override
    public void run() {
        System.out.println("子线程编号是： " + getId()
                                + " , 名称是： " + getName());

        setName("pcaa");

        System.out.println("子线程编号是： " + getId()
                + " , 名称是： " + getName());
    }

    public static void main(String[] args) {

        ThreadIdNameTest tint = new ThreadIdNameTest("pckk");
        tint.start();

        Thread t1 = Thread.currentThread();
        System.out.println("主线程编号是： " + t1.getId()
                + " , 名称是： " + t1.getName());
    }

}
