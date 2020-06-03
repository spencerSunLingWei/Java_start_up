package com.stage1.part5.task2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListPersonTest  {

    public static void main(String[] args)  {

        List<Person> list = new LinkedList<>();
        list.add(new Person("spencer", 19));
        list.add(new Person("jesse", 20));
        list.add(new Person("james", 20));
        list.add(new Person("sophie", 20));
        list.add(new Person("lilian", 19));
        list.add(new Person("else", 3));

        for(Person tp:list){
            System.out.println(tp);
        }

        System.out.println("--------------------------------");
        
        List<Person> list1 = new LinkedList<>();
        for(Person tp:list){
            if(tp.getAge() >= 18){
                list1.add(tp);
            }
        }

        for(Person tp:list1){
            System.out.println(tp);
        }

        System.out.println("--------------------------------");

        list.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 18;
            }
        }).forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });

        System.out.println("--------------------------------");

        list.stream().filter(person -> person.getAge() >= 18).forEach(System.out::println);

        System.out.println("--------------------------------");

        list.stream().skip(2).limit(3).forEach(System.out::println);

        System.out.println("--------------------------------");

        list.stream().map(new Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        }).forEach(System.out::println);

        list.stream().map(person -> person.getAge()).forEach(System.out::println);

        list.stream().map(Person::getAge).forEach(System.out::println);

        System.out.println("--------------------------------");

        list.stream().sorted().forEach(System.out::println);

        System.out.println("--------------------------------");

        boolean b1 = list.stream().noneMatch(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge()>=20; //没有元素>=20 ? false就是有>=20的
            }
        });
        System.out.println("b1 = " + b1);

        b1 = list.stream().noneMatch(person -> person.getAge() > 15);

        System.out.println("--------------------------------");

        Optional<Person> max = list.stream().max(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("age max = " + max);

        max = list.stream().max((o1, o2) -> o1.getAge() - o2.getAge());

        System.out.println("--------------------------------");

        Optional<Integer> reduce = list.stream().map(Person::getAge).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
        System.out.println("sum ：" + reduce);

        reduce = list.stream().map(Person::getAge).reduce((Integer::sum));


    }


}
