package com.stage1.part3.task3;

public class SystemTest {

    public static void main(String[] args) {

        //获取当前系统时间，距离1970年1月1日0分0秒的毫秒数
        long msec = System.currentTimeMillis();
        System.out.println("already passed " + msec + "seconds");

    }
}
