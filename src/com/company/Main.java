package com.company;

import com.company.States.GameEngine;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws InterruptedException, IOException {
        GameEngine game = new GameEngine();
    
        game.init();
        
        game.changeState(InitState.getInstance());
    
        while(game.running()) {
            game.handleEvents();
            game.update();
            game.draw();
        }
    }
}
