package com.ox.ioController;

import com.ox.logic.Rules;

import java.util.Scanner;

import static com.ox.ioController.OutputController.*;
import static com.ox.logic.OxRunner.*;

public class InputController {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputInGame() {
        String input = scanner.nextLine();
        boolean correctValue = false;
        while(!correctValue) {
            correctValue = "m".equals(input) || input != null && input.matches("[1-"+ Rules.getBoardSizeX() +
                    "][1-" + Rules.getBoardSizeY() + "]");
            if(!correctValue) {
                OutputController.enterAgain();
                input = scanner.nextLine();
            }
        }
        return input;
    }

    public static String getInput() {
        return scanner.nextLine();
    }
    public static boolean makeChoice() {
        String input = getInput();

        if("y".equals(input)) {
            return true;
        } else if("n".equals(input)) {
            return false;
        }
        return false;
    }

    public static void enterMenu() {
        printMenu();
        String input = getInput();

        switch (input) {
            case "n" -> ifNewGame();
            case "x" -> endGame();
            case "r" -> ifResumeGame();
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

    public static void ifNewGame() {
        confirmNewGame();
        if (makeChoice()) {
            startGame();
        } else {
            enterMenu();
        }
    }

    public static void ifResumeGame() {
        if (!Rules.isGameInProgress()) {
            noGameToResume();
            enterMenu();
        } else {
            processGame();
        }
    }


}
