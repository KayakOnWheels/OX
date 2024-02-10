package com.ox.actors;

import com.ox.IOController.InputController;
import com.ox.logic.OxRunner;

import static com.ox.logic.Rules.addMoveToBoard;
import static com.ox.logic.Rules.validateMove;

public class HumanPlayer extends Player{

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        String input = InputController.getInput();
        try {
            input = validateMove(input);
        } catch(Exception e) {
            System.out.println("Bad command, enter correct one!");
            makeMove();
        }
        if(input.equals("m")) {
            InputController.enterMenu();
        } else {
            addMoveToBoard(input, this);
        }
    }
}
