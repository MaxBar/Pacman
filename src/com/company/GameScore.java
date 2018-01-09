package com.company;

import com.company.Entities.Player;

import java.io.IOException;

public class GameScore {
    private static int points;

    public GameScore throws IOException {

    }

    public GameScore throws IOException {
        points = 0;

    }

    public static void addPlayerPoint(Player point) throws IOException {

        if (Collision.isBitcoinCollisionDetected(this, point)) {
            points++;
        }
    }
    public static void writePoints(Player point) throws IOException {
        addPlayerPoint(point);
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 6, (Board.getTerminal().getTerminalSize().getRows()) - 1, "Points:" + points);
}


