package com.company;

import java.io.IOException;

import static com.company.InitState.getTerminal;

public class MenuState extends GameState {
    private static MenuState menuState = null;
    
    protected MenuState() {
    
    }
    
    public static MenuState getInstance() {
        if(menuState == null) {
            menuState = new MenuState();
        }
        return menuState;
    }
    
    public void writeMenu() throws IOException {
        getTerminal().enterPrivateMode();
        getTerminal().setCursorPosition(10,10);
        getTerminal().putCharacter('M');
        getTerminal().putCharacter('e');
        getTerminal().putCharacter('n');
        getTerminal().putCharacter('u');
        getTerminal().setCursorPosition(10, 11);
        getTerminal().putCharacter('P');
        getTerminal().putCharacter('l');
        getTerminal().putCharacter('a');
        getTerminal().putCharacter('y');
        getTerminal().setCursorPosition(10, 12);
        getTerminal().putCharacter('Q');
        getTerminal().putCharacter('u');
        getTerminal().putCharacter('i');
        getTerminal().putCharacter('t');
        getTerminal().flush();
    }
}
