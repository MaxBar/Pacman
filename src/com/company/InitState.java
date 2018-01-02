package com.company;
import com.company.States.GameEngine;
import com.company.States.GameState;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class InitState extends GameState {
    private static Terminal terminal;
    private static InitState initState = null;
    
    
    protected InitState() {
    
    }
    
    public static InitState getInstance() {
        if(initState == null) {
            initState = new InitState();
        }
        return initState;
    }
    
    @Override
    public void init() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
    }
    
    @Override
    public void handleEvents(GameEngine game) {
    
    }
    
    @Override
    public void update(GameEngine game) throws IOException {
        game.popState();
        game.pushState(MenuState.getInstance());
    }
    
    @Override
    public void draw(GameEngine game) throws IOException {
    
    }
    
    public static Terminal getTerminal() throws IOException {
        if(terminal == null) {
            terminal = new DefaultTerminalFactory().createTerminal();
        }
        return terminal;
    }
}
