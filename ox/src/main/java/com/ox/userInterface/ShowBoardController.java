package com.ox.userInterface;

import com.ox.actors.ComputerPlayer;
import com.ox.ioController.OutputController;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.*;
import static com.ox.userInterface.ShowGameFinishedBoxController.showGameFinishedBox;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ShowBoardController
{

    public static void showBoard(Stage stage) {
        GridPane boardGrid = new GridPane();
        rootGameScene.getChildren().add(boardGrid);
        currentRootPane = rootGameScene;
        rootGameScene.setBackground(background);

        boardGrid.setAlignment(Pos.CENTER);

        for (int xi = 0; xi < Rules.getBoardSizeX(); xi++) {
            for (int yi = 0; yi < Rules.getBoardSizeY(); yi++) {
                Button btn = new Button(Character.toString(Rules.getBoard()[xi][yi]));
                btn.setMinSize(50,50);
                btn.setId(yi+1 + Integer.toString(xi+1));
                btn.setOnAction(event -> {
                    Rules.addMoveToBoard(btn.getId(), OxRunner.getWhoseMove());
                    btn.setText(OxRunner.getWhoseMove().getPlayerSymbol().toString());
                    OutputController.printGameBoard();

                    if(Rules.gameStatus() == 1 || Rules.gameStatus() == -1) {
                        showGameFinishedBox(stage);
                    }

                    if(OxRunner.getPlayer2() instanceof ComputerPlayer) {
                        String rndField = OxRunner.getPlayer2().makeMove();
                        String btnId = ("#" + rndField);

                        Button retrievedButton = (Button) boardGrid.lookup(btnId);
                        retrievedButton.setText(OxRunner.getPlayer2().getPlayerSymbol().toString());
                        OxRunner.setWhoseMove(OxRunner.getPlayer2());
                        OutputController.printGameBoard();

                        if(Rules.gameStatus() == 1 || Rules.gameStatus() == -1) {
                            showGameFinishedBox(stage);
                        }
                        OxRunner.setWhoseMove(OxRunner.getPlayer1());

                    } else if(OxRunner.getWhoseMove().equals(OxRunner.getPlayer1())) {
                        OxRunner.setWhoseMove(OxRunner.getPlayer2());
                    } else {
                        OxRunner.setWhoseMove(OxRunner.getPlayer1());
                    }


                });
                boardGrid.add(btn, xi, yi);
            }
        }
        rootGameScene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if(keyCode.equals(KeyCode.ESCAPE)) {
                showMenu(stage);
            }

        });

        stage.setScene(gameScene);
        stage.show();
    }
}
