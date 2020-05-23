package com.stage1.part4.task3;

public class SubRunnable1 implements Runnable{
    @Override
    public void run() {
        for(int i=1; i<=100; i+=2){
            System.out.println("Odd number : " + i);
        }
    }

}
