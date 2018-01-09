package com.company;


import java.io.IOException;

public class GameScore {
    private static int points = 0;

    public GameScore() throws IOException {
        points = 0;

    }

    public static void addPlayerPoint() throws IOException {
        points = points + 100;
    }
    public static void removePoint() throws IOException {
        points = points - 50;
    }

    public static void writePoints() throws IOException {
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 6, (Board.getTerminal().getTerminalSize().getRows()) - 1, "Points:" + points);
    }
}


