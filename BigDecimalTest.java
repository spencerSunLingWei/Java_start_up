package com.stage1.part3.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 实现精确运算
 */

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("5.2");
        BigDecimal bd2 = new BigDecimal("1.3");

        System.out.println("add + " + bd1.add(bd2));
        System.out.println("sub + " + bd1.subtract(bd2));
        System.out.println("mul + " + bd1.multiply(bd2));
        System.out.println("div + " + bd1.divide(bd2));

        System.out.println("------------------------------");

        BigDecimal bd3 = new BigDecimal("2");
        BigDecimal bd4 = new BigDecimal("0.3");
        System.out.println("div + " + bd3.divide(bd4, RoundingMode.HALF_UP));


    }
}
