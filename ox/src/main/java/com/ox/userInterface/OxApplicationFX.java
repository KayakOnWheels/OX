package com.ox.userInterface;

import javafx.application.Application;
import javafx.stage.Stage;

public class OxApplicationFX extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("OX");


        CreateContent.showMenu(primaryStage);
    }
}
