package com.stage1.part2.hw2;

import com.stage1.part2.task5.DirectionEnue;
import com.stage1.part2.task5.DirectionEnum;
import com.stage1.part2.task5.DirectionUseTest;

public enum CardTypeEnumTest {

    BIG("big"),SMALL("small"),MICRO("micro");
    private final String type;

    private CardTypeEnumTest(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static void print(CardTypeEnumTest in){
        switch(in){
            case BIG:
                System.out.println("big type");
                break;
            case SMALL:
                System.out.println("small type");
                break;
            case MICRO:
                System.out.println("micro type");
                break;
            default:
                System.out.println("not at all");
        }
    }

    public static void main(String[] args) {
        CardTypeEnumTest.print(CardTypeEnumTest.BIG);
        CardTypeEnumTest.print(CardTypeEnumTest.SMALL);
        CardTypeEnumTest.print(CardTypeEnumTest.MICRO);
    }


}
