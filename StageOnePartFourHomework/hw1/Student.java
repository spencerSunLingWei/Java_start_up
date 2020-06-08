package com.stage1.part4.hw1;

import com.stage1.part4.task1.AgeException;

public class Student implements java.io.Serializable{

    private static final long serialVersionUID = 4967055471934342797L;
    private String name;
    private int age;
    private int id;

    public Student(String s) {
    }

    public Student(String name, int age, int id) {
        setAge(age);
        setId(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if(age>=0 && age<=120) {
            this.age = age;
        }
        else{
            try {
                throw new AgeException("Invalid Age input");
            } catch (AgeException e) {
                e.printStackTrace();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        if(id>0) {
            this.id = id;
        }
        else{
            try {
                throw new AgeException("Invalid Id input");
            } catch (AgeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
