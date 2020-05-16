package com.stage1.part3.task1;

import java.util.Objects;

public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     *自己写的
     */
//    /**
//     * 为了比较两个对象的内容，需要重写该方法
//     */
//    @Override
//    public boolean equals(Object obj){
//        if(obj == null){    //非空性
//            return false;
//        }
//        if(this == obj){
//            return true;
//        }
//
//        if(obj instanceof Student) {
//            Student ts = (Student) obj;
//
//            /*int是基本数据类型，内存空间直接为值本身可以直接比较
//            return (this.getId() == ts.getId());*/
//
//            /*String是引用数据类型，内从空间中存放的是地址，如果==比较的是地址*/
//            //比较姓名字符串的内容是否相同，string class里自带的equals
//            return (this.getName().equals(ts.getName()));
//        }
//        else{
//            return false;
//        }
//    }
//
//    /**
//     * 为了使得hashcode方法的结果，和equals的方法结果保持一致
//     * 满足Java 官方的协定，所以方法需要重写
//     */
//    @Override
//    public int hashCode(){
//        int type = 12;
//        //return type*12 + getId();
//        return type*31 + getName().hashCode();
//    }
//
//    /**
//     * 为了返回更有意义的字符串数据，则需要重写该方法
//     */
//    @Override
//    public String toString(){
//        return "Student [ id = " + getId() + ", name = " + getName() + "]";
//    }


    /**
     *default generated
     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;     //如果address一样
//        if (o == null || getClass() != o.getClass()) return false;      //如果o为空，或者this和o的class type不一样
//
//        Student student = (Student) o;
//
//        if (id != student.id) return false;     //check if same id
//        return name != null ? name.equals(student.name) : student.name == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }


    /**
     *用object类
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
