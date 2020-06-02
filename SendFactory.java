package com.stage1.part5.task1;

public class SendFactory {

    public Sender product(String type){
        if("mail".equalsIgnoreCase(type)){
            return new MailSender();
        }
        else if("sms".equalsIgnoreCase(type)){
            return new SmsSender();
        }
        else{
            return null;
        }
    }

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

    public static void main(String[] args) {

        SendFactory sf = new SendFactory();

        Sender sender = sf.product("mail");
        if(null != sender) {
            sender.send();
        }

        /*
        Sender sender1 = sf.produceMail();
        sender1.send();
        */

        Sender sender1 = SendFactory.produceMail();
        sender1.send();

        Provider provider = new MailSendFactory();
        Sender sender2 = provider.produce();
        sender2.send();

        Provider provider1 = new PacketSendFactory();
        Sender sender3 = provider1.produce();
        sender3.send();

    }
}
