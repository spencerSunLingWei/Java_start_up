package com.stage1.part2.task4;

public abstract class Account {

    private double money;

    public Account() {
    }

    public Account(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    //abstract & static, private, final cannot use together
    public abstract double getInterset();
}
