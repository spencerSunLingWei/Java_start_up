package com.stage1.part4.task3;

public class SubRunnableTest {

    public static void main(String[] args) {

        SubRunnableRun srr = new SubRunnableRun();

        //若使用Runnable引用构造了线程对象，调用该方法（run）时最终调用接口中的版本
        //由源码可知：
        //if (null != target){
        //      target.run();
        //}
        //此时target的数值不为空这个条件成立，执行target.run()代码，也就是srr.run（）；

        Thread t1 = new Thread(srr);
        t1.start();

        for (int i = 0; i<=20; i++){
            System.out.println("main methods: i = " + i);
        }

    }
}
