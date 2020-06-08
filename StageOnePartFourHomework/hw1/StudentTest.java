package com.stage1.part4.hw1;

import com.stage1.part4.task2.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    public static void main(String[] args) {

        //set up the list
        String[] name = {"aa", "bb", "cc", "dd", "ee",
                "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo"};

        List<Student> lst = new ArrayList<Student>();
        for(int i=0; i<15; i++){
            Student st = new Student(name[i], i*10, i*10*7+i*5*2+i*3+14);
            lst.add(st);
        }

        //traverse and print the list
        for(Student st:lst){
            System.out.println("Student in inside the list -- " + st);
        }

        //write to file
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
            oos.writeObject(lst);
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

        //read from file
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            Object obj = ois.readObject();
            System.out.println("\n\nObject read from the file is ---------------\n" + obj);

            System.out.println("\n\nwrite the list to individual student info ---------------");

            List<Student> newlist = (List) obj;
            for(Student st:newlist){
                System.out.println("Student in inside the file -- " + st);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
