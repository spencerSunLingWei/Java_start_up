package com.stage1.part4.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringTest {

    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        Scanner sc = null;
        BufferedReader br = null;
        try {
            s = new Socket("192.168.2.49",8888);
            System.out.println("连接服务器成功");
            ps = new PrintStream(s.getOutputStream());
            sc = new Scanner(System.in);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while(true) {
                //Thread.sleep(10000);
                System.out.println("请输入要发送的内容：");
                String str1 = sc.next();
                ps.println(str1);
                System.out.println("客户端发送数据内容成功");

                if("bye".equalsIgnoreCase(str1)){
                    System.out.println("关闭结束");
                    break;
                }

                String str2 = br.readLine();
                System.out.println("服务器发来的字符串内容是：" + str2);
            }

        } catch (IOException  /*| InterruptedException*/ e) {
            e.printStackTrace();
        } finally {
            if(null != s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ps){
                ps.close();
            }
            if(null != sc){
                sc.close();
            }
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
