package com.company;

import com.company.Entities.*;

import java.io.IOException;

public class Collision {
    public boolean isEnemyCollisionDetected(Enemy enemy, Player player) {
        return enemy.getX() == player.getX() && enemy.getY() == player.getY();
    }

    public boolean isBitcoinCollisionDetected(Player player, Bitcoin bitcoin) {
        return player.getY() == bitcoin.getY() && player.getX() == bitcoin.getX();
    }
    
    public boolean isOutofBounds(Player player) throws IOException {
        boolean isOutofBounds = false;
        
        if(player.getX() >= Board.getTerminal().getTerminalSize().getColumns() - 1) {
            isOutofBounds = true;
        }
        if(player.getY() >= Board.getTerminal().getTerminalSize().getRows() - 1) {
            isOutofBounds = true;
        }
        if(player.getX() <= 0) {
            isOutofBounds = true;
        }
        if(player.getY() <= 0) {
            isOutofBounds = true;
        }
        
        return isOutofBounds;
    }
}
