package com.ox.logic;

import com.ox.ioController.InputController;
import com.ox.actors.ComputerPlayer;
import com.ox.actors.HumanPlayer;
import com.ox.actors.Player;

import static com.ox.ioController.InputController.*;
import static com.ox.ioController.OutputController.*;
import static com.ox.logic.Rules.*;

public class OxRunner {
    private static Player player1;
    private static Player player2;


    public static void startGame() {

        setGameInProgress(true);
        System.out.print("What's your name? ");
        player1 = new HumanPlayer(InputController.getInput());
        System.out.print("What's your symbol? ");
        player1.setPlayerSymbol(getInput().charAt(0));

        humanOrComputer();
        if(makeChoice()) {
            player2 = new ComputerPlayer("NPC");
            player2.setPlayerSymbol('O');
        } else {
            System.out.println("What's the name of second player?");
            player2 = new HumanPlayer(InputController.getInput());
            System.out.print("And his symbol? ");
            player2.setPlayerSymbol(getInput().charAt(0));
        }

        generateBoard();
        printGameGuide();
        printGameBoard();
        processGame();
    }

    public static void processGame() {

        byte gameStatus = 0;
        while(gameStatus == 0) {
            System.out.print("Your move ");
            player1.makeMove();
            printGameBoard();
            gameStatus = gameStatus();

            if (gameStatus == 1 || gameStatus == -1) {
                finishGame(player1, gameStatus);
            }

            System.out.println("Opponent's move");
            player2.makeMove();
            printGameBoard();
            gameStatus = gameStatus();

            if (gameStatus == 1 || gameStatus == -1) {
                finishGame(player2, gameStatus);
            }
        }
    }

    public static void endGame() {
        confirmEndGame();
        if(makeChoice()) {
            System.exit(0);
        } else {
            enterMenu();
        }
    }

    public static void finishGame(Player p, byte gameStatus) {
        setGameInProgress(false);
        if(gameStatus == 1) {
            System.out.println("Game finished! " + p.getName() + " won");
            enterMenu();
        } else {
            System.out.println("Game finished! No winner");
            enterMenu();
        }
    }

}
