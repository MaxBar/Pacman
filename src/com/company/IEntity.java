package com.company;

import java.io.IOException;

public interface IEntity {
    int x = 0;
    int y = 0;

    public void movement() throws IOException;

    public int getX();
    public void setX(int x);
    public int getY();
    public void setY(int y);
}
