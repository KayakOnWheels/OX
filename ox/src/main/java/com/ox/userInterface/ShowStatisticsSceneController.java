package com.ox.userInterface;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.addFxml;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ShowStatisticsSceneController {
    public static void showStatisticsScene(Stage stage) {
        Scene statisticsScene = new Scene(addFxml("/templates/fxmlstatisticsboard.fxml"), 500, 500);

        statisticsScene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if(keyCode.equals(KeyCode.ESCAPE)) {
                showMenu(stage);
            }

        });
        stage.setScene(statisticsScene);
        stage.show();
    }
}
