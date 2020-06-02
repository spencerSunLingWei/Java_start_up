package com.stage1.part5.task1;

public abstract class AbstractCalculator {

    public int splitExpression(String exp, String op){
        String[] sArr = exp.split(op);
        return calculate(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]));
    }

    public abstract int calculate(int ia, int ib);

}
