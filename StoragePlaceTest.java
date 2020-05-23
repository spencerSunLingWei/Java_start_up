package com.stage1.part4.task3;

public class StoragePlaceTest {
    public static void main(String[] args) {
        StoragePlace storagePlace = new StoragePlace();
        ProduceThread t1 = new ProduceThread(storagePlace);
        ConsumerThread t2 = new ConsumerThread(storagePlace);

        t1.start();
        t2.start();
    }
}
