package com.stage1.part4.task5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class StudentTest {

    public static void main(String[] args) throws Exception {

        Class c1 = Class.forName("com.stage1.part4.task5.Student");
        System.out.println("获取到的包信息是： " + c1.getPackage());
        System.out.println("获取到的父类信息是： " + c1.getSuperclass());

        System.out.println("------------------------------");
        System.out.println("获取到的接口信息是： ");
        Class[] interfaces = c1.getInterfaces();
        for(Class ct:interfaces){
            System.out.println(ct + " ");
        }
        System.out.println();

        System.out.println("------------------------------");
        System.out.println("获取到的注解信息是：");
        Annotation[] annotations = c1.getAnnotations();
        for(Annotation at:annotations){
            System.out.println(at + " ");
        }
        System.out.println();

        System.out.println("------------------------------");
        System.out.println("获取到的泛型信息是： ");
        Type[] genericInterfaces = c1.getGenericInterfaces();
        for(Type tt:genericInterfaces){
            System.out.println(tt + " ");
        }
        System.out.println();


    }
}
