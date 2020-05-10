package com.stage1.part2.task5;

import java.util.function.DoubleToIntFunction;

public class DirectionUseTest {

    public static void test1(String str){
        switch(str){
            case "up":
                System.out.println("upupupup");
                break;
            case "down":
                System.out.println("downdowndowndown");
                break;
            case "left":
                System.out.println("leftleft");
                break;
            case "right":
                System.out.println("rightright");
                break;
            default:
                System.out.println("not at all");
        }
    }

    public static void test2(DirectionEnum de){
        switch(de){
            case UP:
                System.out.println("upupupup");
                break;
            case DOWN:
                System.out.println("downdowndowndown");
                break;
            case LEFT:
                System.out.println("leftleft");
                break;
            case RIGHT:
                System.out.println("rightright");
                break;
            default:
                System.out.println("not at all");
        }
    }
    public static void main(String[] args) {
        DirectionUseTest.test1(DirectionEnue.UP.getDesc());

        DirectionUseTest.test2(DirectionEnum.DOWN);
    }

}
