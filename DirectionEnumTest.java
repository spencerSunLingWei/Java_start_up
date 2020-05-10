package com.stage1.part2.task5;

public class DirectionEnumTest {

    public static void main(String[] args) {

        DirectionEnum[] arr = DirectionEnum.values();

        for(int i = 0; i < arr.length; i++){
            System.out.println("enum object: " + arr[i].toString());
            System.out.println("index number: " + arr[i].ordinal());
        }

        //所在对象的名称，不是desc本身的字符串
        DirectionEnum de = DirectionEnum.valueOf("DOWN");
        System.out.println("converted to: " + de.toString());
        System.out.println("converted to: " + de); //自动调用toString()方法

        for(int i = 0; i < arr.length; i++){
            System.out.println("compare position: " + de.compareTo(arr[i]));
        }

        arr[0].show();
    }

}
