package com.company.Entities;

import com.company.Board;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;

public class FastEnemy extends Enemy implements IEntity {
    private int x = 0;
    private int y = 0;
    private String string;

    @Override
    public int getX(){
        return super.getX();
    }
    @Override
    public void setX(int x){
        super.setX(x);
    }
    @Override
    public int getY(){
        return super.getY();
    }
    @Override
    public void setY(int y){
        super.setY(y);
    }

    public FastEnemy(int x, int y) {
        super(x , y);
        string = "\u2622";
    }

    public void movement(Player player) throws IOException {
        int oldx = x;
        int oldy = y;
        if (Math.random() < 0.5) {
            if (player.getX() < this.x) {
                x -= 1;
                if (player.getY() < y) {
                    y -= 1;
                }
                else if (player.getY() > y) {
                    y += 1;
                }
            }
            else if (player.getX() > this.x) {
                x += 1;
                if (player.getY() < y) {
                    y -= 1;
                }
                else if (player.getY() > y) {
                    y += 1;
                }
            }
            else if (player.getX() == x) {
                if (player.getY() < y) {
                    y -= 1;
                }
                else if (player.getY() > y) {
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

}
