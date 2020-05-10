package com.stage1.part2.task4;

public class Rect extends Shape {

    private int len;
    private int wid;

    public Rect() {
    }

    public Rect(int x, int y, int len, int wid) {
        super(x, y);
        this.len = len;
        this.wid = wid;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        if(len > 0)     this.len = len;
        else            System.out.println("invalid len input");
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        if(wid > 0)     this.wid = wid;
        else            System.out.println("invalid wid input");
    }

    @Override
    public void print() {
        super.print();
        System.out.println("wid = " + getWid() + " / len = " + getLen());
    }

    //error static function cannot be override
    public static void test(){
        System.out.println("rect 类重的静态方法");
    }
}
