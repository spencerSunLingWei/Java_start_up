package com.stage1.part2.task3;

//control + shift + / 选中内容的多行注释
//control + / 选中内容的单行注释

//final class cannot be extends
public /*final*/ class FinalClass {
    //显示初始化 final值不能被改变
    private final int cnt = 1;

    //构造块初始化 final值不能被改变
    private final int cnt2;
    {
        cnt2 = 2;
    }
    //final function cannot be override but can be extends
    public /*final*/ void show(){
        System.out.println("hahahaha" + cnt + cnt2);
    }

    public static void main(String[] args) {
        FinalClass f = new FinalClass();
        f.show();
    }
}
