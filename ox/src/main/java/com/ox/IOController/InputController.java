package com.ox.IOController;

import com.ox.actors.ComputerPlayer;
import com.ox.actors.Player;
import com.ox.logic.OxRunner;

import java.util.Scanner;

import static com.ox.IOController.OutputController.*;
import static com.ox.logic.OxRunner.*;

public class InputController {

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean makeChoice() {
        String input = getInput();

        if(input.equals("y")) {
            return true;
        } else if(input.equals("n")) {
            return false;
        }
        else return false;
    }

    public static void enterMenu() {
        printMenu();
        String input = getInput();

        switch (input) {
            case "n" -> {
                confirmNewGame();
                if (makeChoice()) {
                    startGame();
                } else {
                    enterMenu();
                }
            }
            case "x" -> endGame();
            case "r" -> {
                if (getPlayer1() == null) {
                    System.out.println("No game to resume!");
                    enterMenu();
                } else {
                    processGame();
                }
            }
            case "s" -> {
                printStatistics();
                enterMenu();
            }
            case "h" -> {
                printGameGuide();
                enterMenu();
            }
            default -> enterMenu();
        }
    }



}
