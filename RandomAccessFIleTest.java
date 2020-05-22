package com.stage1.part4.task2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFIleTest {

    public static void main(String[] args) {

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("/Users/spencersun/Desktop/a.txt", "rw");

            //从文件开头位置往后偏移3位
            raf.seek(3);
            int res = raf.read();
            System.out.println("single char = " + (char)res);

            res = raf.read();
            System.out.println("single char = " + (char)res);

            raf.write('2'); //将原来e的位置替换成2

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != raf) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
