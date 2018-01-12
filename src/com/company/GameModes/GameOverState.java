package com.company.GameModes;

import com.company.Board;
import com.company.States.GameEngine;
import com.company.States.GameState;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class GameOverState extends GameState {
    private KeyStroke key;
    private static GameOverState gameOverState = null;

    @Override
    public void init() throws IOException {
        Board.getTerminal().enterPrivateMode();
        Board.getTerminal().clearScreen();
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 9, (Board.getTerminal().getTerminalSize().getRows() / 2) - 1, "GAME OVER");
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 20, (Board.getTerminal().getTerminalSize().getRows() / 2) + 1, "Space for menu Escape to quit");
    }

    @Override
    public void handleEvents(GameEngine game) throws IOException {
        key = Board.getTerminal().readInput();
        switch (key.getKeyType()) {
            case Escape:
                game.quit();
                break;
            case EOF:
                game.quit();
                break;
            case Character:
                switch (key.getCharacter()) {
                    case ' ':
                        Board.getTerminal().clearScreen();
                        game.changeState(MenuState.getInstance());
                        break;
                    case 'q':
                        game.quit();
                        break;
                }
        }
    }

    @Override
    public void update(GameEngine game) throws IOException {

    }

    @Override
    public void draw(GameEngine game) throws IOException {
        Board.getTerminal().flush();
    }

    public void GameOver(GameEngine game) throws IOException {
        game.changeState(MenuState.getInstance());
    }
    public static GameOverState getInstance() {
        if (gameOverState == null) {
            gameOverState = new GameOverState();
        }
        return gameOverState;
    }
}