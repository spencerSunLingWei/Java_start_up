package com.stage1.part2.hw1;

import com.stage1.part2.hw1.Gomoku;

public class GomokuTest {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        //game initialization
        Gomoku game = new Gomoku();
        game.setArr();
        game.printArr();

        //variable for checking the game status
        boolean is_win = false;
        boolean is_white = false;

        //main loop of the game
        while(!is_win){
            //get user input and update the board
            boolean is_valid = game.updateArr(is_white);
            if(!is_valid)       continue;

            //check the game status
            is_win = game.checkArr();
            if(is_win){
                if(is_white)        System.out.println(ANSI_CYAN + "White Win!" + ANSI_RESET);
                else                System.out.println(ANSI_CYAN + "Black Win!" + ANSI_RESET);
            }

            if(is_valid)            is_white = !is_white;
        }

    }

}
