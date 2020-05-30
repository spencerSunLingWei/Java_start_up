package com.stage1.part4.task5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PersonFieldTest {

    public static void main(String[] args) {

        Person p1 = new Person("pckk", 20);
        System.out.println(p1.getName());

        System.out.println("--------------------------------");

        try {
            Class c1 = Class.forName("com.stage1.part4.task5.Person");
            Constructor constructor = c1.getConstructor(String.class, int.class);
            Object object = constructor.newInstance("pckk", 30);
            Field field = c1.getDeclaredField("name");

            //暴力设置，private to public
            field.setAccessible(true);

            System.out.println(field.get(object));
            field.set(object,"jesse");
            System.out.println(field.get(object));

            System.out.println("--------------------------------");

            Field[] declaredFeilds = c1.getDeclaredFields();
            for(Field ft : declaredFeilds){
                System.out.println(ft.getModifiers());
                System.out.println(ft.getType());
                System.out.println(ft.getName());
                System.out.println();
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
