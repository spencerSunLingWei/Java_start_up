package com.stage1.part4.task2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {

    public static void main(String[] args) {

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));

            int res = dis.readInt(); //读4个字节
            System.out.println("res = " + res);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != dis) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
