package com.company.Entities;

import com.company.Bitcoin;
import com.company.Board;
import com.company.Collision;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;

public class Player implements IEntity {
    private int x;
    private int y;
    private Collision collision;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        collision = new Collision();
    }
    
    public void movement(int x, int y, Bitcoin bitcoin) throws IOException {
        int oldx = this.x;
        int oldy = this.y;
        this.x = x;
        this.y = y;
        
        if(collision.isOutofBounds(this)) {
            this.x = oldx;
            this.y = oldy;
        }
        if (collision.isBitcoinCollisionDetected(this, bitcoin)){
            bitcoin.newBitcoin();
        }
        /*TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc == 'X') {
            this.x = oldx;
            this.y = oldy;
        }*/
    }
    
    public void update() throws IOException {
        Board.getTerminal().newTextGraphics().putString(x, y, "\u263A");
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
}