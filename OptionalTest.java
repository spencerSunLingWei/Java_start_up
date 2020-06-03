package com.stage1.part5.task2;

import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {

    public static void main(String[] args) {

        String str1 = null;
        if(null != str1) {
            System.out.println(str1.length());
        }
        else{
            System.out.println("null, length = 0");
        }

        System.out.println("-------------------------------");

        Optional<String> optional = Optional.ofNullable(str1);

        Optional<Integer> integer = optional.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

        System.out.println("integer = " + integer);
        System.out.println(integer.orElse(0));

        integer = optional.map(String::length);


    }
}
