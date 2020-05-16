package com.stage1.part3.task1;

public class BooleanTest {

    public static void main(String[] args) {

        //手动装箱拆箱
        Boolean bo1 = Boolean.valueOf(true);
        System.out.println("bo1 = " + bo1);

        boolean b1 = bo1.booleanValue();
        System.out.println("b1 = " + b1);

        //自动装箱拆箱
        Boolean bo2 = false;
        boolean b2 = bo2;

        System.out.println("---------------------------");

        //只要参数值不是TRUE或者true，其余都是false
        boolean b3 = Boolean.parseBoolean("true");
        System.out.println("b3 = " + b3);
    }
}
