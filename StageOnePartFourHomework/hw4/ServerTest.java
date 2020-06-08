package com.stage1.part4.hw4;

import com.stage1.part4.task4.ServerThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            ss = new ServerSocket(8888);
            System.out.println("等待客户端的连接请求");

            s = ss.accept();
            System.out.println("客户端 " + s.getInetAddress() + " 连接成功");

            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());

            while(true) {

                UserMessage userMessage = (UserMessage) ois.readObject();
                System.out.println("服务器收到客户端发来的一个object： " + userMessage);

                System.out.println("服务器正在进行判断");
                String type = ("123456".equals(userMessage.getUser().getPassword()) && "admin".equals(userMessage.getUser().getUsername()))
                        ? "success" : "fail";
                userMessage.setType(type);

                oos.writeObject(userMessage);
                System.out.println("服务器发送给客户端了一个object： " + userMessage);

                if ("success".equals(type)){
                    System.out.println("客户端输入成功，退出程序");
                    break;
                }
                System.out.println("客户端输入失败，重新等待新的输入值");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != s) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
