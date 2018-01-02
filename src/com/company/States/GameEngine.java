package com.company.States;

import com.company.MenuState;

import java.util.ArrayList;

public class GameEngine {
    private ArrayList<GameState> states;
    private boolean running;
    
    public void init() {
        states = new ArrayList<>();
        running = true;
        System.out.printf("GameEngine init\n");
    }
    
    public void changeState(MenuState state) {
        while(!states.isEmpty()) {
            states.clear();
        }
        
        states.add(state);
        states.get(states.size() - 1).init();
        
        System.out.printf("GameEngine changestate");
    }
    
    public void pushState(GameState state) {
        states.add(state);
        states.get(states.size() - 1).init();
    }
    
    public void popState() {
        if(!states.isEmpty()) {
            states.clear();
        }
    }
    
    public void handleEvents() {
        states.get(states.size() - 1).handleEvents(this);
    }
    
    public void update() {
        states.get(states.size() - 1).update(this);
    }
    
    public void draw() {
        states.get(states.size() - 1).draw(this);
    }
    
    public boolean running() {
        return running;
    }
    
    public void quit() {
        running = false;
    }
    
}
