package com.ox.userInterface;

import com.ox.actors.Player;
import com.ox.ioController.InputController;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;
import org.controlsfx.control.spreadsheet.GridBase;


public class CreateContent {
    private static int boardButtonNumber;
    private static StackPane rootMenuScene = new StackPane();
    private static StackPane rootGameScene = new StackPane();

    private static Scene menuScene = new Scene(rootMenuScene, 300, 250);
    private static Scene gameScene = new Scene(rootGameScene, 300, 250);


    public static void showBoard(Stage stage) {
        GridPane boardGrid = new GridPane();
        rootGameScene.getChildren().add(boardGrid);

        for (int xi = 0; xi < Rules.getBoardSizeX(); xi++) {
            for (int yi = 0; yi < Rules.getBoardSizeY(); yi++) {
                Button btn = new Button(Character.toString(Rules.getBoard()[xi][yi]));
                btn.setMinSize(50,50);
                btn.setId(xi+1 + Integer.toString(yi+1));
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //Button btn = (Button) event.getTarget();
                        btn.setText(OxRunner.getWhoseMove().getPlayerSymbol().toString());
                        Rules.addMoveToBoard(btn.getId(), OxRunner.getWhoseMove());
                    }
                });
                boardGrid.add(btn, xi, yi);
            }
        }
        stage.setScene(gameScene);
        stage.show();
    }

    public static void showMenu(Stage stage) {
        VBox menuGrid = new VBox(8);
        menuGrid.setAlignment(Pos.CENTER);
        rootMenuScene.getChildren().add(menuGrid);

        Label headerLb = new Label("OX");
        headerLb.setMinSize(100,10);
        headerLb.setAlignment(Pos.CENTER);

        Button resumeBtn = new Button("Resume");
        resumeBtn.setMinSize(100,10);
        resumeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmChoice(stage, handler -> System.out.println("fsdfgsdgsd"));
            }
        });

        Button newGameBtn = new Button("Start New Game");
        newGameBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmChoice(stage, handler -> showPreGameScreen(stage));
            }
        });

        Button statisticsBtn = new Button("Statistics");
        statisticsBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //stats
            }
        });

        Button helpBtn = new Button("Help");
        helpBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Help
            }
        });

        Button endGameBtn = new Button("Exit");
        endGameBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //exit
            }
        });

        menuGrid.getChildren().addAll(headerLb, resumeBtn, newGameBtn, statisticsBtn, helpBtn, endGameBtn);

        stage.setScene(menuScene);
        stage.show();
    }



    public static void confirmChoice(Stage stage, EventHandler<ActionEvent> yes) {
        StackPane rootConfirmationScene = new StackPane();
        Scene confirmationScene = new Scene(rootConfirmationScene, 300, 250);

        HBox hBox = new HBox(80);
        VBox vBox = new VBox(30);

        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);

        Label youSureLb = new Label("Are you sure");
        youSureLb.setAlignment(Pos.CENTER);

        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(yes);
        noBtn.setOnAction(event -> showMenu(stage));

        vBox.getChildren().addAll(youSureLb, hBox);
        hBox.getChildren().addAll(yesBtn, noBtn);

        rootConfirmationScene.getChildren().add(vBox);

        stage.setScene(confirmationScene);
        stage.show();
    }

    public static void showPreGameScreen(Stage stage) {

        Label gameRulesLb = new Label("Game Rules");
        Label sizeXLb = new Label("X Size");
        Label sizeYLb = new Label("Y Size");
        Label strikeLb = new Label("In Row To Win");
        Label p1Lb = new Label("First Player");
        Label p2Lb = new Label("Second Player");
        Label nameLb = new Label("Name");
        Label symbolLb = new Label("Symbol") ;
        Label computerPlayerLb = new Label("Play Against PC");

        TextField nameTF = new TextField("Marco");
        TextField symbolTF = new TextField(" ");
        TextField sizeXTF = new TextField("3");
        TextField sizeYTF = new TextField("3");
        TextField strikeTF = new TextField("3");

        CheckBox computerPlayerCheckBox = new CheckBox();
        Button acceptBtn = new Button("Start!");


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(gameRulesLb, 0, 0);
        gridPane.add(sizeXLb, 0, 1);
        gridPane.add(sizeYLb, 1, 1);
        gridPane.add(strikeLb, 2, 1);

        gridPane.add(sizeXTF, 0, 2);
        gridPane.add(sizeYTF, 1, 2);
        gridPane.add(strikeTF, 2, 2);

        gridPane.add(p1Lb, 0, 3);
        gridPane.add(nameLb, 0, 4);
        gridPane.add(symbolLb, 1, 4);
        gridPane.add(nameTF, 0, 5);
        gridPane.add(symbolTF, 1, 5);

        gridPane.add(p2Lb, 0, 6);
        gridPane.add(computerPlayerLb, 0, 7);
        gridPane.add(computerPlayerCheckBox, 1, 7);
        gridPane.add(nameLb, 0, 8);
        gridPane.add(symbolLb, 1, 8);
        gridPane.add(nameTF, 0, 9);
        gridPane.add(symbolTF, 1, 9);

        gridPane.add(acceptBtn, 0, 10);

        StackPane rootPreGamePane = new StackPane();
        Scene preGameScene = new Scene(rootPreGamePane, 500, 500);

        rootPreGamePane.getChildren().add(gridPane);
        stage.setScene(preGameScene);
        stage.show();
    }
}
