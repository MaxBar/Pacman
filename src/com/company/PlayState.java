package com.company;

import java.io.IOException;

public class PlayState {
    public static PlayState playState = null;
    
    public void init() throws IOException {
    
    }
    
    public void handleEvents() {
    
    }
    
    public void update() throws IOException {
    
    }
    
    public void draw() throws IOException {
    
    }
    
    protected PlayState() {
    
    }
    
    public static PlayState getInstance() {
        if(playState == null) {
            playState = new PlayState();
        }
        return playState;
    }
}