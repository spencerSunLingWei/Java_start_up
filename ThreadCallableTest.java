package com.stage1.part4.task3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        int num = 0;
        for(int i=1; i<=1000; i++){
            num+=i;
        }
        System.out.println("overall sum = " + num);
        return num;
    }

    public static void main(String[] args) {

        ThreadCallableTest tct = new ThreadCallableTest();
        FutureTask ft = new FutureTask(tct);

        Thread t1 = new Thread(ft);
        t1.start();

        Object obj = null;
        try {
            obj = ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("return output = " + obj);
    }
}
