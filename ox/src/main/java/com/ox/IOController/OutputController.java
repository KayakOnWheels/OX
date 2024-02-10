package com.ox.IOController;

import com.ox.actors.Player;
import com.ox.logic.Rules;

import java.util.List;


public class OutputController {

    public static void printGameBoard() {
        Character[][] board = Rules.getMoves();
        for (int xi = 0; xi < board.length; xi++) {
            for (int yi = 0; yi < board[0].length; yi++) {
                System.out.print("|" + board[xi][yi]);
            }
            System.out.println("|");
        }
    }

    public static void printMenu() {
        System.out.println("""
                ---------Menu----------
                n - start new game
                x - end game
                r - resume
                s - statistics
                h - help
                -----------------------
                """);
    }

    public static void printGameGuide() {
        System.out.println("""
                -------Game Guide-------
                *Board numbers
                
                ↓→y 1   2   3
                x     
                1   11  12  13
                2   21  22  23
                3   31  32  33
                
                          
                11,12... - field number
                m - menu
                -----------------------
                """);
    }

    public static void confirmNewGame() {
        System.out.println("""
                Are you sure you want start new game?
                y - yes
                n - cancel
                """);
    }

    public static void confirmEndGame() {
        System.out.println("""
                Are you sure you want end game?
                y - yes
                n - cancel
                """);
    }

    public static void printStatistics() {

    }

    public static void humanOrComputer() {
        System.out.println("Do you want to play with computer or human?");
        System.out.println("y - computer      n - human");
    }


}
