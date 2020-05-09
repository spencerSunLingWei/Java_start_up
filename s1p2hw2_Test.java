package com.stage1.part2.hw2;

public class Test {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {

        System.out.println("\n==========================================\n");

        Simcard sc1 = new Simcard();
        sc1.print();
        Simcard sc2 = new Simcard("no name", 1111, "no name", "no passward", 77.77, 10.10, 10.10);
        sc2.print();

        System.out.println("\n==========================================\n");

        EnumerateTest c1 = EnumerateTest.getBIG();
        c1.print();

        EnumerateTest c2 = EnumerateTest.getSMALL();
        c2.print();

        EnumerateTest c3 = EnumerateTest.getMICRO();
        c3.print();

        System.out.println("\n==========================================\n");

        UserInfo ui = new UserInfo();
        System.out.println(ANSI_CYAN + "User info:" +ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\ttotal calling interval: " + ui.getTotalCall() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\ttotal internet usage: " + ui.getTotalInternet() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\ttotal monthly due: " + ui.getTotalMonthlyDue() + ANSI_RESET);
        UserInfo up = new UserInfo(1000, 10, 134);
        System.out.println(ANSI_CYAN + "User info:" +ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\ttotal calling interval: " + up.getTotalCall() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\ttotal internet usage: " + up.getTotalInternet() + ANSI_RESET);
        System.out.println(ANSI_CYAN + "\t\ttotal monthly due: " + up.getTotalMonthlyDue() + ANSI_RESET);

        System.out.println("\n==========================================\n");

        Plan pa = new CallPlan();
        pa.print();
        Plan pb = new CallPlan(77.77, 100, 100);
        pb.print();

        System.out.println("\n==========================================\n");

        Plan pc = new InternetPlan();
        pc.print();
        Plan pd = new InternetPlan(66.66, 4);
        pd.print();

        System.out.println("\n==========================================\n");

        CallPlan pf = new CallPlan(20, 500, 500);
        pf.print();
        pf.callFunction(20000, sc1);
        System.out.println(ANSI_CYAN + "Call time interval is being updated to: " + sc1.getCallAmount() + ANSI_RESET);

        System.out.println("\n==========================================\n");

        InternetPlan pe = new InternetPlan(10, 5);
        pe.print();
        pe.internetFunction(10000, sc1);
        System.out.println(ANSI_CYAN + "Internet time interval is being updated to: " + sc1.getInternetAmount() + ANSI_RESET);

        System.out.println("\n==========================================\n");
    }






}
