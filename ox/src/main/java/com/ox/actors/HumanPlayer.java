package com.ox.actors;

import com.ox.IOController.InputController;

import static com.ox.logic.Rules.addMoveToBoard;
import static com.ox.logic.Rules.validateInput;

public class HumanPlayer extends Player{

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        String input = InputController.getInput();
        try {
            validateInput(input);
        } catch(Exception e) {
            System.out.println("Bad command, enter correct one!");
            makeMove();
        }
        if(input.equals("m")) {
            InputController.enterMenu();
        } else {
            try {
                addMoveToBoard(input, this);
            } catch(Exception e) {
                System.out.println("This field is occupied! Choose another.");
                makeMove();
            }
        }
    }
}
