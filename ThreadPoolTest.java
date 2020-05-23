package com.stage1.part4.task3;

import com.stage1.part4.task1.ExceptionMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new ThreadCallableTest());

        executorService.shutdown();
    }
}
