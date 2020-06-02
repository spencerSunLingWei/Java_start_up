package com.stage1.part5.task1;

public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("sending messages");
    }
}
