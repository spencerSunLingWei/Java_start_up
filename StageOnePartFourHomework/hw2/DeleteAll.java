package com.stage1.part4.hw2;

import java.io.File;

public class DeleteAll {

    public static void showAll(File file){
        File[] filesArray = file.listFiles();

        for(File tf:filesArray){
            if(tf.isFile()){
                System.out.println(tf.getName());
            }
            if(tf.isDirectory()){
                System.out.println("[" + tf.getName() + "]");
                System.out.println("----[" + tf.getName() + "] starts----");
                showAll(tf);
                System.out.println("----[" + tf.getName() + "] finishes----");
            }
        }
    }

    public static void deleteAll(File file){
        File[] filesArray = file.listFiles();

        for(File tf:filesArray){
            if(tf.isFile()){
                System.out.println("deleting " + tf.getName());
                tf.delete();
            }
            if(tf.isDirectory()){
                System.out.println("----[" + tf.getName() + "] starts----");
                deleteAll(tf);
                System.out.println("----[" + tf.getName() + "] finishes----");
                System.out.println("deleting [" + tf.getName() + "]");
                tf.delete();
            }
        }
    }

    public static void main(String[] args) {

        File f = new File("/Users/spencersun/Desktop/c");

        System.out.println("All components inside the directory------------------------");
        DeleteAll.showAll(f);

        System.out.println("\n\nStart deleting-----------------------------");
        DeleteAll.deleteAll(f);

        System.out.println("\n\nprint again-----------------------");
        DeleteAll.showAll(f);
    }
}
