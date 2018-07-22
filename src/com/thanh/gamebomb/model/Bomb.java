package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;

public class Bomb {
    protected int x;
    protected int y;
    protected int size;
    protected int timeLine;
    protected Image image = new ImageIcon(getClass().getResource("/images/bomb.png")).getImage();


    public Rectangle getRec() {
        Rectangle rectangle = new Rectangle(x, y,
                image.getWidth(null),
                image.getHeight(null));
        return rectangle;
    }

    public boolean isImpactBom(int x, int y) {
        Rectangle rec1 = new Rectangle(x, y,
                image.getWidth(null),
                image.getHeight(null));
        return this.getRec().intersects(rec1);
    }

    public boolean isImpactActor(Actor actor) {
        Rectangle recActor = new Rectangle(actor.getX(), actor.getY(), actor.getImages().getWidth(null),
                actor.getImages().getHeight(null));
        return this.getRec().intersects(recActor);
    }

    public boolean isImpactBox(Box box){
        Rectangle rectBomb = new Rectangle(x,y,image.getWidth(null),image.getHeight(null));
        Rectangle rectBox = new Rectangle(box.getX(),box.getY(), box.getImage().getWidth(null),box.getImage().getHeight(null));
        return rectBomb.intersects(rectBox);
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    }
    public void deadlineBomb() {
        timeLine--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getTimeLine() {
        return timeLine;
    }

    public Image getImage() {
        return image;
    }

    public Bomb(int x, int y, int size, int timeLine) {
        x=(x/45)*45;// đặt đúng ô căn theo box
        y=(y/45)*45;
        this.x = x;
        this.y = y;
        this.size = size;
        this.timeLine = timeLine;

    }

}
