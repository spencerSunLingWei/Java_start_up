package com.stage1.part2.hw1;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Gomoku {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private final int SIZE = 17;
    char[][] arr = new char[SIZE][SIZE];

    public void setArr(){
        //set the initial board
        for(int col = 1; col < SIZE; col++){
            if(col<=10) 	arr[0][col] = (char)(48+col-1);
            if(col>10)	arr[0][col] = (char)(97+col-11);
        }

        for(int row = 1; row < SIZE; row++){
            if(row<=10) 	arr[row][0] = (char)(48+row-1);
            if(row>10)	arr[row][0] = (char)(97+row-11);

            for(int col = 1; col < SIZE; col++){
                arr[row][col] = '+';
            }
        }
    }

    public void printArr(){
        //print the current array
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if (row == 0 && col == 0) {
                    System.out.print("   ");
                }
                else {
                    if (arr[row][col] == 'W') System.out.print("  " + ANSI_YELLOW + arr[row][col] + ANSI_RESET);
                    else if (arr[row][col] == 'B') System.out.print("  " + ANSI_PURPLE + arr[row][col] + ANSI_RESET);
                    else System.out.print("  " + arr[row][col]);
                }
            }
            System.out.println();
        }
    }

    public boolean updateArr(boolean is_white){
        boolean is_valid = false;

        //take user input
        if(is_white)    System.out.println(ANSI_BLUE + "Now is the white turn, please enter the position that you want to place your pierce in a form of (row column): " + ANSI_RESET);
        else            System.out.println(ANSI_BLUE + "Now is the black turn, please enter the position that you want to place your pierce in a form of (row column): " + ANSI_RESET);

        Scanner sc = new Scanner(System.in);
        String row_s = sc.next();
        String col_s = sc.next();

        //input decoder
        if(
                (row_s.equals("0") || row_s.equals("1") || row_s.equals("2") || row_s.equals("3") || row_s.equals("4") ||
                row_s.equals("5") || row_s.equals("6") || row_s.equals("7") || row_s.equals("8") || row_s.equals("9") ||
                row_s.equals("a") || row_s.equals("b") || row_s.equals("c") || row_s.equals("d") || row_s.equals("e") ||
                        row_s.equals("f"))  && (col_s.equals("0") ||
                col_s.equals("1") || col_s.equals("2") || col_s.equals("3") || col_s.equals("4") || col_s.equals("5") ||
                col_s.equals("6") || col_s.equals("7") || col_s.equals("8") || col_s.equals("9") || col_s.equals("a") ||
                col_s.equals("b") || col_s.equals("c") || col_s.equals("d") || col_s.equals("e") || col_s.equals("f"))
        ){
            int row = Integer.parseInt(row_s, 16) + 1;
            int col = Integer.parseInt(col_s, 16) + 1;

            //update the board
            if (row == 0 || col == 0 || row >= SIZE || col >= SIZE) {
                //check for invalid input
                System.out.println(ANSI_RED + "invalid row or col input, please enter a position inside the board" + ANSI_RESET);
            }
            else if (arr[row][col] != '+') {
                //check for invalid input
                System.out.println(ANSI_RED + "already been taken, please enter another position" + ANSI_RESET);
            }
            else {
                //valid, do the update
                if (is_white) {
                    //white turn
                    arr[row][col] = 'W';
                } else {
                    //black turn
                    arr[row][col] = 'B';
                }
                is_valid = true;
            }
        }
        else{
            System.out.println(ANSI_RED + "invalid row or col input, please enter a position inside the board" + ANSI_RESET);
        }

        //print the arr
        if(is_valid)    printArr();

        return is_valid;
    }

    public boolean checkArr(){
        for(int row = 1; row < SIZE; row++){
            for(int col = 1; col < SIZE; col++){
                //if match check status
                if(arr[row][col] != '+'){
                    //case 1
                    if(row < 13 &&
                            arr[row][col] == arr[row+1][col] && arr[row][col] == arr[row+2][col] &&
                            arr[row][col] == arr[row+3][col] && arr[row][col] == arr[row+4][col]){
                        return true;
                    }

                    //case 2
                    if(col < 13 &&
                            arr[row][col] == arr[row][col+1] && arr[row][col] == arr[row][col+2] &&
                            arr[row][col] == arr[row][col+3] && arr[row][col] == arr[row][col+4]){
                        return true;
                    }

                    //case 3
                    if(row < 13 && col < 13 &&
                            arr[row][col] == arr[row+1][col+1] && arr[row][col] == arr[row+2][col+2] &&
                            arr[row][col] == arr[row+3][col+3] && arr[row][col] == arr[row+4][col+4]){
                        return true;
                    }

                    //case 4
                    if(row < 13 && col > 4 &&
                            arr[row][col] == arr[row+1][col-1] && arr[row][col] == arr[row+2][col-2] &&
                            arr[row][col] == arr[row+3][col-3] && arr[row][col] == arr[row+4][col-4]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
