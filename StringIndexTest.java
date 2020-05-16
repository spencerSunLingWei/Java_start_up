package com.stage1.part3.task2;

public class StringIndexTest {

    public static void main(String[] args) {

        String str1 = new String("Good Good Study, Day Day Up!");
        System.out.println("original string: " + str1);

        int pos = str1.indexOf('9');
        System.out.println("position = " + pos); //-1 means cannot find

        pos = str1.indexOf('G');
        System.out.println("position = " + pos); //the first index that match

        pos = str1.indexOf('G',5);
        System.out.println("position = " + pos); //start from index 5 search

        pos = str1.indexOf("Day");
        System.out.println("position = " + pos); //the first index that match

        pos = str1.indexOf("Day",19);
        System.out.println("position = " + pos);

        System.out.println("------------------------------------------------");

        pos = str1.indexOf("Day");
        while (-1 != pos){
            System.out.println("pos = " + pos);
            pos = str1.indexOf("Day", pos+1);
        }

        pos = 0;
        while ((pos = str1.indexOf("Day", pos)) != -1){
            System.out.println("pos = " + pos);
            pos += "Day".length();
        }

        System.out.println("------------------------------------------------");

        pos = str1.length()-"Day".length();;
        while ((pos = str1.lastIndexOf("Day", pos)) != -1){
            System.out.println("pos = " + pos);
            pos -= "Day".length();
        }
    }
}
