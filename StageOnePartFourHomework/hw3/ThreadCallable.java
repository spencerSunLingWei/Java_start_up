package com.stage1.part4.hw3;

import java.io.*;
import java.util.concurrent.Callable;

public class ThreadCallable implements Callable {

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
                tf.delete();
            }
            if(tf.isDirectory()){
                deleteAll(tf);
                tf.delete();
            }
        }
    }

    public static void copyAll (File file1, File file2) throws IOException {
        //if it is a directory
        if (file1.isDirectory()) {
            //create directory to the destination file if there is not any
            if (!file2.exists()) {
                file2.mkdir();
            }

            //create all the particular files names and then do recursion
            String files[] = file1.list();
            for (String file : files) {
                File newFile1 = new File(file1, file);
                File newFile2 = new File(file2, file);

                copyAll(newFile1, newFile2);
            }
        }
        //if it is a file
        else {
            //copy everything to the file
            InputStream in = new FileInputStream(file1);
            OutputStream out = new FileOutputStream(file2);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }


    @Override
    public Object call() throws Exception {
        File f1 = new File("/Users/spencersun/Desktop/c");
        File f2 = new File("/Users/spencersun/Desktop/b");

        ThreadCallable.deleteAll(f2);

        System.out.println("\ninside file one----------------");
        ThreadCallable.showAll(f1);

        System.out.println("\n\ninside file two----------------");
        ThreadCallable.showAll(f2);

        ThreadCallable.copyAll(f1, f2);

        System.out.println("\n\nfinished copying inside file two----------------");
        ThreadCallable.showAll(f2);
        return true;
    }
}
