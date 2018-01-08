package com.company.GameModes;

import java.io.IOException;

import com.company.Board;
import com.company.States.*;
import com.googlecode.lanterna.input.KeyStroke;

public class MenuState extends GameState {

    private KeyStroke key;
    private static MenuState menuState = null;

    @Override
    public void init() throws IOException {
        Board.getTerminal().clearScreen();
        Board.getTerminal().enterPrivateMode();
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 4, (Board.getTerminal().getTerminalSize().getRows() / 2) - 3, "Menu");
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 4, (Board.getTerminal().getTerminalSize().getRows() / 2) - 2, "Play");
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 4, (Board.getTerminal().getTerminalSize().getRows() / 2) - 1, "Quit");
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
        Board.getTerminal().flush();
    }

    protected MenuState() {

    }

    public static MenuState getInstance() {
        if (menuState == null) {
            menuState = new MenuState();
        }
        return menuState;
    }
}
