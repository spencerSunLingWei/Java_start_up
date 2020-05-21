package com.stage1.part4.task1;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileTest {

    public static void show(File file){
        File[] filesArray = file.listFiles();

        for(File tf:filesArray){
            if(tf.isFile()){
                System.out.println(tf.getName());
            }
            if(tf.isDirectory()){
                System.out.println("[" + tf.getName() + "]");
                show(tf);
            }
        }

    }


    public static void main(String[] args) {

        File f1 = new File("/Users/spencersun/Desktop/a.txt");

        if(f1.exists()){
            System.out.println("file name = " + f1.getName());
            System.out.println("file size = " + f1.length());
            Date ldt = new Date(f1.lastModified());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("last modified = " + sdf.format(ldt));
            System.out.println("absolute path = " + f1.getAbsolutePath());
            System.out.println(f1.delete() ? "deleted" : "not deleted");
        }
        else{
            try {
                System.out.println(f1.createNewFile() ? "created" : " not created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------------------------");

        File f2 = new File("/Users/spencersun/Desktop/b/b/b/b");

        if(f2.exists()){    //delete只删除最内层的目录
            System.out.println("file name = " + f2.getName());
            System.out.println(f2.delete() ? "deleted" : "not deleted");
        }
        else{//mkdirs 多层目录， mkdir单层目录
            System.out.println(f2.mkdirs() ? "created" : "not created");
        }

        System.out.println("----------------------------------");

        File f3 = new File("/Users/spencersun/Desktop/c");
        File[] filesArray = f3.listFiles();

        for(File tf:filesArray){
            if(tf.isFile()){
                System.out.println(tf.getName());
            }
            if(tf.isDirectory()){
                System.out.println("[" + tf.getName() + "]");
            }
        }

        System.out.println("----------------------------------");

        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".avi") ? true  : false;
            }
        };

        File[] filesArray2 = f3.listFiles(ff);
        for(File tf:filesArray2){
            System.out.println(tf.getName());
        }

        System.out.println("----------------------------------");

        FileTest.show(f3);
    }
}
