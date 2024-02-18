package com.ox.userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OxApplicationFX extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("OX");
        StackPane rootMenuScene = new StackPane();
        StackPane rootGameScene = new StackPane();

        Scene menuScene = new Scene(rootMenuScene, 300, 250);
        Scene gameScene = new Scene(rootGameScene, 300, 250);


        GridPane boardGrid = new GridPane();
        VBox menuGrid = new VBox(8);
        menuGrid.setAlignment(Pos.CENTER);

        rootMenuScene.getChildren().add(menuGrid);
        rootGameScene.getChildren().add(boardGrid);

        CreateContent.createBoard(boardGrid);
        CreateContent.createMenu(menuGrid);

        primaryStage.setScene(menuScene);
        primaryStage.show();

    }

}
