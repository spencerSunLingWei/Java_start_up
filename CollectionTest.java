package com.stage1.part5.task2;

import java.util.List;
import java.util.Map;

public class CollectionTest {

    public static void main(String[] args) {

        //不可以改变的
        List<Integer> list = List.of(1,2,3,4,5);
        System.out.println(list);

        Map<Integer, String> map = Map.of(1,"one",2,"410");


    }
}
