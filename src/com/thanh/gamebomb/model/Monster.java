package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Monster extends Actor {

    public Monster(int x, int y, int speed, int orient) {

        this.x = x;
        this.y = y;
        this.speed = speed;
        this.orient = orient;


        images = new Image[4];
        images[0] = new ImageIcon(getClass().getResource("/images/monster_left.png")).getImage();
        images[1] = new ImageIcon(getClass().getResource("/images/monster_right.png")).getImage();
        images[2] = new ImageIcon(getClass().getResource("/images/monster_up.png")).getImage();
        images[3] = new ImageIcon(getClass().getResource("/images/monster_down.png")).getImage();
        this.width = images[orient].getWidth(null) - 3;
        this.height = images[orient].getHeight(null);
    }

    @Override
    public void changeOrient(int orient) {
        super.changeOrient(orient);
    }

}
