package com.company.Entities;

import com.googlecode.lanterna.TextColor;


public class FastEnemy extends Enemy implements IEntity {

    public FastEnemy(int x, int y, TextColor color, char string, float probabilityOfMoving) {
        super(x, y, color, string, probabilityOfMoving);

    }

}
