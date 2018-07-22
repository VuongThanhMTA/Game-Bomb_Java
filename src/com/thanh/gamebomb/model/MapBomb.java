package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;

public class MapBomb {
    protected int x;
    protected int y;
    protected int bit;
    protected int width;
    protected int height;
    protected Image[] images ;

    public MapBomb(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;// giá trị bit trong map tương ứng vị trí x,y

    }

    public void drawMapBomb(Graphics2D g2d) {
        g2d.drawImage(images[bit - 1], x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBit() {
        return bit;
    }
    public Image getImage() {
        return images[bit - 1];
    }
}
