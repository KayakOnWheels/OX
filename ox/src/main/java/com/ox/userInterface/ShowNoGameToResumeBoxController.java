package com.ox.userInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.currentRootPane;
import static com.ox.userInterface.CreateContent.rootGameScene;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ShowNoGameToResumeBoxController {
    public static void showNoGameToResumeBox(Stage stage) {
        VBox vBox = new VBox(30);

        vBox.setAlignment(Pos.CENTER);

        vBox.setMaxSize(300, 200);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        Label noGameLb = new Label("No game to resume!");
        noGameLb.setAlignment(Pos.CENTER);

        Button menuBtn = new Button("Menu");

        menuBtn.setOnAction(event -> { showMenu(stage); currentRootPane.getChildren().remove(vBox); rootGameScene.getChildren().clear();});

        Scene myScene = stage.getScene();
        TableView statTable = (TableView) myScene.lookup("#statTable");

        vBox.getChildren().addAll(noGameLb, menuBtn);
        currentRootPane.getChildren().add(vBox);
        stage.show();
    }

}
