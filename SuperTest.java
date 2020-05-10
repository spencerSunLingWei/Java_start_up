package com.stage1.part2.task3;

public class SuperTest {

    {
        System.out.println("SuperTest class 中的构造块");
    }

    static{
        System.out.println("SuperTest class 中的静态代码块");
    }

    public SuperTest(){
        System.out.println("SuperTest class 中的凑造方法体");
    }

    public static void main(String[] args) {
        SuperTest st = new SuperTest();
    }
}
