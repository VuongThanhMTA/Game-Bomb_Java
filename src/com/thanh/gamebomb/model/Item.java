package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;

public class Item extends MapBomb {
    public static int ITEM_BOMB=1;
    public static int ITEM_BOMBSIZE=2;
    public static int ITEM_SHOE=3;
    private int type, timeLine;

    public Item(int x, int y, int bit, int type) {
        super(x, y, bit);
        this.type = type;
        timeLine = 250;
        images = new Image[]{
                new ImageIcon(getClass()
                        .getResource("/images/item_bomb.png")).getImage(),
                new ImageIcon(getClass()
                        .getResource("/images/item_bombsize.png")).getImage(),
                new ImageIcon(getClass()
                        .getResource("/images/item_shoe.png")).getImage()
        };
        this.width = images[bit-1].getWidth(null);
        this.height=images[bit-1].getHeight(null);
    }

    @Override
    public void drawMapBomb(Graphics2D g2d) {
        super.drawMapBomb(g2d);
    }


    public Rectangle getRec() {
        Rectangle rectangle = new Rectangle(x, y,width,height-22);
        return rectangle;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTimeLine(int timeLine) {
        this.timeLine = timeLine;
    }

    public int getType() {

        return type;
    }

    public int getTimeLine() {
        return timeLine;
    }
}
