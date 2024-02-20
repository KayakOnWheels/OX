package com.ox.userInterface;

import com.ox.actors.ComputerPlayer;
import com.ox.actors.HumanPlayer;
import com.ox.actors.Player;
import com.ox.ioController.OutputController;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.css.Rule;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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


public class CreateContent {
    private static final StackPane rootMenuScene = new StackPane();
    private static final StackPane rootGameScene = new StackPane();
    private static final StackPane rootPreGamePane = new StackPane();
    private static StackPane currentRootPane;

    private static final Scene menuScene = new Scene(rootMenuScene, 500, 500);
    private static final Scene gameScene = new Scene(rootGameScene, 500, 500);
    private static final Scene preGameScene = new Scene(rootPreGamePane, 500, 500);

    private static final Image imageback = new Image("file:src\\main\\resources\\static\\backgrounds\\rect3.png");
    private static final Background background = new Background(new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
            BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));



    public static void showBoard(Stage stage) {
        GridPane boardGrid = new GridPane();
        rootGameScene.getChildren().add(boardGrid);
        currentRootPane = rootGameScene;
        rootGameScene.setBackground(background);

        boardGrid.setAlignment(Pos.CENTER);

        for (int xi = 0; xi < Rules.getBoardSizeX(); xi++) {
            for (int yi = 0; yi < Rules.getBoardSizeY(); yi++) {
                Button btn = new Button(Character.toString(Rules.getBoard()[xi][yi]));
                btn.setMinSize(50,50);
                btn.setId(yi+1 + Integer.toString(xi+1));
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //Button btn = (Button) event.getTarget();
                        btn.setText(OxRunner.getWhoseMove().getPlayerSymbol().toString());
                        Rules.addMoveToBoard(btn.getId(), OxRunner.getWhoseMove());
                        if(Rules.gameStatus() == 1 || Rules.gameStatus() == -1) {
                            showGameFinishedBox(stage);
                        }
                        if(OxRunner.getWhoseMove().equals(OxRunner.getPlayer1())) {
                            OxRunner.setWhoseMove(OxRunner.getPlayer2());
                        } else {
                            OxRunner.setWhoseMove(OxRunner.getPlayer1());
                        }
                        OutputController.printGameBoard();
                        System.out.println(OxRunner.getWhoseMove());
                        System.out.println(Rules.gameStatus());
                    }
                });
                boardGrid.add(btn, xi, yi);
            }
        }

        rootGameScene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if(keyCode.equals(KeyCode.ESCAPE)) {
                showMenu(stage);
            }

        });

        stage.setScene(gameScene);
        stage.show();
    }

    public static void showMenu(Stage stage) {
        VBox menuVBox = new VBox(8);
        menuVBox.setAlignment(Pos.CENTER);
        rootMenuScene.getChildren().add(menuVBox);
        currentRootPane = rootMenuScene;
        rootMenuScene.setBackground(background);

        Label headerLb = new Label("OX");
        headerLb.setMinSize(100,10);
        headerLb.setAlignment(Pos.CENTER);

        Button resumeBtn = new Button("Resume");
        resumeBtn.setMinSize(100,10);
        resumeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 confirmChoice(stage, handler -> {
                     currentRootPane.getChildren().clear();
                     if(Rules.isGameInProgress()) {
                         showBoard(stage);
                     } else {
                        showMenu(stage);
                     }
                 });
            }
        });

        Button newGameBtn = new Button("Start New Game");
        newGameBtn.setMinSize(100,10);
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmChoice(stage, handler -> { currentRootPane.getChildren().clear(); showPreGameScreen(stage);});
            }
        });

        Button statisticsBtn = new Button("Statistics");
        statisticsBtn.setMinSize(100,10);
        statisticsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmChoice(stage, handler -> System.out.println("fsdfgsdgsd"));
            }
        });

        Button helpBtn = new Button("Help");
        helpBtn.setMinSize(100,10);
        helpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmChoice(stage, handler -> System.out.println("fsdfgsdgsd"));
            }
        });

        Button endGameBtn = new Button("Exit");
        endGameBtn.setMinSize(100,10);
        endGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirmChoice(stage, handler -> System.out.println("fsdfgsdgsd"));
            }
        });

        menuVBox.getChildren().addAll(headerLb, resumeBtn, newGameBtn, statisticsBtn, helpBtn, endGameBtn);

        stage.setScene(menuScene);
        stage.show();
    }



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

    public static void showPreGameScreen(Stage stage) {
        currentRootPane = rootPreGamePane;
        rootPreGamePane.setBackground(background);

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

        acceptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OxRunner.setPlayer1(new HumanPlayer(p1NameTF.getCharacters().toString()));
                OxRunner.getPlayer1().setPlayerSymbol(p1SymbolTF.getCharacters().charAt(0));

                if(computerPlayerCheckBox.isSelected()) {
                    OxRunner.setPlayer2(new ComputerPlayer(p2NameTF.getCharacters().toString()));
                    OxRunner.getPlayer2().setPlayerSymbol(p1SymbolTF.getCharacters().charAt(0));
                } else {
                    OxRunner.setPlayer2(new HumanPlayer(p2NameTF.getCharacters().toString()));
                    OxRunner.getPlayer2().setPlayerSymbol(p2SymbolTF.getCharacters().charAt(0));
                }
                OxRunner.setWhoseMove(OxRunner.getPlayer1());

                Rules.setBoardSizeX(Integer.parseInt(sizeXTF.getCharacters().toString()));
                Rules.setBoardSizeY(Integer.parseInt(sizeYTF.getCharacters().toString()));
                Rules.setInRowToWin(Integer.parseInt(strikeTF.getCharacters().toString()));

                Rules.generateBoard(' ');
                showBoard(stage);
                stage.setScene(gameScene);
                stage.show();
            }
        });

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

        p1SymbolTF.setPrefWidth(50);
        p1SymbolTF.setAlignment(Pos.CENTER);
        GridPane.setHalignment(p1SymbolLb, HPos.CENTER);
        p2SymbolTF.setPrefWidth(50);
        p2SymbolTF.setAlignment(Pos.CENTER);
        GridPane.setHalignment(p2SymbolLb, HPos.CENTER);

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

    public static void showGameFinishedBox(Stage stage) {
        VBox vBox = new VBox(30);

        vBox.setAlignment(Pos.CENTER);

        vBox.setMaxSize(300, 200);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        Label gameFinishedLb = new Label("Game Finished!");
        gameFinishedLb.setAlignment(Pos.CENTER);
        Label whoWonLb = new Label(OxRunner.getWhoseMove().getName() + " won!");
        Label boardFullLb = new Label("No more fields available");

        Button menuBtn = new Button("Menu");

        menuBtn.setOnAction(event -> { showMenu(stage); currentRootPane.getChildren().remove(vBox); rootGameScene.getChildren().clear();});

        if(Rules.gameStatus() == 1) {
            vBox.getChildren().addAll(gameFinishedLb, whoWonLb, menuBtn);
        } else {
            vBox.getChildren().addAll(gameFinishedLb, boardFullLb, menuBtn);
        }


        currentRootPane.getChildren().add(vBox);
        stage.show();
    }
}
