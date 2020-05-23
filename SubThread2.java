package com.stage1.part4.task3;

public class SubThread2 extends Thread{

    @Override
    public void run() {
        for(int i=2; i<=100; i+=2){
            System.out.println("Even number" + i + "_______");
        }
    }
}
