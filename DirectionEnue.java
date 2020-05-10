package com.stage1.part2.task5;

/**
 * 实现所有方向的枚举，上下左右
 */

public class DirectionEnue {

    private final String desc;

    public static final DirectionEnue UP = new DirectionEnue("up");
    public static final DirectionEnue DOWN = new DirectionEnue("down");
    public static final DirectionEnue LEFT = new DirectionEnue("left");
    public static final DirectionEnue RIGHT = new DirectionEnue("right");


    //通过构造方法实现成员变量的初始化
    //私有构造方法，只能在本类内部使用
    private DirectionEnue(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
