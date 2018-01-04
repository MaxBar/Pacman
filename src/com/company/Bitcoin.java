package com.company;

import com.company.Entities.IEntity;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;
import java.util.Random;

public class Bitcoin implements IEntity {
    int x;
    int y;
    
    Bitcoin bitcoin;
    int bitcoinArray[];
    Random random;
    char cc;
    
    public Bitcoin() throws IOException {
        init();
    }
    
    public Bitcoin(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int getX() {
        return x;
    }
    
    @Override
    public void setX(int x) {
    
    }
    
    @Override
    public int getY() {
        return y;
    }
    
    @Override
    public void setY(int y) {
    
    }
    
    public void init() throws IOException {
        random = new Random();
        do {
            x = (int) Math.floor(random.nextInt(Board.getTerminal().getTerminalSize().getColumns()) + 1);
            y = (int) Math.floor(random.nextInt(Board.getTerminal().getTerminalSize().getRows()) + 1);
        
            TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x ,y);
            cc = c.getCharacter();
        
        } while(cc != ' ');
    }
    
    public void update() throws IOException {
        Board.getTerminal().newTextGraphics().putString(x, y, "$");
    }
}
