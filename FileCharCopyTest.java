package com.stage1.part4.task2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharCopyTest {

    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("/Users/spencersun/Desktop/a.txt");
            fw = new FileWriter("/Users/spencersun/Desktop/b.txt");

            int res = 0;
            while((res = fr.read()) != -1){
                fw.write(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
