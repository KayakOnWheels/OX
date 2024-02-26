package com.ox.userInterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.currentRootPane;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ConfirmChoiceController {

    public static void confirmChoice(Stage stage, EventHandler<ActionEvent> yes) {

        HBox hBox = new HBox(80);
        VBox vBox = new VBox(30);

        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);

        vBox.setMaxSize(300, 200);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        Label youSureLb = new Label("Are you sure");
        youSureLb.setAlignment(Pos.CENTER);

        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(yes);
        noBtn.setOnAction(event -> {showMenu(stage); currentRootPane.getChildren().remove(vBox);});

        vBox.getChildren().addAll(youSureLb, hBox);
        hBox.getChildren().addAll(yesBtn, noBtn);

        currentRootPane.getChildren().add(vBox);

        stage.show();
    }
}
