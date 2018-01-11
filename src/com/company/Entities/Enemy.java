package com.company.Entities;

import com.company.Bitcoin;
import com.company.Board;
import com.company.Collision;
import com.company.States.PlayerHealth;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

import java.awt.*;
import java.io.IOException;

public class Enemy implements IEntity {
    protected int x;
    protected int y;
    protected char string;
    protected TextColor color;
    private Collision collision;


    public Enemy(int x, int y, TextColor color, char string) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.string = string;
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
        if(collision.isEnemyCollisionDetected(this, player)) {
            PlayerHealth.removeHealth();
            System.out.println("Hit player");
        }

        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc == string) {
            x = oldx;
            y = oldy;
        }
        c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        cc = c.getCharacter();
        System.out.println(cc);
        if (cc == Wall.getChar()) {
            x = oldx;
            y = oldy;
        }
    }
    
    public void movement(Bitcoin bitcoin) throws IOException {}

    public void update() throws IOException {
        Board.getTerminal().setForegroundColor(color);
        Board.getTerminal().setCursorPosition(x,y);
        Board.getTerminal().putCharacter(string);
        Board.getTerminal().setForegroundColor(TextColor.ANSI.DEFAULT);
    }
    
    public int getX() { return x; }
    
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
