package com.stage1.part3.task5;

public class PersonTest {

    public static void main(String[] args) {

        Person<Boolean> p1 = new Person("pckk", 20, "男");
        System.out.println("p1 = " + p1);

        Person<Boolean> p2 = new Person<>("pckk", 20, true);
        System.out.println("p2 = " + p2);

        Integer[] int_arr = {11,22,33,44,55};
        Person.printArray(int_arr);

    }
}
