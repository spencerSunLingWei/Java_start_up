package com.stage1.part5.task1;

public class SmsSendFactor implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
