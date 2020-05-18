package com.stage1.part3.task5;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        TreeSet<String> s1 = new TreeSet<>();
        System.out.println("s1 = " + s1);

        boolean b1 = s1.add("aa");
        System.out.println("b1 = " + b1);
        System.out.println("s1 = " + s1);

        b1 = s1.add("cc");
        System.out.println("b1 = " + b1);
        System.out.println("s1 = " + s1);

        b1 = s1.add("bb");
        System.out.println("b1 = " + b1);
        System.out.println("s1 = " + s1);

        System.out.println("----------------------------");

        /**
         * 准备一个比较器
         * 匿名内部类
         */

        /*
        Comparator<Student> comparator = new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                return o1.getAge() - o2.getAge();
            }
        };
        */

        /*
        Comparator<Student> comparator = (Student o1, Student o2) -> {
            return //o1.getAge() - o2.getAge();
        };
        */

        Set<Student> s2 = new TreeSet<>();
        //Set<Student> s2 = new TreeSet<>(comparator);
        s2.add(new Student("pckk", 20));
        s2.add(new Student("pcaa", 10));
        s2.add(new Student("pcoo", 30));
        s2.add(new Student("pcoo", 10 ));
        s2.add(new Student("pcbb", 40 ));
        s2.add(new Student("pcbb", 40 ));
        System.out.println("s2 = " + s2);


    }
}
