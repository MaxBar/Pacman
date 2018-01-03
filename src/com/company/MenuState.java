package com.company;

import java.io.IOException;
import com.company.States.*;

public class MenuState extends GameState {
    private static MenuState menuState = null;

    @Override
    public void init() throws IOException {
        Board.getTerminal().enterPrivateMode();
        Board.getTerminal().setCursorPosition(10,10);
        Board.getTerminal().putCharacter('M');
        Board.getTerminal().putCharacter('e');
        Board.getTerminal().putCharacter('n');
        Board.getTerminal().putCharacter('u');
        Board.getTerminal().setCursorPosition(10, 11);
        Board.getTerminal().putCharacter('P');
        Board.getTerminal().putCharacter('l');
        Board.getTerminal().putCharacter('a');
        Board.getTerminal().putCharacter('y');
        Board.getTerminal().setCursorPosition(10, 12);
        Board.getTerminal().putCharacter('Q');
        Board.getTerminal().putCharacter('u');
        Board.getTerminal().putCharacter('i');
        Board.getTerminal().putCharacter('t');
    }

    @Override
    public void handleEvents(GameEngine game) {

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
        if(menuState == null) {
            menuState = new MenuState();
        }
        return menuState;
    }
}
