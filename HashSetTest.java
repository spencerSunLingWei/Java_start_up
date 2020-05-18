package com.stage1.part3.task5;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {

        //LinkedHashSet 记录顺序， HashSet 不记录顺序
        Set<String> s1 = new HashSet<>();
        System.out.println("s1 = " + s1);

        System.out.println("-------------------------------");

        boolean b1 = s1.add("two");
        b1 = s1.add("one");
        b1 = s1.add("three");
        b1 = s1.add("one");
        System.out.println("b1 = " + b1);
        System.out.println("s1 = " + s1);
    }
}
