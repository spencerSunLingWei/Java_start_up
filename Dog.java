package com.stage1.part3.task5;

import java.util.LinkedList;
import java.util.List;

public class Dog extends Animal{

    public static void main(String[] args) {

        List<Animal> lt1 = new LinkedList<>();
        List<Dog> lt2 = new LinkedList<>();
        //lt1=lt2; 类型之间不具备父子类关系

        System.out.println("-----------------------------");

        List<?> lt3 = new LinkedList<>();
        lt3 = lt1;
        lt3 = lt2;

        System.out.println("-----------------------------");

        //lt3.add(new Animal());  不能存放Animal类型的对象
        //lt3.add(new Dog());  不能存放Dog类型的对象
        //不支持元素的添加

        Object o = lt3.get(0); //当作Object类型对待

        System.out.println("-----------------------------");

        List<? extends Animal> lt4 = new LinkedList<>();
        //lt4.add(new Animal());  不能存放Animal类型的对象
        //lt4.add(new Dog());  不能存放Dog类型的对象
        Animal animal = lt4.get(0);     //存放animal和animal的子类

        List<? super Animal> lt5 = new LinkedList<>();  //存放animal和animal的父类
        lt5.add(new Animal());
        lt5.add(new Dog());
        Object o1 = lt5.get(0);
    }
}
