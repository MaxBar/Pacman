package com.company.Entities;

import java.io.IOException;

public interface IEntity {
    int x = 0;
    int y = 0;
    
    int getX();
    
    void setX(int x);
    
    int getY();
    
    void setY(int y);

    void update() throws IOException;
}
