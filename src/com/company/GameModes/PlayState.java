package com.company.GameModes;

import com.company.Bitcoin;
import com.company.Board;
import com.company.Entities.Enemy;
import com.company.Entities.Player;
import com.company.States.GameEngine;
import com.company.States.GameState;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class PlayState extends GameState {
    private KeyStroke key;
    private static PlayState playState = null;
    private Enemy[] enemies;
    private Player player;
    private Bitcoin bitcoin;
    private int amount;
    
    @Override
    public void init() throws IOException {
        amount = 4;
        // Playfield
        printField();
        
        // Enemies
        enemies = new Enemy[amount];
        for (int i = 0, y = 2; i < 4; i++) {
            System.out.println("loop " + i + " : " + y);
            enemies[i] = new Enemy(10, y);
            Board.getTerminal().setCursorPosition(enemies[i].getX(), enemies[i].getY());
            Board.getTerminal().putCharacter('E');
            y += 5;
        }
        
        // Player
        player = new Player(20, 20);
        Board.getTerminal().setCursorPosition(player.getX(), player.getY());
        Board.getTerminal().putCharacter('P');
        
        // Bitcoins
        bitcoin = new Bitcoin();
    }
    
    @Override
    public void handleEvents(GameEngine game) throws IOException {
        key = Board.getTerminal().readInput();
        
        switch (key.getKeyType()) {
            case Escape:
                Board.getTerminal().clearScreen();
                game.changeState(MenuState.getInstance());
                break;
            case EOF:
                game.quit();
                break;
            case ArrowLeft:
                moveEnemy(player);
                player.movement(player.getX() - 1, player.getY());
                break;
            case ArrowRight:
                moveEnemy(player);
                player.movement(player.getX() + 1, player.getY());
                break;
            case ArrowUp:
                moveEnemy(player);
                player.movement(player.getX(), player.getY() - 1);
                break;
            case ArrowDown:
                moveEnemy(player);
                player.movement(player.getX(), player.getY() + 1);
                break;
            
        }
    }
    
    
    @Override
    public void update(GameEngine game) throws IOException {
        Board.getTerminal().clearScreen();
        printField();
        player.update();
        bitcoin.update();
        for (int i = 0; i < enemies.length; ++i) {
            enemies[i].update();
            
            //collision.update(enemies[i], player);
            if (player.getX() == enemies[i].getX() && player.getY() == enemies[i].getY()) {
                System.out.println("hit");
                game.changeState(MenuState.getInstance());
            }
        }
    }
    
    @Override
    public void draw(GameEngine game) throws IOException {
        Board.getTerminal().flush();
    }
    
    protected PlayState() {
    
    }
    
    public static PlayState getInstance() {
        if (playState == null) {
            playState = new PlayState();
        }
        return playState;
    }
    
    private void moveEnemy(Player player) throws IOException {
        for (Enemy e : enemies) {
            e.movement(player);
        }
    }
    
    public void printField() throws IOException {
        for (int i = 0; i < Board.getTerminal().getTerminalSize().getColumns(); ++i) {
            for (int j = 0; j < Board.getTerminal().getTerminalSize().getRows(); ++j) {
                if (j == 0) {
                    Board.getTerminal().newTextGraphics().putString(i, j, "X");
                } else if (j == Board.getTerminal().getTerminalSize().getRows() - 1) {
                    Board.getTerminal().newTextGraphics().putString(i, j, "X");
                } else if (i == 0) {
                    Board.getTerminal().newTextGraphics().putString(i, j, "X");
                } else if (i == Board.getTerminal().getTerminalSize().getColumns() - 1) {
                    Board.getTerminal().newTextGraphics().putString(i, j, "X");
                }
            }
        }
    }
}