package com.stage1.part4.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket s;

    public ServerThread() {
    }

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;

        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());

            while(true) {
                String s1 = br.readLine();
                System.out.println("客户端 " + s.getInetAddress() + " 发来的字符串内容是：" + s1);

                if("bye".equalsIgnoreCase(s1)){
                    System.out.println("客户端 " + s.getInetAddress() + " 已下线，结束");
                    break;
                }

                ps.println("I received");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ps){
                ps.close();
            }
            if(null != s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
