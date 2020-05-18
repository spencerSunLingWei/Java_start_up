package com.stage1.part3.task5;

public class Student implements Comparable<Student>{

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        int i = this.getName().compareTo(o.getName());
        if(i == 0){
            return this.getAge() - o.getAge();
        }
        else{
            return i;
        }
        //return 0;   调用对象和参数对象相等
        //return -1;  调用对象就是新增加的对象，小于参数对象
        //return 1； 调用对象就是新增加的对象，大于参数对象

        //return this.getName().compareTo(o.getName());
        //return this.getAge() - o.getAge();
    }

}
