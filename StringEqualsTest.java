package com.stage1.part3.task2;

import java.util.Scanner;

public class StringEqualsTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i = 3; i>0 ; i--) {
            System.out.println("please enter the username and password");
            String userName = sc.next();
            String password = sc.next();

            if("admin".equalsIgnoreCase(userName) && "123456".equals(password)){
                System.out.println("welcome");
                break;
            }

            if(i == 1){
                System.out.println("system locked");
            }
            else{
                System.out.println(i-1 + " times remaining");
            }
        }

        sc.close();
    }
}
