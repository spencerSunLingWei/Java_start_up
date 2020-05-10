package com.stage1.part2.task3;

public class Animal {
    //variable declaration
    private String name;
    private String color;

    //constructors
    public Animal() {
    }

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    //accessible functions
    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    //other helper functions
    public void print(){
        System.out.println("name: " + getName() + " + color:" + getColor());
    }
}
