package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;

public class ItemsDemo {
    public static int ITEM_BOMB = 1;
    public static int ITEM_BOMBSIZE = 2;
    public static int ITEM_SHOE = 3;

    private Image[] imgBomb = {
            new ImageIcon(getClass().getResource(
                    "/images/items/item_boom.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_boom_01.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_boom_02.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_boom_03.png")).getImage()
    };

    private Image[] imgBombsize = {
            new ImageIcon(getClass().getResource(
                    "/images/items/item_exp.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_exp_01.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_exp02.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_exp03.png")).getImage()
    };
    private Image[] imgShoe = {
            new ImageIcon(getClass().getResource(
                    "/images/items/item_speed.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_speed_01.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_speed_02.png")).getImage(),
            new ImageIcon(getClass().getResource(
                    "/images/items/item_speed_03.png")).getImage()
    };
    private int type, timeLine;
    private Image[][] images = {imgBomb, imgBombsize, imgShoe};
    protected int x;
    protected int y;
    protected int bit;
    protected int width = 50;
    protected int height = 50;
    int index = -1;

    public ItemsDemo(int x, int y, int bit, int type) {
        this.x = x;
        this.y = y;
        this.bit = bit;
        this.type = type;
    }

    public void draw(Graphics2D g2d) {

        index++;
        if (index >= images.length) {
            index = 0;
        }
        g2d.drawImage(images[bit-1][index], x + width / 2, y + height / 2, null);
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
    public int getBit() {
        return bit;
    }

    public int getTimeLine() {
        return timeLine;
    }
}
