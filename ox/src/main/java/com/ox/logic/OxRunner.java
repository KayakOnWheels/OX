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
        whatsYourName();
        player1 = new HumanPlayer(InputController.getInput());
        whatsYourSymbol();
        player1.setPlayerSymbol(getInput().charAt(0));

        humanOrComputer();
        if(makeChoice()) {
            player2 = new ComputerPlayer("NPC");
            player2.setPlayerSymbol('O');
        } else {
            whatsTheNameOfTheSecondPlayer();
            player2 = new HumanPlayer(InputController.getInput());
            whatsTheSymbolOfThisPlayer();
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
            yourMove();
            player1.makeMove();
            printGameBoard();
            gameStatus = gameStatus();

            if (gameStatus == 1 || gameStatus == -1) {
                finishGame(player1, gameStatus);
            }

            opponentsMove();
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
            gameFinishedWithWinner(p);
            enterMenu();
        } else {
            gameFinishedWithoutWinner();
            enterMenu();
        }
    }

}
