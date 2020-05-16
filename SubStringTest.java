package com.stage1.part3.task2;

import java.util.Scanner;

public class SubStringTest {

    public static void main(String[] args) {
        String str1 = new String("happy coding, happy life!");
        System.out.println("str1 = " + str1);

        String str2 = str1.substring(12);
        System.out.println("str2 = " + str2);

        String str3 = str1.substring(6,10);
        System.out.println("str3 = " + str3);

        System.out.println("---------------------------------");

        Scanner sc = new Scanner(System.in);

        System.out.println("enter a string and a char");
        String str4 = sc.next();
        String str5 = sc.next();
        int pos = str4.indexOf(str5);
        String str6 = str4.substring(pos+str5.length());
        System.out.println(str6);

        System.out.println("---------------------------------");

        //change int input to string output in two ways
        String str7 = String.valueOf(pos);
        str7 = "" + pos;
        System.out.println(str7);
    }
}
