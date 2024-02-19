package com.ox.userInterface;

import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CreateContent {
    private static final StackPane rootMenuScene = new StackPane();
    private static final StackPane rootGameScene = new StackPane();
    private static final StackPane rootPreGamePane = new StackPane();

    private static final Scene menuScene = new Scene(rootMenuScene, 300, 250);
    private static final Scene gameScene = new Scene(rootGameScene, 300, 250);
    private static final Scene preGameScene = new Scene(rootPreGamePane, 300, 250);



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
                confirmChoice(stage, handler -> System.out.println("fsdfgsdgsd"));
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
        Label p1NameLb = new Label("Name");
        Label p1SymbolLb = new Label("Symbol") ;
        Label p2NameLb = new Label("Name");
        Label p2SymbolLb = new Label("Symbol") ;

        TextField p1NameTF = new TextField("Marco");
        TextField p2NameTF = new TextField("Polo");
        TextField p1SymbolTF = new TextField("X");
        TextField p2SymbolTF = new TextField("O");
        TextField sizeXTF = new TextField("3");
        TextField sizeYTF = new TextField("3");
        TextField strikeTF = new TextField("3");

        CheckBox computerPlayerCheckBox = new CheckBox("Play Against PC");
        Button acceptBtn = new Button("Start!");
        Separator separator1 = new Separator();
        Separator separator2 = new Separator();
        Separator separator3 = new Separator();




        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(0);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(gameRulesLb, 0, 0);
        gridPane.add(sizeXLb, 0, 1);
        gridPane.add(sizeYLb, 1, 1);
        gridPane.add(strikeLb, 2, 1);

        gridPane.add(sizeXTF, 0, 2);
        gridPane.add(sizeYTF, 1, 2);
        gridPane.add(strikeTF, 2, 2);

        gridPane.add(separator1, 0,3, 3, 1);

        gridPane.add(p1Lb, 0, 4);
        gridPane.add(p1NameLb, 0, 5);
        gridPane.add(p1SymbolLb, 1, 5);
        gridPane.add(p1NameTF, 0, 6);
        gridPane.add(p1SymbolTF, 1, 6);
        gridPane.add(separator2, 0,7, 3, 1);

        gridPane.add(p2Lb, 0, 8);
        gridPane.add(computerPlayerCheckBox, 2, 8);
        gridPane.add(p2NameLb, 0, 9);
        gridPane.add(p2SymbolLb, 1, 9);
        gridPane.add(p2NameTF, 0, 10);
        gridPane.add(p2SymbolTF, 1, 10);
        gridPane.add(separator3, 0,11, 3, 1);

        gridPane.add(acceptBtn, 0, 12, 3, 1);


        gameRulesLb.setFont(Font.font("Arial", 15));
        p1Lb.setFont(Font.font("Arial", 15));
        p2Lb.setFont(Font.font("Arial", 15));

        GridPane.setMargin(gameRulesLb, new Insets(10, 10, 10, 0));
        GridPane.setMargin(p1Lb, new Insets(0, 0, 5, 0));
        GridPane.setMargin(p2Lb, new Insets(0, 0, 5, 0));
        GridPane.setMargin(computerPlayerCheckBox, new Insets(0, 0, 0, 0));
        GridPane.setMargin(acceptBtn, new Insets(10, 0, 10, 0));
        GridPane.setHalignment(acceptBtn, HPos.CENTER);

        GridPane.setMargin(separator1, new Insets(20, 0, 20, 0));
        GridPane.setMargin(separator2, new Insets(20, 0, 20, 0));
        GridPane.setMargin(separator3, new Insets(20, 0, 20, 0));

        GridPane.setHalignment(sizeXLb, HPos.CENTER);
        GridPane.setHalignment(sizeXTF, HPos.CENTER);
        sizeXLb.setMaxWidth(50);
        sizeXLb.setAlignment(Pos.CENTER);
        sizeXTF.maxWidthProperty().bind(sizeXLb.maxWidthProperty());
        sizeXTF.setAlignment(Pos.CENTER);

        GridPane.setHalignment(sizeYLb, HPos.CENTER);
        GridPane.setHalignment(sizeYTF, HPos.CENTER);
        sizeYLb.setMaxWidth(50);
        sizeYLb.setAlignment(Pos.CENTER);
        sizeYTF.maxWidthProperty().bind(sizeXLb.maxWidthProperty());
        sizeYTF.setAlignment(Pos.CENTER);

        GridPane.setHalignment(computerPlayerCheckBox, HPos.RIGHT);
        GridPane.setValignment(computerPlayerCheckBox, VPos.BOTTOM);

        GridPane.setHalignment(strikeLb, HPos.CENTER);
        GridPane.setHalignment(strikeTF, HPos.CENTER);
        strikeLb.setMaxWidth(100);
        strikeLb.setAlignment(Pos.CENTER);
        strikeTF.maxWidthProperty().bind(sizeXLb.maxWidthProperty());
        strikeTF.setAlignment(Pos.CENTER);

        acceptBtn.setPrefSize(150, 50);

        rootPreGamePane.getChildren().add(gridPane);
        stage.setScene(preGameScene);
        stage.show();
    }
}
