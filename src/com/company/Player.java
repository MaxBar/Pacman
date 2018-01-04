package com.company;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Player implements IEntity {
    private int x;
    private int y;

    public Player(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void movement(int x, int y) throws IOException {
        int oldx = this.x;
        int oldy = this.y;
        this.x = x;
        this.y = y;
    
        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc != 'X') {
            //Board.getTerminal().newTextGraphics().putString(x, y, "P");
            //System.out.println("no collision");
        } else {
            this.x = oldx;
            this.y = oldy;
            //Board.getTerminal().newTextGraphics().putString(oldx, oldy, "P");
            //System.out.println("BAAMM!!");
        }
        //Board.getTerminal().newTextGraphics().putString(x, y, "P");
    }
    
    public void update() throws IOException {
        Board.getTerminal().newTextGraphics().putString(x, y, "P");
    }
    
    @Override
    public void movement() throws IOException {

    }

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }

}
