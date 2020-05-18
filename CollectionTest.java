package com.stage1.part3.task4;


/**
 * collection && arraylist
 */

import com.stage1.part2.task5.StaticOuter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {

    public static void main(String[] args) {

        //接口不可实例化对象
        //Collection c1 = new Collection();

        //接口类型的引用指向实现类的对象
        Collection c1 = new ArrayList();

        //自动调用toString方法，调用ArrayList类中的toString方法
        System.out.println("element inside the arraylist: " + c1);

        System.out.println("-----------------------------------");

        boolean b1 = c1.add(new String("one"));
        System.out.println("b1 = " + b1);
        System.out.println("element inside the arraylist: " + c1);

        b1 = c1.add(Integer.valueOf(2));    //添加元素是否成功
        System.out.println("b1 = " + b1);
        System.out.println("element inside the arraylist: " + c1);

        b1 = c1.add(new Person("pckk",18));
        System.out.println("b1 = " + b1);
        System.out.println("element inside the arraylist: " + c1);  //让每个对象调用对应类的toString方法

        System.out.println("-----------------------------------");

        Collection c2 = new ArrayList();
        c2.add("three");
        c2.add(4);
        System.out.println("c2 = " + c2);

        b1 = c1.addAll(c2);     //将c2当中的内容添加进去
        System.out.println("b1 = " + b1);
        System.out.println("element inside the arraylist: " + c1);

        b1 = c1.add(c2);    //将c2当作一个整体放进去
        System.out.println("b1 = " + b1);
        System.out.println("element inside the arraylist: " + c1);

        System.out.println("-----------------------------------");

        b1 = c1.contains("three");
        System.out.println("b1 = " + b1);

        b1 = c1.contains(Integer.valueOf(3));
        System.out.println("b1 = " + b1);

        b1 = c1.contains(Integer.valueOf(2));
        System.out.println("b1 = " + b1);

        /*
        contains的工作原理如下
        调用 Objects.equals(o,e)； 拿形式参数o和集合e中所有元素进行比较
        equals的工作原理如下：
        public static boolean equals(Object a, Object b){
            return (a==b) || (a != null && a.equals(b));
            1. Person对象与集合中已有对象的地址相同
            2. Person对象不为空，则Person对象调用Person类中equals方法与集合中已有元素相等
                Person类中没有重写equals方法时，则调用从Object类中继承下来的直接对比地址的对比方法
                重写之后对比的是内容本身
        }
        */
        b1 = c1.contains(new Person("pckk",18));
        System.out.println("b1 = " + b1);

        System.out.println("-----------------------------------");

        System.out.println("c1 = " + c1);

        Collection c3 = new ArrayList();
        c3.add(4);
        System.out.println("c3 = " + c3);
        b1 = c1.containsAll(c3);
        System.out.println("b1 = " + b1);

        c3.add("five");
        System.out.println("c3 = " + c3);
        b1 = c1.containsAll(c3);
        System.out.println("b1 = " + b1);

        System.out.println("-----------------------------------");

        System.out.println("c2 = " + c2);
        b1 = c1.containsAll(c2);    //内容
        System.out.println("b1 = " + b1);
        b1 = c1.contains(c2);       //整体
        System.out.println("b1 = " + b1);

        System.out.println("-----------------------------------");

        //交集
        System.out.println("c1 = " + c1);
        System.out.println("c3 = " + c3);
        b1 = c3.retainAll(c1);  //true 元素当有改变，false 当元素没有改变
        System.out.println("b1 = " + b1);
        System.out.println("c1 = " + c1);
        System.out.println("c3 = " + c3);

        System.out.println("c3 = " + c3);
        b1 = c3.retainAll(c3 );  //true 元素当有改变，false 当元素没有改变
        System.out.println("b1 = " + b1);
        System.out.println("c3 = " + c3);

        System.out.println("-----------------------------------");

        System.out.println("c1 = " + c1);

        b1 = c1.remove(1);
        System.out.println("b1 = " + b1);

        b1 = c1.remove(c2);     //整体
        System.out.println("b1 = " + b1);
        System.out.println("c1 = " + c1);

        b1 = c1.removeAll(c2);      //内容
        System.out.println("b1 = " + b1);
        System.out.println("c1 = " + c1);

        c2.add(2);
        System.out.println("c2 = " + c2);
        b1 = c1.removeAll(c2);      //内容, 有的 相同的部分删除
        System.out.println("b1 = " + b1);
        System.out.println("c1 = " + c1);

        System.out.println("-----------------------------------");

        System.out.println("c3 = " + c3);
        System.out.println(c3.isEmpty() ? "c3 empty" : "c3 not empty");
        c3.clear();
        System.out.println("c3 = " + c3);
        System.out.println(c3.isEmpty() ? "c3 empty" : "c3 not empty");

        System.out.println("c2 = " + c2);
        System.out.println("c2 # = " + c2.size());
        System.out.println(c2.isEmpty() ? "c2 empty" : "c2 not empty");

        Collection c4 = new ArrayList();
        c4.add(1);
        c4.add(1);
        c4.add(1);
        c4.add(1);
        c4.add(2);
        System.out.println("c4 = " + c4);
        Collection c5 = new ArrayList();
        c5.add(1);
        c5.add(1);
        c5.add(1);
        c5.add(1);
        c5.add(2);
        c5.add(3);
        System.out.println("c5 = " + c5);
        System.out.println(c4.equals(c5) ? "c4==c5" : "c4!=c5");

        System.out.println("-----------------------------------");

        //集合到数组的转换
        System.out.println("c5 = " + c5);
        Object[] objects = c5.toArray();
        System.out.println("array elements: " + Arrays.toString(objects));

        System.out.println("c1 = " + c1);
        objects = c1.toArray();
        System.out.println("array elements: " + Arrays.toString(objects));

        //数组到集合
        Collection ob1 = Arrays.asList(objects);
        System.out.println("collection elements: " + ob1);

        System.out.println("-----------------------------------");

        c1.add("three");
        c1.add(new Person("pckk" , 20));
        c1.add(3456);
        System.out.println("c1 = " + c1);

        Iterator it = c1.iterator();
        while(it.hasNext() == true){
            System.out.println(it.next());
        }

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        it = c1.iterator();
        while(it.hasNext() == true){
            sb1.append(it.next());
            if(it.hasNext() == false)   sb1.append("]");
            else                        sb1.append(",").append(" ");
        }
        System.out.println("print c1 by iterator: " + sb1);

        System.out.println("-----------------------------------");

        it = c1.iterator();
        while(it.hasNext() == true){
            Object obj = it.next( );
            if("one".equals(obj))   it.remove();    //迭代时，不能用其他类方法添加或删除
        }
        System.out.println("remove c1 by iterator = " + c1);

        System.out.println("-----------------------------------");

        //traversal
        for(Object obj:c1){
            System.out.println("picked element in c1: " + obj);
        }

        int[] arr = new int[] {11,22,33,44,55};
        for(int i:arr){
            System.out.println("picked element in arr: " + i);
        }
    }
}
