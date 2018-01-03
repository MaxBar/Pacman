package com.company;
import com.company.States.GameEngine;
import com.company.States.GameState;

import java.io.IOException;

public class InitState extends GameState {
    private static InitState initState = null;
    Board board;
    
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
        board = new Board();
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
}
