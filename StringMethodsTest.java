package com.stage1.part3.task2;

import com.stage1.part2.task5.StaticOuter;

public class StringMethodsTest {

    public static void main(String[] args) {

        String str1 = new String("      some thing funny");
        System.out.println("str1 = " + str1);

        boolean b1 = str1.contains("some");
        System.out.println("b1 = " + b1);

        boolean b2 = str1.contains("something");
        System.out.println("b2 = " + b2);

        String str2 = str1.toUpperCase();
        System.out.println("str2 = " + str2);   //str1  自身不变，是一个常量

        String str3 = str2.toLowerCase();
        System.out.println("str3 = " + str3);

        String str4 = str1.trim();
        System.out.println("str4 = " + str4);

        b1 = str1.startsWith("LET");
        System.out.println(b1);
        b1 = str1.startsWith(" ");
        System.out.println(b1);

        b1 = str1.endsWith("nny");
        System.out.println(b1);
    }
}
