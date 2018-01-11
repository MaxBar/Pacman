package com.company;

import com.company.GameModes.MenuState;
import com.company.GameModes.PlayState;
import com.company.States.GameEngine;
import com.company.States.GameState;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.Escape;
import static sun.tools.java.Scanner.EOF;

public class GameOverState extends GameState {
    private KeyStroke key;
    private static GameOverState gameOverState = null;

    @Override
    public void init() throws IOException {
        Board.getTerminal().clearScreen();
        Board.getTerminal().enterPrivateMode();
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 9, (Board.getTerminal().getTerminalSize().getRows() / 2) - 1, "GAME OVER");
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
                    case 'p':
                        Board.getTerminal().clearScreen();
                        game.changeState(PlayState.getInstance());
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