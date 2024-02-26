package com.ox.userInterface;

import com.ox.actors.ComputerPlayer;
import com.ox.actors.HumanPlayer;
import com.ox.logic.OxRunner;
import com.ox.logic.Rules;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static com.ox.userInterface.CreateContent.*;
import static com.ox.userInterface.ShowBoardController.showBoard;
import static com.ox.userInterface.ShowMenuController.showMenu;

public class ShowPreGameScreenController {

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
        Button returnBtn = new Button("Menu");
        Separator separator1 = new Separator();
        Separator separator2 = new Separator();
        Separator separator3 = new Separator();

        acceptBtn.setOnAction(event -> {
            OxRunner.setPlayer1(new HumanPlayer(p1NameTF.getCharacters().toString()));
            OxRunner.getPlayer1().setPlayerSymbol(p1SymbolTF.getCharacters().charAt(0));

            if(computerPlayerCheckBox.isSelected()) {
                OxRunner.setPlayer2(new ComputerPlayer(p2NameTF.getCharacters().toString()));
                OxRunner.getPlayer2().setPlayerSymbol(p2SymbolTF.getCharacters().charAt(0));
            } else {
                OxRunner.setPlayer2(new HumanPlayer(p2NameTF.getCharacters().toString()));
                OxRunner.getPlayer2().setPlayerSymbol(p2SymbolTF.getCharacters().charAt(0));
            }
            OxRunner.setWhoseMove(OxRunner.getPlayer1());

            Rules.setBoardSizeX(Integer.parseInt(sizeXTF.getCharacters().toString()));
            Rules.setBoardSizeY(Integer.parseInt(sizeYTF.getCharacters().toString()));
            Rules.setInRowToWin(Integer.parseInt(strikeTF.getCharacters().toString()));

            Rules.generateBoard(' ');
            Rules.setGameInProgress(true);
            showBoard(stage);
            stage.setScene(gameScene);
            stage.show();
        });

        returnBtn.setOnAction(event -> showMenu(stage));

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
        gridPane.add(returnBtn, 0, 13, 3, 1);


        gameRulesLb.setFont(Font.font("Arial", 15));
        p1Lb.setFont(Font.font("Arial", 15));
        p2Lb.setFont(Font.font("Arial", 15));

        GridPane.setMargin(gameRulesLb, new Insets(10, 10, 10, 0));
        GridPane.setMargin(p1Lb, new Insets(0, 0, 5, 0));
        GridPane.setMargin(p2Lb, new Insets(0, 0, 5, 0));
        GridPane.setMargin(computerPlayerCheckBox, new Insets(0, 0, 0, 0));
        GridPane.setMargin(acceptBtn, new Insets(10, 0, 10, 0));
        GridPane.setHalignment(acceptBtn, HPos.CENTER);
        GridPane.setHalignment(returnBtn, HPos.CENTER);

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
}
