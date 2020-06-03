package com.stage1.part5.task2;

import javax.print.DocFlavor;
import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public static void main(String[] args) {

        Person person = new Person("pckk", 20);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                person.show();
            }
        };
        runnable.run();

        Runnable runnable1 = () -> person.show();
        runnable1.run();

        Runnable runnable2 = person::show;
        runnable2.run();

        System.out.println("--------------------------------------------");

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                person.setName(s);
            }
        };

        consumer.accept("pcdsjlfdj");
        System.out.println(person);

        Consumer<String>  consumer1 = s -> person.setName(s);
        consumer1.accept("fdjskajfwjjjj");
        System.out.println(person);

        Consumer<String> consumer2 = person::setName;
        consumer.accept("pckk");
        System.out.println(person);

        System.out.println("--------------------------------------------");

        Supplier<String> supplier = new Supplier<String>(){
            @Override
            public String get() {
                return person.getName();
            }
        };
        System.out.println(supplier.get());

        Supplier<String> supplier1 = () -> person.getName();
        System.out.println(supplier.get());

        Supplier<String> supplier2 = person::getName;
        System.out.println(supplier.get());

        System.out.println("--------------------------------------------");

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(function.apply("12345"));

        Function<String, Integer> function1 = s -> Integer.parseInt(s);
        System.out.println(function.apply("12345"));

        Function<String, Integer> function2 = Integer::parseInt;
        System.out.println(function.apply("12345"));

        System.out.println("--------------------------------------------");

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(10, 20));

        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(10, 20));

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(10, 20));

        System.out.println("--------------------------------------------");

        Comparator<Integer> comparator3 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator3.compare(10,20));

        Comparator<Integer> comparator4 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator4.compare(10, 20));

        Comparator<Integer> comparator5 = Integer::compareTo;
        System.out.println(comparator5.compare(10, 20));

        System.out.println("--------------------------------------------");

        Supplier<Person> supplier3 = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(supplier3.get());

        Supplier<Person> supplier4 = () -> new Person();
        System.out.println(supplier4.get());

        Supplier<Person> supplier5 = Person::new;
        System.out.println(supplier5.get());

        System.out.println("--------------------------------------------");

        BiFunction<String, Integer, Person> biFunction = new BiFunction<String, Integer, Person>() {
            @Override
            public Person apply(String s, Integer integer) {
                return new Person(s,integer);
            }
        };
        System.out.println(biFunction.apply("pckk", 50));

        BiFunction<String, Integer, Person> biFunction1 = (s, integer) -> new Person(s, integer);
        System.out.println(biFunction1.apply("pckk", 50));

        BiFunction<String, Integer, Person> biFunction2 = Person::new;
        System.out.println(biFunction2.apply("pckk", 50));

        System.out.println("--------------------------------------------");

        Function<Integer, Person[]> function3 = new Function<Integer, Person[]>() {
            @Override
            public Person[] apply(Integer integer) {
                return new Person[integer];
            }
        };
        Person[] pArr = function3.apply(3);
        System.out.println(Arrays.toString(pArr));

        Function<Integer, Person[]> function4 = integer -> new Person[integer];
        System.out.println(Arrays.toString(function4.apply(4)));

        Function<Integer, Person[]> function5 = Person[]::new;
        System.out.println(Arrays.toString(function5.apply(5)));

    }
}
