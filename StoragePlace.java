package com.stage1.part4.task3;

public class StoragePlace {

    private int cnt = 0;

    public synchronized void produceProduct() {
        notify();
        if(cnt<10){
            System.out.println(Thread.currentThread().getName() +
                    " is producing the no. " + (cnt+1) + " product.");
            cnt++;
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        notify();
        if(cnt>0){
            System.out.println(Thread.currentThread().getName() +
                    " is consuming the no. " + cnt + " product.");
            cnt--;
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
