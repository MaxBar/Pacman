package com.company.States;

import com.company.Board;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine {
    private ArrayList<GameState> states;
    private boolean running;
    
    // Initialiserar Array och running
    public void init() {
        states = new ArrayList<>();
        running = true;
        System.out.printf("GameEngine init\n");
    }
    
    // Byter state från ett till ett annat och rensar det gamla statet och lägger till det nya
    public void changeState(GameState state) throws IOException{
        while(!states.isEmpty()) {
            states.clear();
        }

        states.add(state);
        states.get(states.size() - 1).init();
        
        System.out.printf("GameEngine changestate");
    }
    
    // Lägger till statet som skickas in i arrayn
    public void pushState(GameState state) throws IOException {
        states.add(state);
        states.get(states.size() - 1).init();
    }
    
    // Tömmer arrayn på states
    public void popState() {
        if(!states.isEmpty()) {
            states.clear();
        }
    }
    
    // Kallar på nuvarande states handleEvents
    public void handleEvents() throws IOException {
        states.get(states.size() - 1).handleEvents(this);
    }
    
    // Kallar på nuvarande states update
    public void update() throws IOException {
        states.get(states.size() - 1).update(this);
    }
    
    // Kallar på nuvarande states draw
    public void draw() throws IOException{
        states.get(states.size() - 1).draw(this);
    }
    
    // Returnerar running
    public boolean running() {
        return running;
    }
    
    // Sätter running till false så spelet avslutas
    public void quit() {
        running = false;
    }
    
}
