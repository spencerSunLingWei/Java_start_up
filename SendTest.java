package com.stage1.part4.task4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendTest {

    public static void main(String[] args) {

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();

            byte[] bArr = "hello".getBytes();
            DatagramPacket dp = new DatagramPacket(bArr, bArr.length, InetAddress.getLocalHost(), 8888);

            ds.send(dp);
            System.out.println("数据发送成功");

            byte[] bArr2 = new byte[20];
            DatagramPacket dp2 = new DatagramPacket(bArr2, bArr2.length);
            ds.receive(dp2);
            System.out.println("收到的消息时：" + new String(bArr2, 0, dp2.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != ds) {
                ds.close();
            }
        }
    }
}
