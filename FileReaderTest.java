package com.stage1.part4.task2;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) {

        FileReader fr = null;
        try {
            fr = new FileReader("/Users/spencersun/Desktop/a.txt");

            //指针所指的单个字符
            /*int res = 0;
            while((res = fr.read()) != -1) {
                System.out.println("the character read from the file is:" + (char) res);
            }*/

            char[] cArr = new char[5];
            //从指针处，读取3个字符，放入数组cArr中下标从1开始的位置上
            /*int res = fr.read(cArr,1,3);
            System.out.println("实际取到的字符个数是：" + res);
            for (char cv:cArr){
                System.out.println("char in the array: " + (char)cv);
            }*/

            //期望读满整个字符数组
            int res = fr.read(cArr);
            System.out.println("实际取到的字符个数是：" + res);
            for (char cv:cArr){
                System.out.println("char in the array: " + (char)cv);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
