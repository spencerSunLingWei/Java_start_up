package com.stage1.part4.task2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 通过流对象写入数据内容，每当写入一个字符后，则文件中的读写位置向后移一位
 */

public class FileWriterTest {

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            //若文件存在，该流会清空文件中的原有内容
            //若文件不存在，该流会自动创建新的空文件
            fw = new FileWriter("/Users/spencersun/Desktop/a.txt");

            //以追加的方式创建对象
            //fw = new FileWriter("/Users/spencersun/Desktop/a.txt",true);

            fw.write('a');

            // 准备一个字符数组
            char[] cArr = new char[]{'h','e','l','l','o'};
            fw.write(cArr,1,3);

            fw.write(cArr);

            //刷新流
            fw.flush();

            System.out.println("write in successfully");
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
        }

    }
}
