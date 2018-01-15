package com.company.Entities;

import com.company.*;
import com.googlecode.lanterna.*;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEnemy extends Enemy implements IEntity {
    private char string;
    private float probabilityOfMoving;
    private int countX = 0;
    private int countY = 0;

    public RandomEnemy(int x, int y, TextColor color, char string, float probabilityOfMoving) throws IOException {
        super(x, y, color, string, probabilityOfMoving);
        this.string = string;
        this.probabilityOfMoving = probabilityOfMoving;
    }

    @Override
    public void movement(Player player) throws IOException {
        int oldX = super.x;
        int oldY = super.y;
        int min = 1;
        int max = 3;
        int newPos = ThreadLocalRandom.current().nextInt(min, max);
        if (Math.random() < probabilityOfMoving) {
            switch (newPos) {
                case 1:
                    if (countX < Board.getColumns()/1.5) {
                        super.setX(super.getX() - 2);
                    } else {
                        super.setX(super.getX() + 2);
                    }
                    countX++;
                    if (countX > Board.getColumns()) {
                        countX = 0;
                    }
                    break;
                case 2:
                    if (countY < Board.getRows()/1.5) {
                        super.setY(super.getY() - 2);
                    } else {
                        super.setY(super.getY() + 2);
                    }
                    countY++;
                    if (countY > Board.getRows()) {
                        countY = 0;
                    }
                    break;
            }
        }
        if (Collision.isEnemyCollisionDetected(this, player))

        {
            PlayerHealth.removeHealth();
        }

        if (Collision.isOutofBounds(this))

        {
            super.x = oldX;
            super.y = oldY;
        }

        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(super.x, super.y);
        char cc = c.getCharacter();
        if (cc == string)

        {
            setX(oldX);
            setY(oldY);
        }

        c = Board.getTerminal().

                newTextGraphics().

                getCharacter(super.x, super.y);

        cc = c.getCharacter();
        if (cc == Wall.getChar())

        {
            super.x = oldX;
            super.y = oldY;
        }

    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }
}
