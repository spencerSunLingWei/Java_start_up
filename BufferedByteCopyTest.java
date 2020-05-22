package com.stage1.part4.task2;

import java.io.*;

public class BufferedByteCopyTest {

    public static void main(String[] args) {

        long g1 = System.currentTimeMillis();



        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("/Users/spencersun/Desktop/recording.MP4"));
            bos = new BufferedOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.MP4"));

            System.out.println("start copying");

            byte[] bArr = new byte[1024];
            int res = 0;
            while( (res = bis.read(bArr)) != -1){
                bos.write(bArr, 0, res);
            }
            System.out.println("finish copying");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != bis){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        long g2 = System.currentTimeMillis();
        System.out.println("time cost = " + (g2-g1));
    }
}
