package com.stage1.part3.task2;

import java.util.Scanner;

/**
 * 对数据格式的验证
 */
public class StringRegTest {

    public static void main(String[] args) {

        /**
         * 银行卡密码，6位数字密码
         */
        //String reg = "^[0-9]{6}$";
        String reg = "\\d{6}";

        /**
         * qq号密码，非0开头的5-15位数字组成
         */
        //String reg = "[1-9]\\d{4,14}";

        /**
         * 手机号，开头为1，第二位为3，4，5,7，8重的一位，一共11位数字
         */
        //String reg = "1[34578]\\d{9}";

        /**
         * 6位为地区，4为年份，2为月，2代表日期，3代表个人，最后一位为数字orX
         */
        //String reg = "\\d{6}\\d{4}\\d{2}\\d{2}\\d{3}[0-9X]";

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("enter the number");

            String password = sc.next();

            if (password.matches(reg)) {
                System.out.println("good");
                break;
            }
        }

        System.out.println("----------------------------------------------");

        String str1 = "1001,pckk,30";
        System.out.println("string is: " + str1);

        String[] sArr = str1.split(",");
        for(int i=0; i<sArr.length; i++){
            System.out.println(i + " " + sArr[i]);
        }

        System.out.println("----------------------------------------------");

        String str2 = "my name is shabi，shabi";
        String str3 = str2.replace("shabi","pckk");
        System.out.println(str2);
        System.out.println(str3);

        System.out.println("----------------------------------------------");

        String str4 = "123abc456def789ghi";
        System.out.println(str4);

        String str5 = str4.replaceFirst("\\d+", "#");
        System.out.println(str5);

        String str6 = str4.replaceAll("[a-z]+", "!");
        System.out.println(str6);
    }
}
