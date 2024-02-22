package com.ox.ioController;

import com.ox.actors.Player;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static com.ox.ioController.OutputController.*;
import static com.ox.logic.OxRunner.*;

public class InputController {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String rankingFilePath = "C:\\Users\\Grzegorz\\Documents\\GitHub\\OX\\ox\\src\\main\\resources\\ranking.csv";
    private static final String lastGamePath = "C:\\Users\\Grzegorz\\Documents\\GitHub\\OX\\ox\\src\\main\\resources\\lastGame.csv";


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

    public static Map<String, String[]> getRanking() {
        Map<String, String[]> map = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(rankingFilePath))) {
            lines.forEach(line -> {
                String[] keyValuePair = line.split(";", 2);
                String key = keyValuePair[0];
                String value = keyValuePair[1];
                String[] valueCorrected = value.split(":", 2);
                map.put(key, valueCorrected);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void addToRanking(Player playerWon, Player playerLost) {
        Map<String, String[]> map = getRanking();
        try {
            FileWriter file = new FileWriter(rankingFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);

            if(map.get(playerWon.getName()) == null) {
                String[] s = {"0", "0"};
                map.put(playerWon.getName(), s);
            }
            if(map.get(playerLost.getName()) == null) {
                String[] s = {"0", "0"};
                map.put(playerLost.getName(), s);
            }

            int playerLostIncremented = Integer.parseInt(map.get(playerLost.getName())[1]) + 1;
            String[] s1 = {map.get(playerLost.getName())[0], String.valueOf(playerLostIncremented)};
            map.put(playerLost.getName(), s1);


            int playerWonIncremented = Integer.parseInt(map.get(playerWon.getName())[0]) + 1;
            String[] s2 = {String.valueOf(playerWonIncremented), map.get(playerWon.getName())[1]};
            map.put(playerWon.getName(), s2);

            System.out.println("p1: " + map.get(playerLost.getName())[0] + map.get(playerLost.getName())[1]);
            System.out.println("p2: " + map.get(playerWon.getName())[0] + map.get(playerWon.getName())[1]);

            for(Map.Entry<String, String[]> entry : map.entrySet()) {
                bufferedWriter.write(entry.getKey() + ";" + entry.getValue()[0] + ":" + entry.getValue()[1]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        }

    public static void saveGame() {
        try {
            FileWriter file = new FileWriter(lastGamePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
