package com.stage1.part4.hw4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {

        Socket s = null;
        Scanner sc = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            s = new Socket("192.168.2.49",8888);
            System.out.println("连接服务器成功");
            sc = new Scanner(System.in);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());

            while(true) {
                System.out.println("请输入用户名和密码：");
                String username = sc.next();
                String password = sc.next();

                User user = new User(username, password);
                UserMessage userMessage = new UserMessage("unknown", user);
                oos.writeObject(userMessage);
                System.out.println("客户端发送给服务器了一个object： " + userMessage);

                userMessage = (UserMessage) ois.readObject();
                System.out.println("客户端收到服务器发来的一个object： " + userMessage);

                System.out.println("客户端正在进行判断");
                if ("success".equals(userMessage.getType())) {
                    System.out.println("输入成功，退出程序");
                    break;
                }
                System.out.println("输入有误，请重新尝试");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != sc){
                sc.close();
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
