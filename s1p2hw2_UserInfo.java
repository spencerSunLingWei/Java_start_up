package com.stage1.part2.hw2;

public class UserInfo {

    //variable declaration
    private double totalCall;
    private double totalInternet;
    private double totalMonthlyDue;

    //constructor
    public UserInfo() {
    }

    public UserInfo(double totalCall, double totalInternet, double totalMonthlyDue) {
        this.totalCall = totalCall;
        this.totalInternet = totalInternet;
        this.totalMonthlyDue = totalMonthlyDue;
    }

    //accessible functions
    public double getTotalCall() {
        return totalCall;
    }

    public void setTotalCall(double totalCall) {
        this.totalCall = totalCall;
    }

    public double getTotalInternet() {
        return totalInternet;
    }

    public void setTotalInternet(double totalInternet) {
        this.totalInternet = totalInternet;
    }

    public double getTotalMonthlyDue() {
        return totalMonthlyDue;
    }

    public void setTotalMonthlyDue(double totalMonthlyDue) {
        this.totalMonthlyDue = totalMonthlyDue;
    }
}
