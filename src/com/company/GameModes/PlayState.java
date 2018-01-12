package com.company.GameModes;

import com.company.*;
import com.company.Entities.*;
import com.company.States.GameEngine;
import com.company.States.GameState;
import com.company.Entities.PlayerHealth;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


public class PlayState extends GameState {
    private KeyStroke key;
    private static PlayState playState = null;
    private Enemy[] enemies;
    private Player player;
    private Bitcoin bitcoin;
    private int amount;
    private Wall wall;
    private GameScore points;
    private PlayerHealth health;
    private int playerStartX;
    private int playerStartY;

    @Override
    public void init() throws IOException {
        amount = 4;

        // Playfield
        Board.printField();
        
        // Enemies
        enemies = new Enemy[amount];
        enemies[0] = new FastEnemy(ThreadLocalRandom.current().nextInt(Board.borderOrigin(), Board.getColumns()),ThreadLocalRandom.current().nextInt(Board.borderOffset(), Board.getRows()), TextColor.ANSI.GREEN,'\u2622', 0.7f);//Fast
        enemies[1] = new RandomEnemy(ThreadLocalRandom.current().nextInt(Board.borderOrigin(), Board.getColumns()),ThreadLocalRandom.current().nextInt(Board.borderOffset(), Board.getRows()), TextColor.ANSI.BLUE,'\u2744', 0.5f);//Random
        enemies[2] = new BitcoinEnemy(ThreadLocalRandom.current().nextInt(Board.borderOrigin(), Board.getColumns()),ThreadLocalRandom.current().nextInt(Board.borderOffset(), Board.getRows()), TextColor.ANSI.RED,'\u262D'); //BitcoinEnemy
        enemies[3] = new Enemy(ThreadLocalRandom.current().nextInt(Board.borderOrigin(), Board.getColumns()),ThreadLocalRandom.current().nextInt(Board.borderOffset(), Board.getRows()), TextColor.ANSI.WHITE,'\u262F', 0.3f);//Normal
        
        for (int i = 0; i < enemies.length; i++) {
            Board.getTerminal().setCursorPosition(enemies[i].getX(), enemies[i].getY());
            Board.getTerminal().putCharacter('\u2622');
        }
        
        // Player
        playerStartX = 20;
        playerStartY = 20;
        player = new Player(playerStartX, playerStartY);
        Board.getTerminal().setCursorPosition(player.getX(), player.getY());
        Board.getTerminal().putCharacter('\u263A');
        
        // Bitcoins
        bitcoin = new Bitcoin();
        
        // Wall
        wall = new Wall();
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
                player.movement(player.getX() - 1, player.getY(), bitcoin);
                break;
            case ArrowRight:
                moveEnemy(player);
                player.movement(player.getX() + 1, player.getY(), bitcoin);
                break;
            case ArrowUp:
                moveEnemy(player);
                player.movement(player.getX(), player.getY() - 1, bitcoin);
                break;
            case ArrowDown:
                moveEnemy(player);
                player.movement(player.getX(), player.getY() + 1, bitcoin);
                break;
            
        }
    }
    
    
    @Override
    public void update(GameEngine game) throws IOException {
        Board.getTerminal().clearScreen();
        Board.printField();
        wall.update();
        player.update();
        bitcoin.update();
        points.writePoints();
        health.displayHealth();
        for (int i = 0; i < enemies.length; ++i) {
            enemies[i].update();

            if (PlayerHealth.getHealth() == 0) {
                Board.getTerminal().clearScreen();
                game.changeState(GameOverState.getInstance());
                PlayerHealth.setHealth();
                GameScore.setGameScore();
                break;
            }


        }
    }
    
    @Override
    public void draw(GameEngine game) throws IOException {
        Board.getTerminal().flush();
    }
    
    protected PlayState() throws IOException {
    
    }
    
    public static PlayState getInstance() throws IOException {
        if (playState == null) {
            playState = new PlayState();
        }
        return playState;
    }
    
    private void moveEnemy(Player player) throws IOException {
        for(int i = 0; i < enemies.length; ++i) {
            if(i == 2) {
                enemies[2].movement(bitcoin);
            }
            else
            enemies[i].movement(player);
        }

    }
    

}