package com.stage1.part3.task1;

public class IntegerTest {

    public static void main(String[] args) {
        System.out.println("max number is: " + Integer.MAX_VALUE);
        System.out.println("min number is: " + Integer.MIN_VALUE);
        System.out.println("binary bit: " + Integer.SIZE);
        System.out.println("byte occupied: " + Integer.BYTES);
        System.out.println("class is: " + Integer.TYPE);

        System.out.println("------------------------------------------");

        //已经过时了
        //Integer it1 = new Integer(123);
        //Integer it2 = new Integer("456");

        //用value of替代
        //int类型转换为Integer类型，叫做装箱
        Integer it3 = Integer.valueOf(123);
        System.out.println("value of it3: " + it3);
        Integer it4 = Integer.valueOf("456");
        System.out.println("value of it4: " + it4); //自动调用toString，是String类型

        //Integer类型到int类型的转换，叫做拆箱
        int ia = it4.intValue();
        System.out.println("value of ia: " + ia); //456得到的为int类型

        System.out.println("------------------------------------------");

        //从java5之后有了自动拆箱和装箱
        Integer it5 = 100;  //直接运用赋值运算符实现自动装箱
        int ib = it5;       //直接运用赋值运算符实现自动拆箱

        System.out.println("------------------------------------------");

        //装箱和拆箱的笔试考点

        Integer it6 = 128;
        Integer it7 = 128;
        Integer it8 = new Integer(128);
        Integer it9 = new Integer(128);
        System.out.println(it6 == it7);         //false
        System.out.println(it6.equals(it7));    //true
        System.out.println(it8 == it9);         //false
        System.out.println(it8.equals(it9));    //true

        //有一个自动装箱池，将-128到127之前整数提前装箱完毕，直接提取值即可
        it6 = 127;
        it7 = 127;
        it8 = new Integer(127);
        it9 = new Integer(127);
        System.out.println(it6 == it7);         //true
        System.out.println(it6.equals(it7));    //true
        System.out.println(it8 == it9);         //false
        System.out.println(it8.equals(it9));    //true

        System.out.println("------------------------------------------");

        //静态方法调用
        int ic = Integer.parseInt("200");
        System.out.println("string to int：" + ic);
        System.out.println("int to string decimal: " + Integer.toString(200));
        System.out.println("int to string hex: " + Integer.toHexString(200));
        System.out.println("int to string binary: " + Integer.toBinaryString(200));
        System.out.println("int to string oct:" + Integer.toOctalString(200));
    }
}
