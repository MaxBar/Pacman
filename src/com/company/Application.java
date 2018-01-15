package com.company;

import com.company.GameModes.InitState;
import com.company.States.GameEngine;

import java.io.IOException;

public class Application {
    public void run() throws IOException {
        GameEngine game = new GameEngine();

        game.init();

        game.changeState(InitState.getInstance());

        while (game.running()) {

            game.handleEvents();
            game.update();
            game.draw();
        }
        Board.getTerminal().exitPrivateMode();
    }
}
