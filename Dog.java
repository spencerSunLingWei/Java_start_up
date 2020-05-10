package com.stage1.part2.task3;

import com.stage1.part2.task3.Animal;

public class Dog extends Animal {
    //variable declaration
    private int tooth;

    //constructor
    public Dog(){
        super();    //dont need to write
    }

    public Dog(String name, String color, int tooth){
        super(name, color);
        setTooth(tooth);
    }

    //accessible functions
    public int getTooth() {
        return tooth;
    }

    public void setTooth(int tooth) {
        if(tooth > 0)   this.tooth = tooth;
        else            System.out.println("invalid input for tooth");
    }

    @Override
    public void print() {
        super.print();
        System.out.println("number of tooth: " + getTooth());
    }
}
