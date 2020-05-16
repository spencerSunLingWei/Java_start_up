package com.stage1.part3.task1;

public class DoubleTest {

    public static void main(String[] args) {

        Double db1 = Double.valueOf(3.14);
        System.out.println("db1 = " + db1);

        double d1 = db1.doubleValue();
        System.out.println("d1 = " + d1);

        Double db2 = 3.1415;
        double d2 = db2;

        System.out.println("------------------------------------------");

        double d3 = Double.parseDouble("13.14");
        System.out.println("d3 = " + d3);

        System.out.println("is double return false, is string return true - db2: " + db2.isNaN());

        Double db3 = Double.valueOf(0/0.0);
        System.out.println("is double return false, is string return true - db3: " + db3.isNaN());

        System.out.println("------------------------------------------");
    }
}
