package com.company.GameModes;

import com.company.Bitcoin;
import com.company.Board;
import com.company.Entities.*;
import com.company.GameOverState;
import com.company.GameScore;
import com.company.States.GameEngine;
import com.company.States.GameState;
import com.company.States.PlayerHealth;
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

    @Override
    public void init() throws IOException {
        amount = 4;

        // Playfield
        Board.printField();
        
        // Enemies
        enemies = new Enemy[amount];
        enemies[0] = new FastEnemy(ThreadLocalRandom.current().nextInt(0, Board.getColumns()),ThreadLocalRandom.current().nextInt(4, Board.getRows()), TextColor.ANSI.GREEN,'\u2622');//Fast
        enemies[1] = new RandomEnemy(ThreadLocalRandom.current().nextInt(0, Board.getColumns()),ThreadLocalRandom.current().nextInt(4, Board.getRows()), TextColor.ANSI.BLUE,'\u2744');//Random
        enemies[2] = new BitcoinEnemy(ThreadLocalRandom.current().nextInt(0, Board.getColumns()),ThreadLocalRandom.current().nextInt(4, Board.getRows()), TextColor.ANSI.RED,'\u262D');//Coinchaser
        enemies[3] = new Enemy(ThreadLocalRandom.current().nextInt(0, Board.getColumns()),ThreadLocalRandom.current().nextInt(4, Board.getRows()), TextColor.ANSI.WHITE,'\u262F');//Normal
        
        for (int i = 0; i < enemies.length; i++) {
            Board.getTerminal().setCursorPosition(enemies[i].getX(), enemies[i].getY());
            Board.getTerminal().putCharacter('\u2622');
        }
        
        // Player
        player = new Player(20, 20);
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

            if(health.getHealth() > 0) {
                health.setHealth(health.getHealth() - 1);
            }
            if (PlayerHealth.getHealth() == 0) {
                game.changeState(MenuState.getInstance()); //Tillfälligt
                PlayerHealth.setHealth();
                GameScore.setGameScore();
            }

            //collision.update(enemies[i], player);
            /*if (player.getX() == enemies[i].getX() && player.getY() == enemies[i].getY()) {
                //game.changeState(MenuState.getInstance());
                System.out.println("hit");
            }*/
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