package com.stage1.part5.task2;

import java.util.Comparator;

public class DiamondTest {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }
}
