package com.company;

import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class Enemy implements IEntity {
    private int x;
    private int y;

    public Enemy(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void movement(Player player) throws IOException {
        int oldx = x;
        int oldy = y;
        if(Math.random() < 0.3) {
            if (player.getX() < this.x) {
                x -= 1;
                if (player.getY() < y) {
                    y -= 1;
                } else if (player.getY() > y) {
                    y += 1;
                }
            } else if (player.getX() > this.x) {
                x += 1;
                if (player.getY() < y) {
                    y -= 1;
                } else if (player.getY() > y) {
                    y += 1;
                }
            } else if (player.getX() == x) {
                if (player.getY() < y) {
                    y -= 1;
                } else if (player.getY() > y) {
                    y += 1;
                }
            }
    
            if (player.getX() == x && player.getY() == y) {
                System.out.println("hit");
            }
        }
            TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
            char cc = c.getCharacter();
            System.out.println(cc);
            if (cc != 'E') {
                //Board.getTerminal().newTextGraphics().putString(x, y, "E");
            } else {
                x = oldx;
                y = oldy;
                //Board.getTerminal().newTextGraphics().putString(oldx, oldy, "E");
            }
    }
    
    @Override
    public void movement() throws IOException {
    
    }
    
    public void update() throws IOException {
        Board.getTerminal().newTextGraphics().putString(x, y, "E");
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
