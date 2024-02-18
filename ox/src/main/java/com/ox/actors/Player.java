package com.ox.actors;


public abstract class Player {

    private final String name;
    //private int points = 0;
    private Character playerSymbol= 'x';

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

/*    public int getPoints() {
        return points;
    }*/
    public Character getPlayerSymbol() {
        return playerSymbol;
    }

/*    public void addPoint() {
        points++;
    }*/

    public void setPlayerSymbol(Character playerSymbol) {
        this.playerSymbol = Character.toUpperCase(playerSymbol);
    }


    public abstract void makeMove();
}
