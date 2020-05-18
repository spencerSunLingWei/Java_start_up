package com.stage1.part3.task5;

import java.util.LinkedList;
import java.util.List;

public class ListGenericTest {

    public static void main(String[] args) {

        List<String> lt1 = new LinkedList<String>();
        lt1.add("one");
        System.out.println("lt1 = " + lt1);

        String s = lt1.get(0);
        System.out.println("element: " + s);

        System.out.println("-----------------------------------------------");

        List<Double> lt3 = new LinkedList<>();



    }
}
