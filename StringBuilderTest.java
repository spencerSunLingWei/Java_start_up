package com.stage1.part3.task3;

public class StringBuilderTest {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder();
        System.out.println("sb1 = " + sb1);
        System.out.println("sb1 capacity = " + sb1.capacity());
        System.out.println("sb1 length = " + sb1.length());

        StringBuilder sb2 = new StringBuilder(20);
        System.out.println("sb2 = " + sb2);
        System.out.println("sb2 capacity = " + sb2.capacity());
        System.out.println("sb2 length = " + sb2.length());

        StringBuilder sb3 = new StringBuilder("HELLO");
        System.out.println("sb3 = " + sb3);
        System.out.println("sb3 capacity = " + sb3.capacity());
        System.out.println("sb3 length = " + sb3.length());

        System.out.println("-------------------------------------------------");

        sb3.insert(0, "aaaaa");
        System.out.println(sb3);
        System.out.println(sb3.capacity());
        System.out.println(sb3.length());

        sb3.append("hhhhhhhhhhhhhhhhhhhh");
        System.out.println(sb3);

        System.out.println(sb3.capacity()); //自动扩容
        System.out.println(sb3.length());

        System.out.println("-------------------------------------------------");

        sb3.delete(1, 5);
        System.out.println(sb3);

        sb3.deleteCharAt(0);
        System.out.println(sb3);

        System.out.println("-------------------------------------------------");

        sb3.replace(sb3.indexOf("h"),sb3.indexOf("h")+10,"replaced");
        System.out.println(sb3);

        sb3.setCharAt(0,'a');
        System.out.println(sb3);

        sb3.replace(1,5,"bcde");
        System.out.println(sb3);

        sb3.reverse();
        System.out.println(sb3);

        System.out.println("-------------------------------------------------");

        /**
         * 笔试考点一：
         * Q：method本身会改，为什么还需要有return的值，返回他自己
         * A：为了连续调用
         */
        sb3.reverse().append("1").insert(0,"2345").delete(10,11).reverse();
        System.out.println(sb3);

        /**
         * 笔试考点二：
         * Q：如何实现string builder类型和string类型之间的转换
         */
        String str_new = sb3.toString();
        StringBuilder sb5 = new StringBuilder(str_new);

        /**
         * 笔试考点三：
         * Q：从效率来说那个更好？ 不好 < 好
         * A：String < StringBuffer < StringBuilder
         */

    }
}
