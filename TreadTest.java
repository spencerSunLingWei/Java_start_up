package com.stage1.part4.task3;

public class TreadTest {

    public static void main(String[] args) {

        //Thread 类中的成员变量target的数值为null
        Thread t1 = new Thread();
        //由于成员变量target的数值为null，因此条件if（null！=target）不成立，跳过代码不执行
        //run方法中除了上述代码再无代码，因此证明run方法啥也不干
        t1.run();
        System.out.println("run?");
    }
}
