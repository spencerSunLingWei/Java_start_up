package com.stage1.part5.task1;

public class PacketSendFactory implements Provider{
    @Override
    public Sender produce() {
        return new PacketSender();
    }
}
