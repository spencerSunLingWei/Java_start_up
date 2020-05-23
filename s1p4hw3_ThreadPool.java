package com.stage1.part4.hw3;

import com.stage1.part4.task3.ThreadCallableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new ThreadCallable());

        executorService.shutdown();

    }
}
