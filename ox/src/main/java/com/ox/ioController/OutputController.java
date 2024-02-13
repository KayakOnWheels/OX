package com.ox.ioController;

import com.ox.actors.Player;
import com.ox.logic.Rules;


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

    public static void enterAgain() {
        System.out.println("Bad command! Enter again.");
    }

    public static void whatsYourName() {
        System.out.println("What's your name? ");
    }

    public static void whatsYourSymbol() {
        System.out.print("What's your symbol? ");
    }

    public static void whatsTheNameOfTheSecondPlayer() {
        System.out.println("What's the name of second player?");
    }

    public static void whatsTheSymbolOfThisPlayer() {
        System.out.print("And his symbol? ");
    }

    public static void yourMove() {
        System.out.print("Your Move ");
    }

    public static void opponentsMove() {
        System.out.println("Opponent's move ");
    }

    public static void gameFinishedWithWinner(Player p) {
        System.out.println("Game finished! " + p.getName() + " won");
    }

    public static void gameFinishedWithoutWinner() {
        System.out.println("Game finished! No winner");
    }

    public static void noGameToResume() {
        System.out.println("No game to resume!");
    }

    public static void thisFieldIsOccupied() {
        System.out.println("This field is occupied! Choose another.");
    }

}
