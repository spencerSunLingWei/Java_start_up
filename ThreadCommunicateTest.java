package com.stage1.part4.task3;

public class ThreadCommunicateTest implements Runnable{

    private int cnt = 1;

    @Override
    public void run() {
        while(true){

            synchronized (this) {
                notify();
                if(cnt<=100){
                    System.out.println(Thread.currentThread().getName() + " / cnt = " + cnt);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    cnt++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        ThreadCommunicateTest tct = new ThreadCommunicateTest();
        Thread t1 = new Thread(tct);
        t1.start();

        Thread t2 = new Thread(tct);
        t2.start();
    }
}
