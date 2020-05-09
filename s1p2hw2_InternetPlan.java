package com.stage1.part2.hw2;

public class InternetPlan extends Plan implements InternetInterface {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    //variable declaration
    private int internet;

    //constructor
    public InternetPlan() {
    }

    public InternetPlan(double monthlyDue, int internet) {
        super(monthlyDue);
        this.internet = internet;
    }

    //accessible functions
    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    //other functions
    public void print(){
        System.out.println(ANSI_BLUE + "Internet package plan: " + ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\tinternet amount: " + getInternet() + ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\ttotal monthly payment: " +getMonthlyDue() + ANSI_RESET);
    }

    //from interface
    @Override
    public void internetFunction(int data, Simcard card) {
        card.setInternetAmount(data);
    }
}
