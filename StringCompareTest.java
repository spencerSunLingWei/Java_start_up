package com.stage1.part3.task2;

public class StringCompareTest {

    public static void main(String[] args) {

        String str1 = new String("hello");
        System.out.println("str1 = " + str1);

        //Ascii code 差多少
        System.out.println(str1.compareTo("w"));
        System.out.println(str1.compareTo("world"));

        //string length 差多少
        System.out.println(str1.compareTo("hello world"));
        System.out.println(str1.compareToIgnoreCase("HELLO"));
    }
}
