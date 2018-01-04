package com.company.States;

import java.io.IOException;

public abstract class GameState {
    public abstract void init() throws IOException;
    
    public abstract void handleEvents(GameEngine game) throws IOException;
    
    public abstract void update(GameEngine game) throws IOException;
    
    public abstract void draw(GameEngine game) throws IOException;
    
    public void changeState(GameEngine game, GameState state) throws IOException {
        game.changeState(state);
    }
    
    protected GameState() {
    }
}
