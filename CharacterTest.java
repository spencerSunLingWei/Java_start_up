package com.stage1.part3.task1;

import com.stage1.part2.task5.StaticOuter;

public class CharacterTest {

    public static void main(String[] args) {

        //自动装箱拆箱
        Character ca2 = 'b';
        char c2 = ca2;
        System.out.println("c2 = " + c2);

        System.out.println(Character.isUpperCase(c2)); //false
        System.out.println(Character.isLowerCase(c2)); //true
        System.out.println(Character.isDigit(c2));     //false

        System.out.println("to upper: " + Character.toUpperCase(c2));
        System.out.println("to lower: " + Character.toLowerCase(c2));
    }
}
