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
<<<<<<< HEAD

=======
    
<<<<<<< HEAD

    public static boolean isBitcoinCollisionDetected(Enemy enemy, Bitcoin bitcoin) {
=======
<<<<<<< HEAD
    public static boolean isOutofBounds(IEntity entity) throws IOException {
=======
>>>>>>> 653dbb729783e899965f17caf53000ac1b2cc42e
    public boolean isBitcoinCollisionDetected(Enemy enemy, Bitcoin bitcoin) {
>>>>>>> 2e4bb799f2f734a153de8168077e6a42bb49e4ed
        return enemy.getY() == bitcoin.getY() && enemy.getX() == bitcoin.getX();
    }

    /*public boolean isBothEnemyCollisionDetected(Enemy[] enemy) {
        boolean isCollision = false;
        for(int i = 0; i < enemy.length; ++i) {

        }
        return en
    }*/
<<<<<<< HEAD
    
    public static boolean isOutofBounds(IEntity entity) throws IOException {
=======

    public boolean isOutofBounds(Player player) throws IOException {
>>>>>>> d5fd8e717c46dbb1804e6802c7c9c519a621cab8
>>>>>>> 2e4bb799f2f734a153de8168077e6a42bb49e4ed
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