package com.stage1.part3.task3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) throws Exception {

        Date d1 = new Date();
        System.out.println("d1 = " + d1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = sdf.format(d1);
        System.out.println("after formatting = " + format);

        Date parse = sdf.parse(format);
        System.out.println("return back = " + parse);
    }
}
