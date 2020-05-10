package com.stage1.part2.task5;

//表示将标签MyAnnotation贴在PersonAn类上

//一下两者都可以用，第二种因为有default可以省略initilization

//@MyAnnotation(value = "hello", value2 = "world")

//形成API时，默认不提取注解，只提取文本注释
//如果需要提取注解，则需要用@Ducumented，必须是设置@Retention为Runtime

@MyAnnotation(value2 = "world")

public class PersonAn {

    /**
     * name 用于姓名
     */
    @MyAnnotation(value2 = "1")
    private String name;

    /**
     * age 用于年龄
     */
    @MyAnnotation(value2 = "2")
    private int age;

    /**
     * 编程实现无参constructor
     */
    @MyAnnotation(value2 = "3")
    public PersonAn() {
    }

    /**
     * 编程实现有参constructor
     */
    @MyAnnotation(value2 = "4")
    public PersonAn(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
