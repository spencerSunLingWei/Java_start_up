package com.stage1.part4.task3;

public class ConsumerThread extends Thread{

    private StoragePlace storagePlace;

    public ConsumerThread(StoragePlace storagePlace) {
        this.storagePlace = storagePlace;
    }

    @Override
    public void run() {
        while(true){
            storagePlace.consumerProduct();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
