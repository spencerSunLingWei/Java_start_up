package com.stage1.part4.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOuputStreamTest {

    public static void main(String[] args) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
            User user = new User("pckk", "12345","4167325982");

            oos.writeObject(user);
            System.out.println("write in an object");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
