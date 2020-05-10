package com.stage1.part2.task5;

@ManType(value = "human")
@ManType(value = "superhuman")

public class Man {

    @Deprecated //表示这个方法已经过时了，不建议使用，来过渡老项目的
    public void show(){
        System.out.println("这个方法马上要过时了");
    }

    public static void main(String[] args) {
        int ia = 97;
        char c1 = (@ManType char) ia;
    }
}
