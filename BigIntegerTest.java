package com.stage1.part3.task1;

import java.math.BigInteger;

public class BigIntegerTest {

    public static void main(String[] args) {

        BigInteger b1 = new BigInteger("20");
        BigInteger b2 = new BigInteger("8");

        System.out.println("add + " + b1.add(b2));
        System.out.println("sub + " + b1.subtract(b2));
        System.out.println("mul + " + b1.multiply(b2));
        System.out.println("div + " + b1.divide(b2));
        System.out.println("remainder + " + b1.remainder(b2));

        System.out.println("-----------------------------------");

        BigInteger[] arr = b1.divideAndRemainder(b2);
        for (int i = 0; i<arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
