package com.ox.actors;

import com.ox.ioController.InputController;

import static com.ox.logic.Rules.addMoveToBoard;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        String input = InputController.getInputInGame();
        if ("m".equals(input)) {
            InputController.enterMenu();
        } else {
            try {
                addMoveToBoard(input, this);
            } catch (Exception e) {
                System.out.println("This field is occupied! Choose another.");
                makeMove();
            }
        }
    }
}
