package com.stage1.part3.hw4;

import com.stage1.part3.task1.StudentTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Q4main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        //set up
        List<Student> lst = new ArrayList<Student>();
        lst.add(new Student("1234", "spencer","20"));
        lst.add(new Student("5678", "james","20"));
        lst.add(new Student("0000", "jesse","20"));

        while(true) {
            //get user input
            System.out.print(ANSI_RESET + "\nPlease select you want to insert(i), delete(d), update(u), search(s) or quit(q): ");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();

            //update
            if ("q".equalsIgnoreCase(input)) {
                System.out.println("\nYou select to quit the program, BYE!");
                return;
            }
            else if ("i".equalsIgnoreCase(input)) {
                System.out.println(ANSI_PURPLE + "\nYou select to do insertions ---------------------------" + ANSI_RESET);
                System.out.print(ANSI_PURPLE + "enter the student's number, name and age: ");
                String inputNumber = sc.next();
                String inputName = sc.next();
                String inputAge = sc.next();

                for (int i=0; i<lst.size(); i++) {
                    Student st = lst.get(i);
                    if (st.getName().equals(inputName) || st.getNumber().equals(inputNumber)) {
                        System.out.println("Student already exist in the list.");
                        break;
                    }
                    if(i == lst.size()-1){
                        lst.add(new Student(inputNumber, inputName, inputAge));
                    }
                }

                System.out.println("The list elements are: ");
                for (Student st : lst) {
                    System.out.println("\t\t" + st);
                }
            }
            else if ("d".equalsIgnoreCase(input)) {
                System.out.println(ANSI_BLUE + "\nYou select to do deletions ---------------------------" + ANSI_RESET);
                if(lst.isEmpty()){
                    System.out.println(ANSI_BLUE + "The list is currently empty, nothing can be deleted");
                }
                else {
                    boolean bool = true;
                    while (bool) {
                        System.out.print(ANSI_BLUE + "delete by student name(n) or student number(b) ? ");
                        input = sc.next();
                        if (input.equals("n")) {
                            bool = false;
                            System.out.print("enter the student name: ");
                            String inputName = sc.next();

                            int i;
                            for (i=0; i<lst.size(); i++) {
                                Student st = lst.get(i);
                                if (st.getName().equals(inputName)) {
                                    lst.remove(st);
                                    System.out.println("Removing " + st);
                                    i = -1;
                                    break;
                                }
                            }

                            if(i!=-1){
                                System.out.println("Cannot find such student.");
                            }
                            else {
                                if (lst.isEmpty()) {
                                    System.out.println("The list is empty");
                                }
                                else {
                                    System.out.println("The list remains to be: ");
                                    for (Student st : lst) {
                                        System.out.println("\t\t" + st);
                                    }
                                }
                            }
                        }
                        else if (input.equals("b")) {
                            bool = false;
                            System.out.print("enter the student number: ");
                            String inputNumber = sc.next();

                            int i;
                            for (i = 0; i < lst.size(); i++) {
                                Student st = lst.get(i);
                                if (st.getNumber().equals(inputNumber)) {
                                    lst.remove(st);
                                    System.out.println("Removing " + st);
                                    i = -1;
                                    break;
                                }
                            }

                            if (i!=-1) {
                                System.out.println("Cannot find such student.");
                            } else {
                                if (lst.isEmpty()) {
                                    System.out.println("The list is empty");
                                } else {
                                    System.out.println("The list remains to be: ");
                                    for (Student st : lst) {
                                        System.out.println("\t\t" + st);
                                    }
                                }
                            }
                        }
                        else {
                            System.out.println("Invalid input");
                        }
                    }
                }
            }
            else if ("u".equalsIgnoreCase(input)) {
                System.out.println(ANSI_YELLOW + "\nYou select to do modifications ---------------------------" + ANSI_RESET);
                if(lst.isEmpty()){
                    System.out.println(ANSI_YELLOW + "The list is currently empty, nothing can be modified");
                }
                else {
                    boolean bool = true;
                    while (bool) {
                        System.out.print(ANSI_YELLOW + "search by student name(n) or student number(b) ? ");
                        input = sc.next();
                        if (input.equals("n")) {
                            bool = false;
                            System.out.print("enter the student name: ");
                            String inputName = sc.next();

                            for (int i=0; i<lst.size(); i++) {
                                Student st = lst.get(i);
                                if (st.getName().equals(inputName)) {
                                    System.out.println("Student founded: " + st);

                                    boolean valid = true;
                                    while(valid) {
                                        System.out.print("change student number (b) or age (a) or both (h) ? ");
                                        String inputSub = sc.next();

                                        if (inputSub.equalsIgnoreCase("b")) {
                                            valid = false;
                                            System.out.print("enter the new number: ");
                                            st.setNumber(sc.next());
                                            lst.set(i, st);
                                            System.out.println("The student information is modified to: " + st);
                                        }
                                        else if(inputSub.equalsIgnoreCase("a")){
                                            valid = false;
                                            System.out.print("enter the new age: ");
                                            st.setAge(sc.next());
                                            lst.set(i, st);
                                            System.out.println("The student information is modified to: " + st);
                                        }
                                        else if(inputSub.equalsIgnoreCase("h")){
                                            valid = false;
                                            System.out.print("enter the new number and age: ");
                                            st.setNumber(sc.next());
                                            st.setAge(sc.next());
                                            lst.set(i, st);
                                            System.out.println("The student information is modified to: " + st);
                                        }
                                        else{
                                            System.out.println("Invalid input");
                                        }
                                    }

                                    break;
                                }
                                if(i == lst.size()-1){
                                    System.out.println("Cannot find such student.");
                                }
                            }
                        }
                        else if (input.equals("b")) {
                            bool = false;
                            System.out.print("enter the student number: ");
                            String inputNumber = sc.next();

                            for (int i=0; i<lst.size(); i++) {
                                Student st = lst.get(i);
                                if (st.getNumber().equals(inputNumber)) {
                                    System.out.println("Student founded: " + st);

                                    boolean valid = true;
                                    while(valid) {
                                        System.out.print("change student name (n) or age (a) or both (h) ? ");
                                        String inputSub = sc.next();

                                        if (inputSub.equalsIgnoreCase("n")) {
                                            valid = false;
                                            System.out.print("enter the new name: ");
                                            st.setName(sc.next());
                                            lst.set(i, st);
                                            System.out.println("The student information is modified to: " + st);
                                        }
                                        else if(inputSub.equalsIgnoreCase("a")){
                                            valid = false;
                                            System.out.print("enter the new age: ");
                                            st.setAge(sc.next());
                                            lst.set(i, st);
                                            System.out.println("The student information is modified to: " + st);
                                        }
                                        else if(inputSub.equalsIgnoreCase("h")){
                                            valid = false;
                                            System.out.print("enter the new name and age: ");
                                            st.setName(sc.next());
                                            st.setAge(sc.next());
                                            lst.set(i, st);
                                            System.out.println("The student information is modified to: " + st);
                                        }
                                        else{
                                            System.out.println("Invalid input");
                                        }
                                    }

                                    break;
                                }
                                if(i == lst.size()-1){
                                    System.out.println("Cannot find such student.");
                                }
                            }
                        }
                        else {
                            System.out.println("Invalid input");
                        }
                    }
                }
            }
            else if ("s".equalsIgnoreCase(input)) {
                System.out.println(ANSI_RED + "\nYou select to do searching ---------------------------" + ANSI_RESET);
                if(lst.isEmpty()){
                    System.out.println(ANSI_RED + "The list is currently empty, nothing can be found");
                }
                else {
                    boolean bool = true;
                    while (bool) {
                        System.out.print(ANSI_RED + "search by student name(n) or student number(b) ? ");
                        input = sc.next();
                        if (input.equals("n")) {
                            bool = false;
                            System.out.print("enter the student name: ");
                            String inputName = sc.next();

                            for (int i=0; i<lst.size(); i++) {
                                Student st = lst.get(i);
                                if (st.getName().equals(inputName)) {
                                    System.out.println("Student founded: " + st);
                                    break;
                                }
                                if(i == lst.size()-1){
                                    System.out.println("Cannot find such student.");
                                }
                            }

                        }
                        else if (input.equals("b")) {
                            bool = false;
                            System.out.print("enter the student number: ");
                            String inputNumber = sc.next();

                            for (int i=0; i<lst.size(); i++) {
                                Student st = lst.get(i);
                                if (st.getNumber().equals(inputNumber)) {
                                    System.out.println("Student founded: " + st);
                                    break;
                                }
                                if(i == lst.size()-1){
                                    System.out.println("Cannot find such student.");
                                }
                            }
                        }
                        else {
                            System.out.println("Invalid input");
                        }
                    }
                }
            }
            else {
                System.out.println("\nInvalid input");
            }
        }
    }
}
