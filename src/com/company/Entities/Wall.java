package com.company.Entities;

import com.company.Board;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Wall implements IEntity {
    private int x;
    private int y;
    private int z;
    private int a;
    private static final char wallChar = '\u2588';
    private int size = 20;

    public Wall() throws IOException {
        x = ThreadLocalRandom.current().nextInt(10, Board.getColumns()-10);
        y = ThreadLocalRandom.current().nextInt(10, Board.getRows()-10);
        z = ThreadLocalRandom.current().nextInt(10, Board.getColumns()-10);
        a = ThreadLocalRandom.current().nextInt(10, Board.getRows()-10);

        update();
    }
    public void update() throws IOException {

        for (int i = 0; i < size; i++) {
            Board.getTerminal().setCursorPosition(x, y+i);
            if(i!=10)
            Board.getTerminal().putCharacter(wallChar);
        }
        for (int i = 0; i < size*3; i++) {
            Board.getTerminal().setCursorPosition(z+i, a);
            Board.getTerminal().putCharacter(wallChar);
        }
    }
    public static char getChar() {
        return wallChar;
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
