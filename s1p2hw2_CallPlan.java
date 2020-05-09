package com.stage1.part2.hw2;

public class CallPlan extends Plan implements CallInterface{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    //variable declaration
    private int call;
    private int text;

    //constructor
    public CallPlan() {
    }

    public CallPlan(double monthlyDue, int call, int text) {
        super(monthlyDue);
        this.call = call;
        this.text = text;
    }

    //accessible functions
    public int getCall() {
        return call;
    }

    public void setCall(int call) {
        this.call = call;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    //other functions
    public void print(){
        System.out.println(ANSI_YELLOW + "Call package plan: " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\t\tcalling time interval: " + getCall() + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\t\ttexting amount: " + getText() + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\t\ttotal monthly payment: " +getMonthlyDue() + ANSI_RESET);
    }

    //from interface
    @Override
    public void callFunction(int time, Simcard card) {
        card.setCallAmount(time);
    }
}
