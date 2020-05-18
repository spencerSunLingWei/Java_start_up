package com.stage1.part3.task5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        System.out.println("m1 = " + m1);

        String str1 = m1.put("1", "one");
        System.out.println("str1 = " + str1);   //map中那个key后面原来的数值
        System.out.println("m1 = " + m1);

        str1 = m1.put("2", "two");
        System.out.println("str1 = " + str1);
        System.out.println("m1 = " + m1);

        str1 = m1.put("3", "three");
        System.out.println("str1 = " + str1);
        System.out.println("m1 = " + m1);

        str1 = m1.put("3", "four");
        System.out.println("str1 = " + str1);
        System.out.println("m1 = " + m1);

        System.out.println("---------------------------");

        boolean b1 = m1.containsKey("11");
        System.out.println("b1 = " + b1);

        b1 = m1.containsKey("3");
        System.out.println("b1 = " + b1);

        str1 = m1.get("3");
        System.out.println("str1 = " + str1);

        str1 = m1.get("11");
        System.out.println("str1 = " + str1);

        System.out.println("---------------------------");

        str1 = m1.remove("1");
        System.out.println("str1 = " + str1);
        System.out.println("m1 = " + m1);

        System.out.println("---------------------------");

        Set<String> s1 = m1.keySet();
        for(String ts:s1){
            System.out.println(ts + " - " + m1.get(ts));
        }

        Collection<String> co = m1.values();
        for(String ts:co){
            System.out.println(ts);
        }

        Set<Map.Entry<String,String>> entries = m1.entrySet();
        for(Map.Entry<String,String> me:entries){
            System.out.println(me);
        }
    }
}
