package com.stage1.part4.task3;

public class ThreadJoinTest extends Thread{

    @Override
    public void run() {
        System.out.println("count down starts");
        for(int i=10; i>0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("happy new year!");
    }

    public static void main(String[] args) {
        ThreadJoinTest tjt = new ThreadJoinTest();
        tjt.start();

        System.out.println("main start waiting");
        try {
            //主线程等子线程完成
            //tjt.join();

            //等5s
            tjt.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("wait!");
    }
}
