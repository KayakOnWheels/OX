package com.ox.userInterface;

import com.ox.logic.Rules;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.ox.userInterface.ConfirmChoiceController.confirmChoice;
import static com.ox.userInterface.ShowBoardController.showBoard;
import static com.ox.userInterface.ShowHelpSceneController.showHelpScene;
import static com.ox.userInterface.ShowNoGameToResumeBoxController.showNoGameToResumeBox;
import static com.ox.userInterface.ShowPreGameScreenController.showPreGameScreen;
import static com.ox.userInterface.ShowStatisticsSceneController.showStatisticsScene;

public class ShowMenuController extends CreateContent{

    public static void showMenu(Stage stage) {
        VBox menuVBox = new VBox(8);
        menuVBox.setAlignment(Pos.CENTER);
        rootMenuScene.getChildren().add(menuVBox);
        currentRootPane = rootMenuScene;
        rootMenuScene.setBackground(background);

        Label headerLb = new Label("OX");
        headerLb.setMinSize(100,10);
        headerLb.setAlignment(Pos.CENTER);

        Button resumeBtn = new Button("Resume");
        resumeBtn.setMinSize(100,10);
        resumeBtn.setOnAction(event -> {
            currentRootPane.getChildren().clear();
            if(Rules.isGameInProgress()) {
                showBoard(stage);
            } else {
                showNoGameToResumeBox(stage);
            }
        });

        Button newGameBtn = new Button("Start New Game");
        newGameBtn.setMinSize(100,10);
        newGameBtn.setOnAction(event -> confirmChoice(stage, handler -> { currentRootPane.getChildren().clear(); showPreGameScreen(stage);}));

        Button statisticsBtn = new Button("Statistics");
        statisticsBtn.setMinSize(100,10);
        statisticsBtn.setOnAction(event -> showStatisticsScene(stage));

        Button helpBtn = new Button("Help");
        helpBtn.setMinSize(100,10);
        helpBtn.setOnAction(event -> showHelpScene(stage));

        Button endGameBtn = new Button("Exit");
        endGameBtn.setMinSize(100,10);
        endGameBtn.setOnAction(event -> confirmChoice(stage, handler -> Platform.exit()));

        menuVBox.getChildren().addAll(headerLb, resumeBtn, newGameBtn, statisticsBtn, helpBtn, endGameBtn);

        stage.setScene(menuScene);
        stage.show();
    }

}
