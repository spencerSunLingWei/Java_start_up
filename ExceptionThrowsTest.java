package com.stage1.part4.task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionThrowsTest {

    public static void show() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        System.out.println("here");
        fis.close();
    }

    public static void test1() throws IOException {
        show();
    }

    public static void test2() throws IOException {
        test1();
    }

    public static void test3() throws IOException {
        test2();
    }

    public static void main(String[] args) /*throws IOException*/ {

        try {
            show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            test3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
