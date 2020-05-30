package com.stage1.part4.task5;

public class ClassTest {

    public static void main(String[] args) {

        Class c1 = String.class;
        System.out.println("c1 = " + c1);

        c1 = int.class;
        System.out.println("c1 = " + c1);

        c1 = void.class;
        System.out.println("c1 = " + c1);

        System.out.println("--------------------------------");

        String str1 = new String("hello");
        c1 = str1.getClass();
        System.out.println("c1 = " + c1);

        System.out.println("--------------------------------");

        c1 = Integer.TYPE;
        System.out.println("c1 = " + c1);
        c1 = Integer.class;
        System.out.println("c1 = " + c1);

        System.out.println("--------------------------------");

        try {
            c1 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("c1 = " + c1);

        System.out.println("--------------------------------");

        ClassLoader classLoader = ClassTest.class.getClassLoader();
        try {
            c1 = classLoader.loadClass("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("c1 = " + c1);

    }
}
