package com.stage1.part3.task3;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = dateTimeFormatter.format(now);;
        System.out.println(str);

        TemporalAccessor parse = dateTimeFormatter.parse(str);
        System.out.println(parse);

    }
}
