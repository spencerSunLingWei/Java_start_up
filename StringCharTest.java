package com.stage1.part3.task2;

import com.stage1.part2.task5.StaticOuter;

public class StringCharTest {

    public static void main(String[] args) {

        String str1 = new String("hello");
        System.out.println("str1 = " + str1);

        System.out.println("length = " + str1.length());
        System.out.println("index 2 / value = " + str1.charAt(2));

        System.out.println(0==str1.length() ? "is empty" : "not empty");
        System.out.println(str1.isEmpty() ? "is empty" : "not empty");

        //字符串"12345"变成整数12345
        String str2 = new String("12345");
        int ia = Integer.parseInt(str2);
        System.out.println("convert to integer ia: " + ia);

        //'1'-'0' = 1
        int ib = 0;
        for(int i = 0; i<str2.length(); i++){
            ib = ib*10 + str2.charAt(i) - '0';
        }
        System.out.println("convert to integer ib: " + ib);
    }
}
