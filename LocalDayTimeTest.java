package com.stage1.part3.task3;

import com.stage1.part2.task5.StaticOuter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDayTimeTest {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalTime now1 = LocalTime.now();
        System.out.println(now1);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        System.out.println("---------------------------------");

        LocalDateTime of = LocalDateTime.of(2008,8,8,20,8,8);
        System.out.println(of);
        System.out.println(of.getYear());
        System.out.println(of.getMonth());
        System.out.println(of.getDayOfMonth());

        System.out.println("---------------------------------");

        System.out.println(of.withYear(2020));
        System.out.println(of.withMonth(12));
        System.out.println(of.withDayOfMonth(31));
        System.out.println(of); //原先的值是不会改变的， 与String类型相似, 不可变的性质

        System.out.println("---------------------------------");

        System.out.println(of.plusYears(1000));
        System.out.println(of.minusDays(30));
    }
}
