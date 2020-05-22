package com.stage1.part4.task2;

import java.io.*;

public class BufferedCharCopyTest {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("/Users/spencersun/Desktop/a.txt"));
            bw = new BufferedWriter(new FileWriter("/Users/spencersun/Desktop/b.txt"));

            String str = null;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();   //多了一个行分隔符，系统中的是\r\n
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
