package com.stage1.part2.task5;



import java.lang.annotation.*;

/*

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE) //表示下面的注解在源代码中有效

@Retention(RetentionPolicy.CLASS) //在javac之后的.class 字节码中有效

*/

@Retention(RetentionPolicy.RUNTIME) //运行时也有效的注解
//Javadoc形成API时，默认不提取注解，只提取文本注释
//如果需要提取注解，则需要用@Ducumented，必须是设置Retention为Runtime
@Documented
//表示下面的注解可以用于类型，构造方法，成员变量，成员方法,参数的修饰
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD,ElementType.PARAMETER})   //表示下面的注解可以用于类型的修饰
@Inherited //下面的注解所修饰的类中的注解，可以背子类继承

//若annotation中没有任何注解，则是标记注解，标识注解

//如果只有一个参数成员，参数名位value
//类型必须是基本数据类型，String, Class, Enum 和 Annotation
public @interface MyAnnotation {

    public String value() default "default"; //生命一个String类型的成员变量，名字位value

    public String value2();
}
