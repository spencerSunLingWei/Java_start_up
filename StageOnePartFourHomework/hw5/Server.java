package com.stage1.part4.Other;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static List<ThreadServer> clients=new ArrayList<ThreadServer>();

    public static class ThreadServer implements Runnable{
        private Socket s;
        private BufferedReader br;
        private PrintWriter out;
        private String name;
        private Boolean is_on = true;

        public ThreadServer(Socket s) throws IOException {
            this.s = s;
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(),true);
            name = br.readLine();

            String message = "客户端" + name + "加入了程序";
            System.out.println(name+"加入该聊天室");
            for (ThreadServer threadServer : clients) {
                System.out.println("已向以下其他客户端" + threadServer.name + "发送消息");
                threadServer.out.print(message);
                threadServer.out.flush();
            }
            clients.add(this);
            System.out.println();
        }

        private void implement() throws IOException {
            String message = null;
            while(is_on) {
                message = br.readLine();
                if("quit".equalsIgnoreCase(message)) {
                    System.out.println("客户端" + name + "已退出程序");
                    out.println("您已退出程序");

                    for (ThreadServer threadServer : clients) {
                        if(threadServer == this){
                            //continue;
                        }
                        System.out.println("已向客户端" + threadServer.name + "发送" + name + "退出消息");
                        threadServer.out.print(name + "已退出程序");
                        threadServer.out.flush();
                    }

                    out.flush();
                    clients.remove(this);
                    is_on = false;
                }
                else if("file".equalsIgnoreCase(message)){
                    System.out.println("客户端" + name + "正在申请发送文件");
                    System.out.println("file是真的写不出来了");
                    System.out.println();

                    /*
                    String str_received = br.readLine();
                    System.out.println("客户端" + name + "正在申请发送文件的类型为： " + str_received);

                    System.out.println("正在将该信息，群发给以下其他客户端");
                    for (ThreadServer threadServer : clients) {
                        if(threadServer == this){
                            continue;
                        }
                        System.out.println("已向客户端" + threadServer.name + "发送消息");
                        threadServer.out.print(name + "即将发给您一个文件其类型为: " + str_received);
                        threadServer.out.flush();
                    }
                    System.out.println();
                     */
                }
                else {
                    System.out.println("客户端"+ name + "发来一条消息： " + message);
                    System.out.println("正在将该信息，群发给以下其他客户端");
                    for (ThreadServer threadServer : clients) {
                            if(threadServer == this){
                                continue;
                            }
                            System.out.println("已向客户端" + threadServer.name + "发送消息");
                        threadServer.out.print(name + "向您发来消息: " + message);
                        threadServer.out.flush();
                    }
                    System.out.println();
                }
            }
        }

        @Override
        public void run() {
            try {
                while(is_on) {
                    implement();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                if(null!=s){
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String []args) {
        Socket s = null;
        ServerSocket ss = null;

        try {
            System.out.println("服务器已开启，等待客户端加入");
            ss = new ServerSocket(8888);

            while(true){
                s = ss.accept();
                System.out.println("客户端 " + s.getInetAddress() + " 连接成功");

                Thread t = new Thread(new ThreadServer(s));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}