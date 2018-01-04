package com.company.Entities;

import com.company.Board;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;

public class Enemy implements IEntity {
    private int x;
    private int y;
    private String string;
    
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        string = "E";
    }
    
    public void movement(Player player) throws IOException {
        int oldx = x;
        int oldy = y;
        if (Math.random() < 0.3) {
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
        }
        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc == string.toCharArray()[0]) {
            x = oldx;
            y = oldy;
        }
    }
    
    public void update() throws IOException {
        Board.getTerminal().newTextGraphics().putString(x, y, string);
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
