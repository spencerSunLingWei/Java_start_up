package com.stage1.part4.Other;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Boolean is_on = true;
    private static Socket s = null;
    private static Scanner sc;
    private static InputStream in;
    private static PrintWriter out;

    public Client() throws IOException {
        s = new Socket("192.168.2.49", 8888);
        in = s.getInputStream();
    }

    public static void implement() throws IOException {
        out = new PrintWriter(s.getOutputStream(), true);

        Thread ct = new Thread (new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(!is_on) {
                        break;
                    }
                    else {
                        try {
                            byte[] buffer = new byte[1024];
                            if(! s.isClosed()) {
                                int len = s.getInputStream().read(buffer);
                                String received = new String(buffer, 0, len);
                                System.out.println(received);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        ct.start();

        System.out.println("请输入你的用户名：");
        sc = new Scanner(System.in);
        String input_name = sc.nextLine();
        out.println(input_name);
        System.out.println(input_name + ", 进入聊天室，输入file发送文件，输入quit退出");

        while(is_on) {
            String str_received = sc.nextLine();
            if("quit".equalsIgnoreCase(str_received)) {
                is_on = false;
            }
            else if("file".equalsIgnoreCase(str_received)){
                System.out.println("file是真的写不出来了");

                    /*
                    System.out.println("请输入发送文件类型后缀，如txt, png, mp3, mov, jpeg, jpg, gif: ");
                    String type_input = sc.next();
                    out.println(type_input);

                    System.out.println("请输入来自桌面文件的文件名称： ");
                    String path = sc.next();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/spencersun/Desktop/" + path)));
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        out.println(line);
                        out.flush();
                    }
                    out.println("16046379811004723276");
                    System.out.println("客户端已将文件发送给服务器");
                     */
            }
            out.println(str_received);
        }
        s.close();
    }

    public static void main(String []args){
        Client client = null;
        try {
            client = new Client();
            client.implement();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}