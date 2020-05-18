package com.stage1.part3.hw5;

import com.stage1.part2.task5.StaticOuter;
import com.stage1.part3.task5.Student;

import java.util.*;

public class Q5main {

    public static void main(String[] args) {

        //set up
        List<String> lst = Arrays.asList("王S","王B",
                "♠2","♠A","♠K","♠Q","♠J","♠10","♠9","♠8","♠7","♠6","♠5","♠4","♠3",
                "♣2","♣A","♣K","♣Q","♣J","♣10","♣9","♣8","♣7","♣6","♣5","♣4","♣3",
                "♦2","♦A","♦K","♦Q","♦J","♦10","♦9","♦8","♦7","♦6","♦5","♦4","♦3",
                "♥2","♥A","♥K","♥Q","♥J","♥10","♥9","♥8","♥7","♥6","♥5","♥4","♥3");

        Collections.shuffle(lst);

        //split
        List<String> player1 = new ArrayList<String>();
        List<String> player2 = new ArrayList<String>();
        List<String> player3 = new ArrayList<String>();
        List<String> rest = new ArrayList<String>();

        for(int i=0; i<=51; i+=3){
            if(i==51){
                rest.add(lst.get(i+2));
                rest.add(lst.get(i+1));
                rest.add(lst.get(i));
                break;
            }
            player1.add(lst.get(i));
            player2.add(lst.get(i+1));
            player3.add(lst.get(i+2));

        }

        //print
        System.out.print("Player 1:");
        for(String p1:player1){
            System.out.print(" " + p1);
        }
        System.out.println();

        System.out.print("Player 2:");
        for(String p2:player2){
            System.out.print(" " + p2);
        }
        System.out.println();

        System.out.print("Player 3:");
        for(String p3:player3){
            System.out.print(" " + p3);
        }
        System.out.println();

        System.out.print("Rest:");
        for(String R:rest){
            System.out.print(" " + R);
        }
        System.out.println();

        //sort
        System.out.println("-------------------------------------------------------------------");
        Comparator<String> comparator = (String a, String b) -> {
            String a1 = a.substring(1);
            String b1 = b.substring(1);
            if(a1.equals("B"))       return 1;
            else if(b1.equals("B"))       return -1;
            else if(a1.equals("S"))       return 1;
            else if(b1.equals("S"))       return -1;
            else if(a1.equals("2"))        return 1;
            else if(b1.equals("2"))        return -1;
            else if(a1.equals("A"))        return 1;
            else if(b1.equals("A"))        return -1;
            else if(a1.equals("K"))        return 1;
            else if(b1.equals("K"))        return -1;
            else if(a1.equals("Q"))        return 1;
            else if(b1.equals("Q"))        return -1;
            else if(a1.equals("J"))        return 1;
            else if(b1.equals("J"))        return -1;
            else if(a1.equals("10"))        return 1;
            else if(b1.equals("10"))        return -1;
            else {
                int num = a1.compareTo(b1);
                return num == 0 ? 1 : num;
            }
        };

        Set<String> player_1 = new TreeSet<>(comparator);
        for(String p1:player1){
            player_1.add(p1);
        }
        System.out.print("Player 1 sorted: ");
        System.out.println(player_1);

        Set<String> player_2 = new TreeSet<>(comparator);
        for(String p2:player2){
            player_2.add(p2);
        }
        System.out.print("Player 2 sorted: ");
        System.out.println(player_2);

        Set<String> player_3 = new TreeSet<>(comparator);
        for(String p3:player3){
            player_3.add(p3);
        }
        System.out.print("Player 3 sorted: ");
        System.out.println(player_3);

        Set<String> rest_t = new TreeSet<>(comparator);
        for(String R:rest){
            rest_t.add(R);
        }
        System.out.print("Rest sorted: ");
        System.out.println(rest_t);


    }
}
