package com.stage1.part5.task1;

public class Singleton {

    /**
     * 懒汉式的线程同步化
     */
    private static Singleton sin = null;

    private Singleton(){}

    public static /*synchronized*/ Singleton getInstance(){
        /*synchronized (Singleton.class) {
            if (null == sin) {
                sin = new Singleton();
            }
            return sin;
        }*/
        if(null == sin) {
            synchronized (Singleton.class) {
                if (null == sin) {
                    sin = new Singleton();
                }
            }
        }
        return sin;

    }
}
