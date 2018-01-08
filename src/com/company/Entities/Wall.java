package com.company.Entities;

import com.company.Board;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Wall implements IEntity {
    private int x;
    private int y;

    public Wall() throws IOException {
        x = ThreadLocalRandom.current().nextInt(0, Board.getColumns());
        y = ThreadLocalRandom.current().nextInt(4, Board.getRows());
        int size = 4;
        char wallChar = '\u2588';
        int chance = ThreadLocalRandom.current().nextInt(0, 10);
        if (chance < 5) {
            for (int i = 0; i < size; i++) {
                Board.getTerminal().setCursorPosition(x + i, y);
                Board.getTerminal().putCharacter(wallChar);
            }
        } else {
            for (int i = 0; i < size; i++) {
                Board.getTerminal().setCursorPosition(x, y + i);
                Board.getTerminal().putCharacter(wallChar);
            }
        }
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