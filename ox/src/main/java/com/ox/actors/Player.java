package com.ox.actors;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name) && Objects.equals(playerSymbol, player.playerSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, playerSymbol);
    }
}
