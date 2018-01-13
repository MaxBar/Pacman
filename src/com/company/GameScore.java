package com.company;

import com.company.Entities.PlayerHealth;

import java.io.IOException;
import java.io.Serializable;

public class GameScore implements Serializable{
    private static int points = 0;
    private String name;     //Nytt

    public GameScore(String name, int points) throws IOException {
        this.points = points;
        this.name = name;     //Nytt
    }

    public static void addPlayerPoint() throws IOException {
        points = points + 100;

        if ((points == 500) || (points == 750) || (points == 1000)){
            PlayerHealth.addHealth();
        }
    }
    public static void removePoint() throws IOException {
        points = points - 50;
    }

    public static void setGameScore () {
        points = 0;
    }

    public static void writePoints() throws IOException {
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 6, 1, "Points:" + points);
    }

    public int getGameScore() {     //Nytt
        return points;
    }

    public String getName() {     //Nytt
        return name;
    }

}


