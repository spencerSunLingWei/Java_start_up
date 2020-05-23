package com.stage1.part4.task3;

public class ProduceThread extends Thread{

    private StoragePlace storagePlace;

    public ProduceThread(StoragePlace storagePlace) {
        this.storagePlace = storagePlace;
    }

    @Override
    public void run() {
        while(true){
            storagePlace.produceProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
