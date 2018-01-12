package com.company.Entities;

import com.company.Board;
import java.io.IOException;

public class PlayerHealth {
    private static int health = 3;

    public PlayerHealth() throws IOException {
        health = 3;
    }

    public static void addHealth() throws IOException {
        health = health + 1;
    }

    public static void removeHealth() throws IOException {
        health = health - 1;

    }

    public static int getHealth () {
        return health;
    }

    public static void setHealth () {
        health = 3;
    }

    public static void displayHealth() throws IOException {
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) + 64, (Board.getTerminal().getTerminalSize().getRows()) - 44, "Health:" + health);
    }
}
