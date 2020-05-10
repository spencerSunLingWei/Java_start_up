package com.stage1.part2.task5;

/**
 * 实现所有方向的枚举，上下左右
 * 枚举类型要求所有枚举值必须放在枚举类型的最前面
 * 默认使用public static final关键字进行修饰，采用枚举类型名称.的方式调用
 * 枚举方法的constructor必须是private的
 */

public enum DirectionEnum implements DirectionInterface{

    //完整写法 public static final Direction UP = new Direction("up") {};
    //可以省略
    UP("up"){
        @Override
        public void show() {
            System.out.println("interface overrided - up");
        }
    },
    DOWN("down") {
        @Override
        public void show() {
            System.out.println("interface overrided - down");
        }
    },
    LEFT("left"){
        @Override
        public void show() {
            System.out.println("interface overrided - left");
        }
    },
    RIGHT("right"){
        @Override
        public void show() {
            System.out.println("interface overrided - right");
        }
    };

    private final String desc;

    //通过构造方法实现成员变量的初始化
    //私有构造方法，只能在本类内部使用
    private DirectionEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /*
    //only override once
    @Override
    public void show() {
        System.out.println("interface overrided");
    }
    */
}
