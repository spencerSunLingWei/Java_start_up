package com.stage1.part4.task5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class PersonConstructorTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        Person p1 = new Person();
        System.out.println("default constructor: " + p1);

        System.out.println("---------------------------------");

        System.out.println("enter the type that you want to create: ");
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();

        //Class c1 = Class.forName("com.stage1.part4.task5.Person");
        Class c1 = Class.forName(str1);
        System.out.println("default constructor: " + c1.newInstance());
        sc.close();

        System.out.println("---------------------------------");

        /*BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/spencersun/Desktop/a.txt")));
        String str2 = br.readLine();
        Class c2 = Class.forName(str2);
        br.close();*/

        Constructor constructor = null;
        try {
            constructor = c1.getConstructor();
            System.out.println("default constructor: " + constructor.newInstance());
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------");

        Person p2 = new Person("pckk",18);
        System.out.println("constructor: " + p2);

        System.out.println("---------------------------------");

        try {
            Constructor constructor1 = c1.getConstructor(String.class, int.class);
            System.out.println("constructor:" + constructor1.newInstance("pckk", 20));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------");

        Constructor[] constructors = c1.getConstructors();
        for(Constructor ct : constructors){
            System.out.println("修饰符：" + ct.getModifiers());
            System.out.println("方法名称: " + ct.getName());
            Class[] parameterTypes = ct.getParameterTypes();
            System.out.println("所有参数类型:");
            for(Class cs : parameterTypes){
                System.out.print(cs + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");
    }

}
