package com.stage1.part2.task3;

//SuperTest class 中的静态代码块
//SubSuperTest class 中的静态代码块
//SuperTest class 中的构造块
//SuperTest class 中的凑造方法体
//SubSuperTest class 中的构造块
//SubSuperTest class 中的凑造方法体

import static java.lang.System.out;

public class SubSuperTest extends SuperTest {

    {
        out.println("SubSuperTest class 中的构造块");
    }

    static{
        out.println("SubSuperTest class 中的静态代码块");
    }

    public SubSuperTest(){
        out.println("SubSuperTest class 中的凑造方法体");
    }

    public static void main(String[] args) {
        SubSuperTest st = new SubSuperTest();
    }

}
