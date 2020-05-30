package com.stage1.part4.task4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStringTest {

    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(8888);

            while(true) {
                System.out.println("等待客户端的连接请求");

                //当没有客户端链接的时候，则服务器阻塞在accept方法这里
                s = ss.accept();
                System.out.println("客户端 " + s.getInetAddress() + " 连接成功");

                new ServerThread(s).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
