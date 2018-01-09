package com.company.Entities;

import com.company.Board;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class FastEnemy extends Enemy implements IEntity {
    private char string;

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

    public FastEnemy(int x, int y, TextColor color, char string) {
        super(x, y, color, string);
        this.string = string;
    }

    public void movement(Player player) throws IOException {
        int oldx = getX();
        int oldy = getY();
        if (Math.random() < 0.6) {
            if (player.getX() < this.getX()) {
                setX(getX() - 1);
                if (player.getY() < getY()) {
                    setY(getY() - 1);
                }
                else if (player.getY() > getY()) {
                    setY(getY() + 1);
                }
            }
            else if (player.getX() > this.getX()) {
                setX(getX() + 1);
                if (player.getY() < getY()) {
                    setY(getY() - 1);
                }
                else if (player.getY() > getY()) {
                    setY(getY() + 1);
                }
            }
            else if (player.getX() == getX()) {
                if (player.getY() < getY()) {
                    setY(getY() - 1);
                }
                else if (player.getY() > getY()) {
                    setY(getY() + 1);
                }
            }
        }
        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(super.x, super.y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc == string) {
            setX(oldx);
            setY(oldy);
        }
        c = Board.getTerminal().newTextGraphics().getCharacter(super.x, super.y);
        cc = c.getCharacter();
        System.out.println(cc);
        if (cc == Wall.getChar()) {
            super.x = oldx;
            super.y = oldy;
        }
    }

}
