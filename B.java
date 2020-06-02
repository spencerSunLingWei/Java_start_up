package com.stage1.part5.task1;

public class B /*extends A*/{

    private A a;

    public B(A a){
        this.a = a;
    }

    public void test(){

        //想调用A里的show方法
        //1.继承，但不好用
        //show();

        //2.合成复用原则
        a.show();
    }
}
