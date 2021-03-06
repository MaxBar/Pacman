package com.company.Entities;

import com.company.Board;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bitcoin implements IEntity {
    private int x;
    private int y;

    Random random;
    char cc;

    public Bitcoin() throws IOException {
        init();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {

    }

    public void init() throws IOException {
        newBitcoin();
    }

    public void update() throws IOException {
        Board.getTerminal().newTextGraphics().putString(x, y, "$");
    }

    public void newBitcoin() throws IOException {
        random = new Random();
        do {
            x = ThreadLocalRandom.current().nextInt(Board.borderOrigin(), Board.getColumns());
            y = ThreadLocalRandom.current().nextInt(Board.borderOffset(), Board.getRows());
            //x = (int) Math.floor(random.nextInt(Board.getTerminal().getTerminalSize().getColumns()) + 1);
            //y = ThreadLocalRandom.current().nextInt(3, Board.getRows());

            TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
            cc = c.getCharacter();

        } while (cc != ' ' && cc == Wall.getChar());

    }
}
