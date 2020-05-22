package com.stage1.part4.task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteCopyTest {

    public static void main(String[] args) {

        long g1 = System.currentTimeMillis();

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            //fileInputStream = new FileInputStream("/Users/spencersun/Desktop/deleveries.png");
            //fileOutputStream = new FileOutputStream("/Users/spencersun/Desktop/a.png");

            fileInputStream = new FileInputStream("/Users/spencersun/Desktop/recording.MP4");
            fileOutputStream = new FileOutputStream("/Users/spencersun/Desktop/a.MP4");

            System.out.println("start copying");

            /*
            // 方法一：
            // 以字节的形式拷贝
            // 缺点：文件大时，拷贝的效率低
            int res = 0;
            while( (res = fileInputStream.read()) != -1){
                fileOutputStream.write(res);
            }
            */

            /*
            // 方法二：
            // 建一个缓冲区，一次性拷贝
            // 缺点：文件大时，没法申请和文件大小一样的内存，真是物理内存不够
            int len = fileInputStream.available();
            System.out.println("the file size is: " + len);
            byte[] bArr = new byte[len];
            int res = fileInputStream.read(bArr);
            System.out.println("rhe file size read is: " + res);
            fileOutputStream.write(bArr);
            */

            // 方法三：
            // 准备一个适当大小的缓冲区，分多次将文件拷贝完成
            byte[] bArr = new byte[1024];
            int res = 0;
            while((res = fileInputStream.read(bArr)) != -1){
                fileOutputStream.write(bArr, 0, res);
            }


            System.out.println("finished copying");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileOutputStream){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileInputStream) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long g2 = System.currentTimeMillis();
        System.out.println("time cost = " + (g2-g1));
    }
}
