package com.stage1.part3.task3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) throws Exception{

        Date d1 = new Date(2000-1900,8-1,20,17,1,1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d1);
        System.out.println(format);

        System.out.println("---------------------------------");

        /**
         * Q：既然Calendar类是抽象类，那么为啥可以获取Calendar类型的引用呢？
         * A：返回的不是Calendar对象，而是Calendar累的子类对象，形成了多态
         */
        Calendar instance = Calendar.getInstance();

        instance.set(2000,8-1,20,17,1,1);
        Date d2 = instance.getTime();
        String format1 = sdf.format(d2);
        System.out.println(format1);

        instance.set(Calendar.YEAR, 2018);
        Date d3 = instance.getTime();
        String format2 = sdf.format(d3);
        System.out.println(format2);

        instance.add(Calendar.MONTH,2);
        Date d4 = instance.getTime();
        String format3 = sdf.format(d4);
        System.out.println(format3);
    }
}
