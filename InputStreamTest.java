package com.stage1.part5.task2;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("/Users/spencersun/Desktop/a.txt");
            outputStream = new FileOutputStream("/Users/spencersun/Desktop/b.txt");
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
