package com.company.Entities;

import com.company.Board;
import com.company.Collision;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEnemy extends Enemy implements IEntity {
    private Collision collision;
    private char string;

    public RandomEnemy(int x, int y, TextColor color, char string) throws IOException {
        super(x, y, color, string);
        collision = new Collision();
        this.string = string;
    }
    
    @Override
    public void movement(Player player) throws IOException {
        int oldX = x;
        int oldY = y;
        int min = 1;
        int max = 5;
        int newPos = ThreadLocalRandom.current().nextInt(min, max);
        
        if(Math.random() < 0.5) {
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
            System.out.println("Hit player");
        }
        
        /*if (Math.random() < 0.5) {
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
        }*/
        
        
        TextCharacter c = Board.getTerminal().newTextGraphics().getCharacter(x, y);
        char cc = c.getCharacter();
        System.out.println(cc);
        if (cc == string) {
            setX(oldX);
            setY(oldY);
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
