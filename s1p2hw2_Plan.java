package com.stage1.part2.hw2;

public abstract class Plan {

    //variable declaration
    private double monthlyDue;

    //constructor
    public Plan() {
    }

    public Plan(double monthlyDue) {
        this.monthlyDue = monthlyDue;
    }

    //accessible functions
    public double getMonthlyDue() {
        return monthlyDue;
    }

    public void setMonthlyDue(double monthlyDue) {
        this.monthlyDue = monthlyDue;
    }

    //other functions
    public abstract void print();
}
