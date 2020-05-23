package com.stage1.part4.task3;

public class SubRunnable2 implements Runnable {
    @Override
    public void run() {
        for(int i=2; i<=100; i+=2){
            System.out.println("_______Even number : " + i);
        }
    }
}
