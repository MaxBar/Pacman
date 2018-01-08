package com.company.Entities;

import com.company.Bitcoin;
import com.company.Board;
import com.company.Collision;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;

public class BitcoinEnemy extends Enemy implements IEntity {
    private String string;
    private Collision collision;

    public BitcoinEnemy(int x, int y) {
        super(x, y);
        string = "\u2622";
        collision = new Collision();
    }
    
    public void movement(Bitcoin bitcoin) throws IOException {
        int oldx = getX();
        int oldy = getY();

        if (Math.random() < 0.75) {
            if (bitcoin.getX() < getX()) {
                setX(getX()-1);
                if (bitcoin.getY() < getY()) {
                    setY(getY()-1);
                } else if (bitcoin.getY() > getY()) {
                    setY(getY()+1);
                }
            } else if (bitcoin.getX() > getX()) {
                setX(getX()+1);
                if (bitcoin.getY() < getY()) {
                    setY(getY()-1);
                } else if (bitcoin.getY() > getY()) {
                    setY(getY()+1);
                }
            } else if (bitcoin.getX() == x) {
                if (bitcoin.getY() < getY()) {
                    setY(getY()-1);
                } else if (bitcoin.getY() > getY()) {
                    setY(getY()+1);
                }
            }
        }

        if (collision.isBitcoinCollisionDetected(this, bitcoin)){
            bitcoin.newBitcoin();
        }

        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc == string.toCharArray()[0]) {
            setX(oldx);
            setY(oldy);
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