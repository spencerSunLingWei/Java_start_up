package com.stage1.part2.task4;

public class FixedAccount extends Account{

    public FixedAccount(double money) {
        super(money);
    }

    @Override
    public double getInterset() {
        return getMoney() * 0.03 * 1;
    }

    public static void main(String[] args) {
        Account a = new FixedAccount(1000);
        double res = a.getInterset();
        System.out.println("interest is =" + res);
    }
}
