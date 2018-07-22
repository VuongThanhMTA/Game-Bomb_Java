package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;

public class Box extends MapBomb {
    public Box(int x, int y, int bit) {
        super(x, y, bit);
        images = new Image[]{
                new ImageIcon(getClass()
                        .getResource("/images/box1.png")).getImage(),
                new ImageIcon(getClass()
                        .getResource("/images/box2.png")).getImage(),
                new ImageIcon(getClass()
                        .getResource("/images/shawdow1.png")).getImage(),
                new ImageIcon(getClass()
                        .getResource("/images/shawdow2.png")).getImage(),

        };
        this.width = images[bit - 1].getWidth(null);
        this.height = images[bit - 1].getHeight(null);
    }

    @Override
    public void drawMapBomb(Graphics2D g2d) {
        super.drawMapBomb(g2d);
    }

    public Rectangle getRec() {
        Rectangle rectangle = new Rectangle(x, y, width, height);

        return rectangle;
    }

    public boolean isImpactBom(int x, int y) {
        Rectangle rec1 = new Rectangle(x, y, 45, 45);
        return this.getRec().intersects(rec1);
    }

    public int isImpactBoxvsActor(Actor actor) {

        Rectangle rec1 = new Rectangle(x, y, width, height-23);
        Rectangle rec2 = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
        Rectangle rec3 = new Rectangle();
        if (rec1.intersects(rec2)) {
            rec1.intersect(rec1, rec2, rec3);
            if (rec3.getHeight() == 1 && (actor.getOrient() == Actor.UP || actor.getOrient() == Actor.DOWN)) {
                if (actor.getX() == rec3.getX()) {
                    return (int) rec3.getWidth();
                } else {
                    return (int) -rec3.getWidth();
                }
            } else {
                if (actor.getY() == rec3.getY()) {
                    return (int) rec3.getHeight();
                } else {
                    return (int) -rec3.getHeight();
                }
            }
        }
        return 0;
    }
}
