package com.company;

import java.io.IOException;
import com.company.States.*;

public class MenuState extends GameState {
    private static MenuState menuState = null;

    @Override
    public void init() throws IOException {
    }

    @Override
    public void handleEvents(GameEngine game) {

    }

    @Override
    public void update(GameEngine game) throws IOException {
        InitState.getTerminal().enterPrivateMode();
        InitState.getTerminal().setCursorPosition(10,10);
        InitState.getTerminal().putCharacter('M');
        InitState.getTerminal().putCharacter('e');
        InitState.getTerminal().putCharacter('n');
        InitState.getTerminal().putCharacter('u');
        InitState.getTerminal().setCursorPosition(10, 11);
        InitState.getTerminal().putCharacter('P');
        InitState.getTerminal().putCharacter('l');
        InitState.getTerminal().putCharacter('a');
        InitState.getTerminal().putCharacter('y');
        InitState.getTerminal().setCursorPosition(10, 12);
        InitState.getTerminal().putCharacter('Q');
        InitState.getTerminal().putCharacter('u');
        InitState.getTerminal().putCharacter('i');
        InitState.getTerminal().putCharacter('t');
    }

    @Override
    public void draw(GameEngine game) throws IOException {
        InitState.getTerminal().flush();
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
