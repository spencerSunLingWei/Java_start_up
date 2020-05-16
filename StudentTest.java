package com.stage1.part3.task1;

public class StudentTest {

    public static void main(String[] args) {

        Student s1 = new Student(1000,"pckk");
        Student s2 = new Student(1001,"pckk");

        //inherited from the object class is default to compare the two objects' address
        //otherwise if overrides
        boolean b1 = s1.equals(s2);
        System.out.println("b1 = " + b1);
        System.out.println(s1 == s2);

        System.out.println("----------------------");

        //先调用继承下来的原hashcode()方法需要重写
        int ia = s1.hashCode();
        int ib = s2.hashCode();

        System.out.println("ia = " + ia);
        System.out.println("ib = " + ib);

        System.out.println("----------------------");

        //继承下来的原toString方法
        //获取调用对象的字符串形式：报名.类名@hashcode的16进制
        //重写
        String str1 = s1.toString();
        System.out.println("str1 = " + str1);
        System.out.println(s2); //当打印一个引用变量的时候，会自动调用toString方法
    }
}
