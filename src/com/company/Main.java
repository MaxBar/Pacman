package com.company;

import com.company.GameModes.InitState;
import com.company.States.GameEngine;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws InterruptedException, IOException {
        GameEngine game = new GameEngine();
        
        /*long last_time = System.nanoTime();
        int deltaTime = 0;
        int fps = 1000/60;
        double elapsedTime = 0;*/
        /*double time = System.nanoTime() / 1000000000;
        double deltaTime = 0;
        double x = 1;
        double y = 20;
        double fps = x/y;
        double now = 0;*/
        
        game.init();
        
        game.changeState(InitState.getInstance());
        
        while (game.running()) {
            //long time = System.nanoTime();
            //deltaTime = (int)((time - last_time) / 1000000) + deltaTime;
            //last_time = time;
            //System.out.println(deltaTime);
            //System.out.println(deltaTime - fps);
            /*now = System.nanoTime() / 1000000000;
            deltaTime = deltaTime + (now - time);
            time = now;
            System.out.println(deltaTime);*/
            System.out.println(DeltaTime.getFPS());
            if(DeltaTime.getDeltaTime() > DeltaTime.getFPS()) {
                //System.out.println(DeltaTime.getDeltaTime());
                //Board.getTerminal().newTextGraphics().putString(20, 20, Double.toString(elapsedTime));
                game.handleEvents();
                game.update();
                game.draw();
                //elapsedTime += deltaTime;
                //Thread.sleep(deltaTime - fps);
                DeltaTime.setDeltaTime(0);
                //deltaTime = 0;
                //Board.getTerminal().flush();
            }
        }
        Board.getTerminal().exitPrivateMode();
    }
}
