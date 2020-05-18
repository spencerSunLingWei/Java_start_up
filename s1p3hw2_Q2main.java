package com.stage1.part3.hw2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Q2main {

    public static String FindCommon(String a, String b){
        //nothing inside
        if(a == null || b == null)          return "";
        //reach the end of the string
        if(a.length()<1 || b.length()<1)    return "";

        //if contain
        if(a.contains(b))                   return b;
        //if nothing left
        else if(b.length()==1)              return "";

        String left = FindCommon(a, b.substring(0,b.length()-1));
        String right = FindCommon(a, b.substring(1, b.length()));

        return left.length()>right.length() ? left : right;
    }


    public static void main(String[] args) {

        //get user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the first string: ");
        String s1 = sc.next();
        System.out.print("Please enter the second string: ");
        sc = new Scanner(System.in);
        String s2 = sc.next();
        sc.close();
        System.out.println();

        //do comparison
        String output = Q2main.FindCommon(s1, s2);

        System.out.println("the longest sub string: " + output);

    }
}
