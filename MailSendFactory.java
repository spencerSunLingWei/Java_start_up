package com.stage1.part5.task1;

public class MailSendFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
