package com.stage1.part4.task3;

import java.util.concurrent.locks.ReentrantLock;

public class AccountRunnableTest implements Runnable{

    private int balance;
    private Demo dm = new Demo();
    private ReentrantLock lock = new ReentrantLock();


    public AccountRunnableTest() {
    }

    public AccountRunnableTest(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     *方法一
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
    /*
    @Override
    public void run() {
        //最终是account对象来调用run方法，因此当前正在调用的对象就是account。也就是this就是account
        //但如果是不同的account那这个就锁不住，因为this不一样
        synchronized (this){
            System.out.println("thread" + Thread.currentThread().getName() + "starting");
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
     * 方法三
     */
    /*
    @Override
    public synchronized void run() {
        //但如果是不同的account那这个就锁不住，因为this不一样，call这个方法的主体就不一样
        System.out.println("thread" + Thread.currentThread().getName() + "starting");
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
     */

    /**
     *方法四
     */
    @Override
    public void run() {
        lock.lock();
        System.out.println("thread" + Thread.currentThread().getName() + "starting");
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
        lock.unlock();
    }

    public static void main(String[] args) {

        AccountRunnableTest account = new AccountRunnableTest(1000);
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);
        t1.start();
        t2.start();

        System.out.println("waiting");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished: " + account.getBalance());
    }
}

class Demo {

}