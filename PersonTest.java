package com.stage1.part4.task1;

public class PersonTest {

    public static void main(String[] args) {

        /**
         * p1 = null
         */
//        Person p1 = null;
//        try {
//            p1 = new Person("pckk", -30);
//        } catch (AgeException e) {
//            e.printStackTrace();
//        }
//        System.out.println("p1 = " + p1);

        /**
         * p1 = Person{name='pckk', age=0}
         */
        Person p1 = new Person("pckk", -30);
        System.out.println("p1 = " + p1);
    }
}
