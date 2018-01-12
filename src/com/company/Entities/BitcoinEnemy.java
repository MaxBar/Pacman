package com.company.Entities;

import com.company.Board;
import com.company.Collision;
import com.company.GameScore;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class BitcoinEnemy extends Enemy implements IEntity {
    private Collision collision;
    private char string;
    private float probabilityOfMoving;

    public BitcoinEnemy(int x, int y, TextColor color, char string) throws IOException {
        super(x, y, color, string, 0);
        collision = new Collision();
        this.string = string;
        probabilityOfMoving = 0.5f;
    }

    public void movement(Bitcoin bitcoin) throws IOException {
        int oldx = getX();
        int oldy = getY();

        if (Math.random() < probabilityOfMoving) {
            if (bitcoin.getX() < getX()) {
                setX(getX() - 1);
                if (bitcoin.getY() < getY()) {
                    setY(getY() - 1);
                } else if (bitcoin.getY() > getY()) {
                    setY(getY() + 1);
                }
            } else if (bitcoin.getX() > getX()) {
                setX(getX() + 1);
                if (bitcoin.getY() < getY()) {
                    setY(getY() - 1);
                } else if (bitcoin.getY() > getY()) {
                    setY(getY() + 1);
                }
            } else if (bitcoin.getX() == super.x) {
                if (bitcoin.getY() < getY()) {
                    setY(getY() - 1);
                } else if (bitcoin.getY() > getY()) {
                    setY(getY() + 1);
                }
            }
        }

        if (collision.isBitcoinCollisionDetected(this, bitcoin)) {
            bitcoin.newBitcoin();
            GameScore.removePoint();
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

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

}