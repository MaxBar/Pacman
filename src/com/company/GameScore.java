package com.company;

import com.company.Entities.PlayerHealth;

import java.io.IOException;

public class GameScore {
    private static int points = 0;

    public GameScore() throws IOException {
        points = 0;
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
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 6, (Board.getTerminal().getTerminalSize().getRows()) - 44, "Points:" + points);
    }
}


