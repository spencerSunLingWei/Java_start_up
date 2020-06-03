package com.stage1.part5.task2;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("function with no input no return value.");
            }
        };

        runnable.run();

        Runnable runnable1 = () -> System.out.println("function with no input no return value.");

        runnable1.run();

        System.out.println("------------------------");

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("function with input but no return value.");
            }
        };

        consumer.accept("Notes: ");

        Consumer consumer1 = (o) -> System.out.println("function with input but no return value.");

        consumer1.accept("yeah");

        System.out.println("------------------------");

        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return "function with no input but have return value.";
            }
        };

        System.out.println(supplier.get());

        Supplier supplier1 = () -> "function with no input but have return value.";

        System.out.println(supplier1.get());

        System.out.println("------------------------");

        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                return o;
            }
        };

        System.out.println(function.apply("function with input and return value"));

        Function function1 = o -> o;

        System.out.println(function1.apply("AAAAA -> function with input and return value"));

        System.out.println("------------------------");

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        System.out.println(comparator.compare(10,20));

        Comparator comparator1 = (o1, o2) -> 1;

        System.out.println(comparator1.compare(100,20));

        System.out.println("------------------------");

        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };

        System.out.println(predicate.test("hello"));

        Predicate predicate1 = (o) -> true;

        System.out.println(predicate1.test("hello"));


    }
}
