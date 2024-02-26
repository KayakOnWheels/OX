package com.ox.userInterface;

import com.ox.actors.ComputerPlayer;
import com.ox.actors.HumanPlayer;
import com.ox.actors.Player;
import com.ox.ioController.InputController;
import com.ox.ioController.OutputController;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.application.Platform;
import javafx.css.Rule;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public abstract class CreateContent {
    protected static final StackPane rootMenuScene = new StackPane();
    protected static final StackPane rootGameScene = new StackPane();
    protected static final StackPane rootPreGamePane = new StackPane();
    protected static StackPane currentRootPane;

    protected static final Scene menuScene = new Scene(rootMenuScene, 500, 500);
    protected static final Scene gameScene = new Scene(rootGameScene, 500, 500);
    protected static final Scene preGameScene = new Scene(rootPreGamePane, 500, 500);

    protected static final Image imageback = new Image("file:src\\main\\resources\\static\\backgrounds\\rect3.png");
    protected static final Background background = new Background(new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
            BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));




    public static Parent addFxml(String path) {
        try {
            return FXMLLoader.load(CreateContent.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
