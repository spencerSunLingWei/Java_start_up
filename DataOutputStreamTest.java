package com.stage1.part4.task2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

    public static void main(String[] args) {

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));

            //写4个字节，高字节先写
            int num = 66;
            dos.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != dos) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
