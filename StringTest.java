package com.stage1.part3.task2;

public class StringTest {

    public static void main(String[] args) {

        System.out.println("-----------------------------");

        //只有String这个特殊类出了new的方法还可以直接字符串赋值（包装类除外）
        String str1 = "abc";
        String str2 = "abc";

        //因为"abc"这个string本身没办法改变，所以写进常量池内， address都一样
        System.out.println(str1 == str2);

        System.out.println("-----------------------------");

        //使用无参方式构造对象，创建的东西有空字符串
        //"" 表示空字符串，有对象但是对象里面没有内容
        //null 表示空，连对象都没有
        String str3 = new String();
        System.out.println("str3 = " + str3);

        System.out.println("-----------------------------");

        //使用字节数组来构造字符串对象
        byte[] bArr = {97,98,99,100,101};

        //先将每个整数翻译成对应字符，再将所有的字符串串联起来
        String str4 = new String(bArr, 1, 3);
        System.out.println("str4 = " + str4);

        //使用整个字节数组来构造字符串对象
        String str5 = new String(bArr);
        System.out.println("str5 = " + str5);

        System.out.println("-----------------------------");

        //使用字符数组来构造字符串对象
        char[] cArr = {'h', 'e', 'l', 'l', 'o'};

        //使用字符数组的一部分内容来构造对象
        String str6 = new String(cArr, 2, 2);
        System.out.println("str6 = " + str6);

        //使用整个字符数组来构造对象
        String str7 = new String(cArr);
        System.out.println("str7 = " + str7);

        System.out.println("-----------------------------");

        //使用字符串来构造字符串
        String str8 = new String("world");
        System.out.println("str8 = " + str8);
    }

}
