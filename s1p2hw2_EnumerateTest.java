package com.stage1.part2.hw2;

public class EnumerateTest extends Simcard{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private static final EnumerateTest BIG = new EnumerateTest("big");
    private static final EnumerateTest SMALL = new EnumerateTest("small");
    private static final EnumerateTest MICRO = new EnumerateTest("micro");

    private EnumerateTest(String type){
        super();
        this.setCardType(type);
    }

    public static EnumerateTest getBIG() {
        return BIG;
    }

    public static EnumerateTest getSMALL() {
        return SMALL;
    }

    public static EnumerateTest getMICRO() {
        return MICRO;
    }

    public void print(){
        System.out.println(ANSI_PURPLE + "Card type: " + getCardType() + ANSI_RESET);
    }

    public static void main(String[] args) {
        EnumerateTest c1 = EnumerateTest.getBIG();
        c1.print();

        EnumerateTest c2 = EnumerateTest.getSMALL();
        c2.print();

        EnumerateTest c3 = EnumerateTest.getMICRO();
        c3.print();
    }
}


