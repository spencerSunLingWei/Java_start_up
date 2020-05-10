package com.stage1.part2.task4;

public interface Hunter extends Runner {
    public abstract void hunt();

    //默认方法
    public default void walk(){
        System.out.println("你可以重写，也可以不重写无所谓，不会报错");
    }

    //静态方法 belongs to接口层级 Hunter.
    public static void test(){
        System.out.println("静态方法，通过接口名.提取");
    }
}
