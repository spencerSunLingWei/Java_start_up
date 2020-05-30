package com.stage1.part4.task5;

import java.io.Serializable;

@MyAnnotation
public class Student<T, E> extends Person implements Comparable, Serializable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
