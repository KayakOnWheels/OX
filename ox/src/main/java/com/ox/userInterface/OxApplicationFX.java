package com.ox.userInterface;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import static com.ox.network.Server.setUp;


public class OxApplicationFX extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("OX");
        try {
            setUp();
        }
        catch(IOException e) {
            System.out.println("Error");
        }

        ShowMenuController.showMenu(primaryStage);
    }
}
