package com.stage1.part5.task1;

public class AbstractCalculatorTest {

    public static void main(String[] args) {

        AbstractCalculator abstractCalculator = new Plus();
        int res = abstractCalculator.splitExpression("1+1", "\\+");
        System.out.println("result = " + res);
    }
}
