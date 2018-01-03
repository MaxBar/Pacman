package com.company;

import com.company.States.GameEngine;
import com.company.States.GameState;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class PlayState extends GameState {
    private static PlayState playState = null;

    @Override
    public void init() throws IOException{
        
    }
    @Override
    public void handleEvents(GameEngine game){

    }
    @Override
    public void update(GameEngine game) throws IOException {

    }
    @Override
    public void draw(GameEngine game) throws IOException{
        Board.getTerminal().flush();
    }
    protected PlayState(){

    }
    public static PlayState getInstance(){
        if(playState == null){
            playState = new PlayState();
        }
        return playState;
    }

}