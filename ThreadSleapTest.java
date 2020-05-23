package com.stage1.part4.task3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleapTest extends Thread{

    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            Date d1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(d1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ThreadSleapTest tst = new ThreadSleapTest();
        tst.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //tst.stop();
        tst.flag = false;
    }
}
