package com.stage1.part3.task3;


import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println("d1 = " + d1);

        Date d2 = new Date(1000);
        System.out.println("d2 = " + d2);

        System.out.println("---------------------------------");

        long msec = d2.getTime();
        System.out.println("距离的毫秒数是" + msec + "毫秒");

        d2.setTime(5000);
        System.out.println("d2 = " + d2);
    }
}
