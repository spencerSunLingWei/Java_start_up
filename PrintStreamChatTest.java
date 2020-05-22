package com.stage1.part4.task2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintStreamChatTest {

    public static void main(String[] args) {

        Date d1 = new Date();
        SimpleDateFormat sdf = sdf = new SimpleDateFormat("yyyy-MM-dd HH::mm::ss");

        boolean flag = false;
        PrintStream ps = null;
        BufferedReader br = null;

        try {
            ps = new PrintStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt",true));

            // 参数需要时Reader类，Reader是abstract的，不能直接new
            // System.in代表键盘输入，是InputStream类型的
            br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.println((flag ? "Person A: " : "Person B: ") + "请输入需要发送的聊天内容");

                String str = null;
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if ("bye".equals(str)) {
                    System.out.println("聊天结束");
                    break;
                }
                //else {
                ps.println( sdf.format(d1) + (flag ? " Person A: " : " Person B: ") + str);
                //}
                flag = ! flag;

            }
            ps.println();
            ps.println();
            ps.println();
            ps.println();
            ps.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ps) {
                ps.close();
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
