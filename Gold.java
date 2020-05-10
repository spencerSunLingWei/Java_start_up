package com.stage1.part2.task4;

public class Gold implements Metal, Money{
    @Override
    public void buy() {
        System.out.println("buy override");
    }

    @Override
    public void shine() {
        System.out.println("shine override");
    }

    public static void main(String[] args) {
        Metal a = new Gold();
        a.buy();

        Money b = new Gold();
        b.shine();
    }
}
