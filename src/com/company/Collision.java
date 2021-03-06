package com.company;

import com.company.Entities.*;

import java.io.IOException;


public class Collision {
    public static boolean isEnemyCollisionDetected(Enemy enemy, Player player) {
        return enemy.getX() == player.getX() && enemy.getY() == player.getY();
    }
    
    public static boolean isBitcoinCollisionDetected(Player player, Bitcoin bitcoin) throws IOException {
        return player.getY() == bitcoin.getY() && player.getX() == bitcoin.getX();

    }
    
    public static boolean isBitcoinCollisionDetected(Enemy enemy, Bitcoin bitcoin) {
        return enemy.getY() == bitcoin.getY() && enemy.getX() == bitcoin.getX();
    }
    
    public static boolean isOutofBounds(Player player) throws IOException {
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

    public static boolean isOutofBounds(Enemy enemy) throws IOException {
        boolean isOutofBounds = false;

        if(enemy.getX() >= Board.getTerminal().getTerminalSize().getColumns() - 1) {
            isOutofBounds = true;
        }
        if(enemy.getY() >= Board.getTerminal().getTerminalSize().getRows() - 1) {
            isOutofBounds = true;
        }
        if(enemy.getX() <= 0) {
            isOutofBounds = true;
        }
        if(enemy.getY() <= 0) {
            isOutofBounds = true;
        }

        return isOutofBounds;
    }
}
