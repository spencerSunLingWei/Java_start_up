package com.stage1.part2.hw2;

public class Simcard {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    //variable declaration
    private String cardType;
    private int cardNumber;
    private String username;
    private String password;
    private double accountBalance;
    private double callAmount;
    private double internetAmount;

    //constructor
    public Simcard() {
    }

    public Simcard(String cardType, int cardNumber, String username, String password, double accountBalance, double callAmount, double internetAmount) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.username = username;
        this.password = password;
        this.accountBalance = accountBalance;
        this.callAmount = callAmount;
        this.internetAmount = internetAmount;
    }

    //accessible functions
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getCallAmount() {
        return callAmount;
    }

    public void setCallAmount(double callAmount) {
        this.callAmount = callAmount;
    }

    public double getInternetAmount() {
        return internetAmount;
    }

    public void setInternetAmount(double internetAmount) {
        this.internetAmount = internetAmount;
    }

    //other functions
    public void print(){
        System.out.println(ANSI_RED + "SIM card information: " + ANSI_RESET);
        System.out.println(ANSI_RED + "\t\tcard number: " + getCardNumber() + ANSI_RESET);
        System.out.println(ANSI_RED + "\t\tusername: " + getUsername() + ANSI_RESET);
        System.out.println(ANSI_RED + "\t\taccount balance: " + getAccountBalance() + ANSI_RESET);
    }

}
