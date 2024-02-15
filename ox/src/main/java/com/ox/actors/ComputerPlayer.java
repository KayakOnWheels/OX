package com.ox.actors;

import com.ox.logic.Rules;

import java.util.Random;

public class ComputerPlayer extends Player{

    private final Random random = new Random();
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        int xSize = Rules.getBoardSizeX();
        int ySize = Rules.getBoardSizeY();
        String move = (random.nextInt(xSize-1)+1)
                + String.valueOf(random.nextInt(ySize-1)+1);

        try {
            Rules.addMoveToBoard(move, this);
        } catch(Exception e) {
            makeMove();
        }

    }
}
