package com.stage1.part4.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
object input stream没有办法读object是否已经读完，所以最好放入一个集合，然后从中读object
 */

public class ObjectInputStreamTest {

    public static void main(String[] args) {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            Object obj = ois.readObject();
            System.out.println("object = " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
