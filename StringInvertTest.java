package com.stage1.part3.task2;

public class StringInvertTest {

    public static void main(String[] args) {

        String str1 = new String ("上海自来水来自海上");
        System.out.println("original string = " + str1);

        boolean is_it = true;
        for(int i = 0; i<=str1.length()/2; i++){
            if(str1.charAt(i) != str1.charAt(str1.length()-1-i)) {
                is_it = false;
                break;
            }
        }

        System.out.println(is_it ? "can be inverted" : "cannot be inverted");

    }
}
