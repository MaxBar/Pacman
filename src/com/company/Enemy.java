package com.company;

import java.io.IOException;

public class Enemy implements IEntity {
    private int x;
    private int y;

    public Enemy(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void movement() throws IOException {
        //
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
