package com.stage1.part4.task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionCatchTest {

    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            System.out.println("1");
            fis = new FileInputStream("/Users/spencersun/Desktop/a.txt");
            System.out.println("2");
        } catch (FileNotFoundException e) {
            System.out.println("3");
            e.printStackTrace();
            System.out.println("4");
        }
        try {
            System.out.println("5");
                fis.close();
            System.out.println("6");
        } catch (IOException e) {
            System.out.println("7");
            e.printStackTrace();
            System.out.println("8");
        } catch(NullPointerException e) {
            System.out.println("9");
            e.printStackTrace();
            System.out.println("10");
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
