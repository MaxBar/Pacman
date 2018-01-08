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


    public static boolean isBitcoinCollisionDetected(Enemy enemy, Bitcoin bitcoin) {


    
    public static boolean isOutofBounds(IEntity entity) throws IOException {

        boolean isOutofBounds = false;
<<<<<<< HEAD

        if(player.getX() >= Board.getTerminal().getTerminalSize().getColumns() - 1) {
=======
        
        if(entity.getX() >= Board.getTerminal().getTerminalSize().getColumns() - 1) {
>>>>>>> 653dbb729783e899965f17caf53000ac1b2cc42e
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