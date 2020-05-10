package com.stage1.part2.task4;

//can allow 一个儿子有两个爸爸，实现多个继承
public interface InterfaceTest {
    //cannot use private
    //public must use final
    //constant number access by using InterfaceTest.

    public static final int CNT = 1;

    //public must be abstract
    public abstract void show1();

    //new standards
    private void show2() {}

}
