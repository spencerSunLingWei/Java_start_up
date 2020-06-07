package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 编程实现客户端的初始化和关闭操作
 */
public class ClientInitClose {

    /**
     * 自定义成员变量记录socket和流对象
     */
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ObjectOutputStream getOos() {
        return oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    /**
     * 自定义成员方法实现客户端的初始化操作
     */
    public void clientInit() throws IOException {
        s = new Socket(InetAddress.getLocalHost(), 8888);
        oos = new ObjectOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(s.getInputStream());

        System.out.println("服务器连接成功");
    }

    /**
     * 自定义成员方法实现客户端的关闭操作
     */
    public void clientClose() throws IOException {
        ois.close();
        oos.close();
        s.close();
        System.out.println("客户端关闭成功");
    }
}
