package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bomber extends Actor {

    public static final int ALLOW_RUN = 0;
    public static final int DISALLOW_RUN = 1;

    protected int score;
    protected int heart;
    protected int status;
    protected int sizeBomb;
    protected int quantityBomb;
    protected int runBomb;

    public Bomber(int x, int y, int speed, int sizeBomb, int quantityBomb) {

        this.x = x;
        this.y = y;
        this.speed = speed;
        this.runBomb = DISALLOW_RUN;
        this.status = Actor.ALIVE;
        this.heart = 3;
        this.score = 0;
        orient = RIGHT;
        this.sizeBomb = sizeBomb;
        this.quantityBomb = quantityBomb;


        images = new Image[6];
        images[0] = new ImageIcon(getClass().getResource("/images/bomber_left.png")).getImage();
        images[1] = new ImageIcon(getClass().getResource("/images/bomber_right.png")).getImage();
        images[2] = new ImageIcon(getClass().getResource("/images/bomber_up.png")).getImage();
        images[3] = new ImageIcon(getClass().getResource("/images/bomber_down.png")).getImage();
        images[4] = new ImageIcon(getClass().getResource("/images/bomber_dead.png")).getImage();
        images[5] = new ImageIcon(getClass().getResource("/images/ghost.png")).getImage();
        this.height = images[orient].getHeight(null);
        this.width = images[orient].getWidth(null);
    }


    @Override
    public void changeOrient(int orient) {
        if (this.status == Actor.DEAD) {
            return;
        }
        super.changeOrient(orient);

    }
    @Override
    public boolean move(int count,ArrayList<Box> arrMap, ArrayList<Bomb> arrBomb, ArrayList<Monster> arrMonster) {
        if (status == DEAD) {
            return false;
        }
        return super.move(count,arrMap, arrBomb, arrMonster);
    }
    public void setNew(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = ALIVE;
        this.orient = RIGHT;
    }


    public boolean isImpactItem(Item item) {
        Rectangle rect = new Rectangle(x, y, width,height);
        return rect.intersects(item.getRec());
    }
    public boolean isImpactMonster(Monster monster) {

        if (status == Actor.DEAD) {
            return false;
        }
        Rectangle rectBomber = new Rectangle(x, y, width,height - 20);
        Rectangle rectMonster = new Rectangle(monster.getX(), monster.getY(), width,height - 23);
        return rectBomber.intersects(rectMonster);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void setRunBomb(int runBomb) {
        this.runBomb = runBomb;
    }

    public void setImageDie(Image image) {
        this.images[orient] = image;
    }

    public int getScore() {
        return score;
    }

    public int getHeart() {
        return heart;
    }

    public int getStatus() {
        return status;
    }

    public int getSizeBomb() {
        return sizeBomb;
    }

    public int getQuantityBomb() {
        return quantityBomb;
    }

    public void setQuantityBomb(int quantityBomb) {
        if (quantityBomb > 5) {
            return;
        }
        this.quantityBomb = quantityBomb;
    }


    public void setSizeBomb(int sizeBomb) {
        if (sizeBomb > 3) {
            return;
        }
        this.sizeBomb = sizeBomb;
    }
}
