package com.company;

import com.company.Entities.*;

import java.io.IOException;

public class Collision {
    public static boolean isEnemyCollisionDetected(Enemy enemy, Player player) {
        return enemy.getX() == player.getX() && enemy.getY() == player.getY();
    }

    public static boolean isBitcoinCollisionDetected(Player player, Bitcoin bitcoin) {
        return player.getY() == bitcoin.getY() && player.getX() == bitcoin.getX();
    }
    
    public static boolean isOutofBounds(IEntity entity) throws IOException {
        boolean isOutofBounds = false;
        
        if(entity.getX() >= Board.getTerminal().getTerminalSize().getColumns() - 1) {
            isOutofBounds = true;
        }
        if(entity.getY() >= Board.getTerminal().getTerminalSize().getRows() - 1) {
            isOutofBounds = true;
        }
        if(entity.getX() <= 0) {
            isOutofBounds = true;
        }
        if(entity.getY() <= 0) {
            isOutofBounds = true;
        }
        
        return isOutofBounds;
    }
}
