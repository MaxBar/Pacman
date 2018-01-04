package com.company;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Player implements IEntity {
    private int x;
    private int y;

    public Player(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void movement(int x, int y) throws IOException {

    }

    @Override
    public void movement() throws IOException {

    }

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }

}
