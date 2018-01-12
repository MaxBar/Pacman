package com.company.Entities;

import com.company.*;
import com.googlecode.lanterna.*;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEnemy extends Enemy implements IEntity {
    private Collision collision;
    private char string;
    private float probabilityOfMoving;

    public RandomEnemy(int x, int y, TextColor color, char string, float probabilityOfMoving) throws IOException {
        super(x, y, color, string, probabilityOfMoving);
        collision = new Collision();
        this.string = string;
        this.probabilityOfMoving = probabilityOfMoving;
    }
    
    @Override
    public void movement(Player player) throws IOException {
        int oldX = super.x;
        int oldY = super.y;
        int min = 1;
        int max = 5;
        int newPos = ThreadLocalRandom.current().nextInt(min, max);
        
        if(Math.random() < probabilityOfMoving) {
            switch (newPos) {
                case 1:
                    super.setX(super.getX() - 1);
                    break;
                case 2:
                    super.setX(super.getX() + 1);
                    break;
                case 3:
                    super.setY(super.getY() - 1);
                    break;
                case 4:
                    super.setY(super.getY() + 1);
                    break;
            }
        }
        if(collision.isEnemyCollisionDetected(this, player)) {
            PlayerHealth.removeHealth();
        }
        
        
        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(super.x, super.y);
        char cc = c.getCharacter();
        if (cc == string) {
            setX(oldX);
            setY(oldY);
        }

        c = Board.getTerminal().newTextGraphics().getCharacter(super.x, super.y);
        cc = c.getCharacter();
        if (cc == Wall.getChar()) {
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
