package com.stage1.part4.task5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonMethodTest {

    public static void main(String[] args) {

        Person p1 = new Person("pckk", 20);
        System.out.println(p1.getName());

        System.out.println("------------------------------");

        try {
            Class c1 = Class.forName("com.stage1.part4.task5.Person");
            Constructor constructor = c1.getConstructor(String.class, int.class);
            Object object = constructor.newInstance("pckk", 30);
            Method method = c1.getMethod("getName");
            System.out.println(method.invoke(object));

            System.out.println("------------------------------");

            Method[] methods = c1.getMethods();
            for(Method mt:methods){
                System.out.println(mt.getModifiers());
                System.out.println(mt.getReturnType());
                System.out.println(mt.getName());
                Class<?>[] parameterTypes = mt.getParameterTypes();
                for(Class ct:parameterTypes){
                    System.out.println(ct+" ");
                }
                System.out.println();
                System.out.println("----");
                Class<?>[] exceptionTypes = mt.getExceptionTypes();
                for(Class ct:exceptionTypes){
                    System.out.println(ct + " ");
                }
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
        }

    }
}
