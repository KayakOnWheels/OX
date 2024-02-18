package com.ox.userInterface;

import com.ox.actors.Player;
import com.ox.ioController.InputController;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class CreateContent {
    private static int boardButtonNumber;

    public static void createBoard(GridPane gridPane) {

        for (int xi = 0; xi < Rules.getBoardSizeX(); xi++) {
            for (int yi = 0; yi < Rules.getBoardSizeY(); yi++) {
                Button btn = new Button();
                btn.setMinSize(50,50);
                btn.setId(xi+1 + Integer.toString(yi+1));
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //Button btn = (Button) event.getTarget();
                        btn.setText(OxRunner.getWhoseMove().getPlayerSymbol().toString());
                        Rules.addMoveToBoard(btn.getId(), OxRunner.getWhoseMove());
                    }
                });
                gridPane.add(btn, xi, yi);
            }
        }
    }

    public static void createMenu(VBox vBox) {
        Label headerLb = new Label("OX");
        headerLb.setMinSize(100,10);
        headerLb.setAlignment(Pos.CENTER);


        Button resumeBtn = new Button("Resume");
        resumeBtn.setMinSize(100,10);
        resumeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //resumeGame
            }
        });

        Button newGameBtn = new Button("Start New Game");
        newGameBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //startGame
            }
        });

        Button statisticsBtn = new Button("Statistics");
        statisticsBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //stats
            }
        });

        Button helpBtn = new Button("Help");
        helpBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Help
            }
        });

        Button endGameBtn = new Button("Exit");
        endGameBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //exit
            }
        });

        vBox.getChildren().addAll(headerLb, resumeBtn, newGameBtn, statisticsBtn, helpBtn, endGameBtn);
    }

    public static void confirmChoice() {
        StackPane rootConfirmationScene = new StackPane();
        Scene confirmationScene = new Scene(rootConfirmationScene, 300, 250);

        HBox hBox = new HBox(20);
        VBox vBox = new VBox(20);

        vBox.getChildren().add(hBox);
        Label youSure = new Label("Are you sure");
        vBox.getChildren().add(youSure);

        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        hBox.getChildren().addAll(yesBtn, noBtn);

        rootConfirmationScene.getChildren().addAll(hBox, vBox);
    }

}
