package com.ox.userInterface;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.addFxml;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ShowHelpSceneController {

    public static void showHelpScene(Stage stage) {

        Scene helpScene = new Scene(addFxml("/templates/fxmlhelpboard.fxml"), 500, 500);

        helpScene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if(keyCode.equals(KeyCode.ESCAPE)) {
                showMenu(stage);
            }

        });
        stage.setScene(helpScene);
        stage.show();
    }
}
