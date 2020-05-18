package com.stage1.part3.task4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue q1 = new LinkedList();
        System.out.println("q1 = " + q1);

        for(int i = 1; i<=5; i++){
            boolean b1 = q1.offer(i*11);
            System.out.println("b1 = " + b1);
            System.out.println("q1 = " + q1);
        }

        System.out.println("peek value = " + q1.peek());

        while(q1.size()!=0){
            System.out.println("polled = " + q1.poll());
        }
    }
}
