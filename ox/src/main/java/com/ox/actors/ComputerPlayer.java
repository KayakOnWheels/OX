package com.ox.actors;

import com.ox.logic.Rules;
import javafx.css.Rule;

import java.util.Random;

public class ComputerPlayer extends Player{

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public String makeMove() {
        String rndField = Rules.getRandomField();
        try {
             Rules.addMoveToBoard(rndField, this);
             return rndField;
        } catch(Exception e) {
            return makeMove();
        }
    }

}
