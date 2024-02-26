package com.ox.userInterface;

import com.ox.actors.Player;
import com.ox.ioController.InputController;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.currentRootPane;
import static com.ox.userInterface.CreateContent.rootGameScene;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ShowGameFinishedBoxController {

    public static void showGameFinishedBox(Stage stage) {
        Player winner = OxRunner.getWhoseMove();
        Player looser;

        looser = winner.equals(OxRunner.getPlayer1()) ? OxRunner.getPlayer2() : OxRunner.getPlayer1();
        VBox vBox = new VBox(30);

        vBox.setAlignment(Pos.CENTER);

        vBox.setMaxSize(300, 200);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        Label gameFinishedLb = new Label("Game Finished!");
        gameFinishedLb.setAlignment(Pos.CENTER);
        Label whoWonLb = new Label(winner.getName() + " won!");
        Label boardFullLb = new Label("No more fields available");

        Button menuBtn = new Button("Menu");

        menuBtn.setOnAction(event -> { showMenu(stage); currentRootPane.getChildren().remove(vBox); rootGameScene.getChildren().clear();});

        if(Rules.gameStatus() == 1) {
            vBox.getChildren().addAll(gameFinishedLb, whoWonLb, menuBtn);
        } else {
            vBox.getChildren().addAll(gameFinishedLb, boardFullLb, menuBtn);
        }

        Rules.setGameInProgress(false);
        InputController.addToRanking(winner, looser);

        currentRootPane.getChildren().add(vBox);
        stage.show();
    }
}
