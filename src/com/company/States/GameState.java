package com.company.States;
import com.company.MenuState;

public abstract class GameState {
    public abstract void init();
    public abstract void handleEvents(GameEngine game);
    public abstract void update(GameEngine game);
    public abstract void draw(GameEngine game);
    
    public void changeState(GameEngine game, MenuState state) {
        game.changeState(state);
    }
    
    protected GameState() {}
}
