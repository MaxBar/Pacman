package com.company;

import com.company.GameModes.MenuState;
import com.company.States.GameEngine;
import com.company.States.GameState;

import java.io.IOException;

public class GameOverState extends GameState {

    @Override
    public void init() throws IOException {
        Board.getTerminal().clearScreen();
        Board.getTerminal().enterPrivateMode();
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 9, (Board.getTerminal().getTerminalSize().getRows() / 2) - 1, "GAME OVER");
    }
<<<<<<< HEAD
    public void gameOver(GameEngine game) throws IOException {
=======

    @Override
    public void handleEvents(GameEngine game) throws IOException {

    }

    @Override
    public void update(GameEngine game) throws IOException {

    }

    @Override
    public void draw(GameEngine game) throws IOException {

    }

    public void GameOver(GameEngine game) throws IOException {
>>>>>>> 8307b70e45630508daad562ae9383c476b405c68
        game.changeState(MenuState.getInstance());
    }
}