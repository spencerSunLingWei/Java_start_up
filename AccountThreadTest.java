package com.stage1.part4.task3;

public class AccountThreadTest extends Thread {
    private int balance;
    private static Demo dm = new Demo();

    public AccountThreadTest() {
    }

    public AccountThreadTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * 方法一
     */
    /*
    @Override
    public void run() {
        System.out.println("thread" + Thread.currentThread().getName() + "starting");
        synchronized (dm) {
            int temp = getBalance();
            if (temp >= 200) {
                temp -= 200;
                try {
                    System.out.println(Thread.currentThread().getName() + "start counting");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "finished counting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("<200");
            }
            setBalance(temp);
        }
    }
    */

    /**
     * 方法二
     */
    @Override
    public void run() {
        test();
    }
    public static synchronized void test() {
        System.out.println("thread" + Thread.currentThread().getName() + "starting");
        int temp = 1000;
        if (temp >= 200) {
            temp -= 200;
            try {
                System.out.println(Thread.currentThread().getName() + "start counting");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "finished counting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("<200");
        }
        //setBalance(temp);
    }

    /**
     * 方法三
     */
    /*
    @Override
    public void run() {
        test();
    }
    public static void test() {
        synchronized (AccountThreadTest.class) {
            System.out.println("thread" + Thread.currentThread().getName() + "starting");
            int temp = 1000;
            if (temp >= 200) {
                temp -= 200;
                try {
                    System.out.println(Thread.currentThread().getName() + "start counting");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "finished counting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("<200");
            }
            //setBalance(temp);
        }
    }
     */

    public static void main(String[] args) {

        AccountThreadTest att1 = new AccountThreadTest(1000);
        att1.start();

        AccountThreadTest att2 = new AccountThreadTest(1000);
        att2.start();

        System.out.println("start main");

        try {
            att1.join();
            att2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finished " + att1.getBalance());


    }

}
