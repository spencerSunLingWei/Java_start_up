package com.stage1.part3.task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * list - ArrayList / LinkedList / Stack / Vector
 */

public class ListTest {

    public static void main(String[] args) {

        //List<Integer> lt1; 只能放的数据类型
        List lt1 = new ArrayList();
        lt1.add("one");
        System.out.println("lt1 = " + lt1);

        System.out.println("---------------------------------------------");

        List lt2 = new LinkedList();
        lt2.add("one");
        System.out.println("lt2 = " + lt2);

        System.out.println("---------------------------------------------");

        lt1.add(0,123);
        lt1.add(2,123);
        System.out.println("lt1 = " + lt1);

        System.out.println("---------------------------------------------");

        String pos = (String) lt1.get(1);
        System.out.println(pos);

        int pos1 = (int) lt1.get(0);
        System.out.println(pos1);

        System.out.println("---------------------------------------------");

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for (int i=0; i<lt1.size(); i++){
            Object obj = lt1.get(i);
            if(lt1.size()-1 == i){
                sb1.append(obj).append("]");
            }
            else{
                sb1.append(obj).append(", ");
            }
        }
        System.out.println(sb1);

        System.out.println("---------------------------------------------");

        System.out.println("123 index = " + lt1.indexOf(123));
        System.out.println("123 index = " + lt1.lastIndexOf(123));

        System.out.println("---------------------------------------------");

        int one = (int) lt1.set(0, "set");
        System.out.println("the original value = " + one);
        System.out.println("lt1 is changed to = " + lt1);

        System.out.println("---------------------------------------------");

        /*不对*/
        for(int i=0; i<lt1.size(); i++){
            System.out.println("removed element: " + lt1.remove(i));
        }
        System.out.println("lt1 is changed to = " + lt1);

        /*okay*/
        for(int i=0; i<lt1.size();){
            System.out.println("removed element: " + lt1.remove(i));
        }
        System.out.println("lt1 is changed to = " + lt1);

        /*okay*/
        while(lt1.size()!=0){
            System.out.println("removed element: " + lt1.remove(0));
        }
        System.out.println("lt1 is changed to = " + lt1);

        System.out.println("---------------------------------------------");

        lt1.add(1);
        lt1.add(2);
        lt1.add(3);
        lt1.add(4);
        lt1.add(5);
        List sub = lt1.subList(1,3);
        System.out.println("lt1 = " + lt1);
        System.out.println("sublist = " + sub);

        //sublist & list sharing the same memory
        int re = (int) sub.remove(0);
        System.out.println("removed one: " + re);
        System.out.println("lt1 = " + lt1);
        System.out.println("sublist = " + sub);

        System.out.println("---------------------------------------------");

        Stack s1 = new Stack();
        System.out.println("s1 = " + s1);

        for(int i = 1; i<=5; i++){
            Object obj = s1.push(i*11);
            System.out.println("pushed on = " + obj);
        }

        Object obj2 = s1.peek();
        System.out.println("the one on the top = " + obj2);

        while(s1.size()!=0){
            Object obj = s1.pop();
            System.out.println("the one popped = " + obj);
        }

    }
}
