package com.stage1.part2.task4;

public abstract class AbstractTest {
    private int cnt;

    public AbstractTest() {
    }

    public AbstractTest(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    //show() = 0 in c++
    //提醒extends的人来implement这个function
    public abstract void show();

    public static void main(String[] args) {
        //error, after abstract cannot create that class's object
        //AbstractTest at = new AbstractTest();
    }
}
