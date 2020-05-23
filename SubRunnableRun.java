package com.stage1.part4.task3;

public class SubRunnableRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i<=20; i++){
            System.out.println("run methods: i = " + i);
        }
    }
}
