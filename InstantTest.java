package com.stage1.part3.task3;

import com.stage1.part2.task5.StaticOuter;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    public static void main(String[] args) {

        //不是当前系统默认时区，是在本初子午线的时区
        Instant now = Instant.now();
        System.out.println(now);

        //加上时区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(-4));
        System.out.println(offsetDateTime);

        //获取当前对象与标准时间相差的毫秒数
        long g1 = now.toEpochMilli();
        System.out.println(g1);

        //用参数指定的毫秒数来构造对象
        Instant instant = Instant.ofEpochMilli(g1);
        System.out.println(instant);


    }
}
