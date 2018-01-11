package com.company.States;

import com.company.Board;
import com.company.Collision;
import com.company.GameModes.MenuState;

import java.io.IOException;

public class PlayerHealth {
    private GameState gameOver;
    private static int health = 3;

    public PlayerHealth() throws IOException {
        health = 3;
    }

    public static void addHealth() throws IOException {
        health = health + 1;
    }

    public static void removeHealth() throws IOException {
        health = health - 1;
        if (health == 0) {
            //gameOver.changeState(MenuState.getInstance());
        }
    }

    public static void displayHealth() throws IOException {
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) + 40, (Board.getTerminal().getTerminalSize().getRows()) - 29, "Health:" + health);
    }
}
