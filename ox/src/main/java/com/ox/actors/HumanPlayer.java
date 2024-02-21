package com.ox.actors;

import com.ox.MoveToBoardException;
import com.ox.ioController.InputController;
import com.ox.ioController.OutputController;

import static com.ox.logic.Rules.addMoveToBoard;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

/*    @Override
    public void makeMove() {
        String input = InputController.getInputInGame();
        if ("m".equals(input)) {
            InputController.enterMenu();
        } else {
            try {
                addMoveToBoard(input, this);
            } catch (MoveToBoardException e) {
                OutputController.thisFieldIsOccupied();
                makeMove();
            }
        }
    }*/

    @Override
    public String makeMove() {
        String input = InputController.getInputInGame();
        if ("m".equals(input)) {
            InputController.enterMenu();
        } else {
            try {
                addMoveToBoard(input, this);
            } catch (MoveToBoardException e) {
                OutputController.thisFieldIsOccupied();
                makeMove();
            }
        }
        return null;
    }
}
