package com.ox.userInterface;

import com.ox.logic.Rules;
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

        Rules.generateBoard(' ');

        //CreateContent.showMenu(primaryStage);
CreateContent.showPreGameScreen(primaryStage);
    }
}
