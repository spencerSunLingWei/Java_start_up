package com.stage1.part3.task2;

import com.stage1.part2.task5.StaticOuter;

public class StringDifferenceTest {

    public static void main(String[] args) {

        /**
         * 考题一
         */
        //创建一个对象，存放在常量池中
        String stra = "hello";

        //创建两个对象，一个在常量池中，一个在堆区中
        String strb = new String("hello");

        System.out.println("-------------------------------------");

        /**
         * 考题二
         */
        String str1 = "hello";  //常量池
        String str2 = "hello";  //常量池
        String str3 = new String("hello");  //堆区
        String str4 = new String("hello");  //堆区

        System.out.println(str1 == str2);   //地址，true
        System.out.println(str1.equals(str2));  //内容，true
        System.out.println(str3 == str4);   //地址，false
        System.out.println(str3.equals(str4));  //内容，true
        System.out.println(str2 == str4);   //地址，false
        System.out.println(str2.equals(str4));  //内容，true

        System.out.println("-------------------------------------");

        /**
         * 考点三
         */
        String str5 = "abcd";
        String str6 = "ab" + "cd";  //常量优化机制
        System.out.println(str5 == str6); //true

        String str7 = "ab";
        String str8 = str7 + "cd";
        System.out.println(str5 == str8); //false, 因为str7是一个变量
    }
}
