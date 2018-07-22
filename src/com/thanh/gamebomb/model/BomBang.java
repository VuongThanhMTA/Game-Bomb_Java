package com.thanh.gamebomb.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BomBang {
    private int x;
    private int y;
    private int size;
    private int timeLine;
    private Image imgLeft;
    private Image imgRight;
    private Image imgUp;
    private Image imgDown;

    public BomBang(int x, int y, int size,ArrayList<Box>arrBox) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.timeLine = 350;
        imgLeft = new ImageIcon(getClass().getResource("/images/bombbang_left_1.png")).getImage();
        imgRight = new ImageIcon(getClass().getResource("/images/bombbang_right_1.png")).getImage();
        imgUp = new ImageIcon(getClass().getResource("/images/bombbang_up_1.png")).getImage();
        imgDown = new ImageIcon(getClass().getResource("/images/bombbang_down_1.png")).getImage();
        setImages(arrBox);

    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(imgUp, x, y + 45 - imgUp.getHeight(null), null);
        g2d.drawImage(imgDown, x, y, null);
        g2d.drawImage(imgLeft, x + 45 - imgLeft.getWidth(null), y, null);
        g2d.drawImage(imgRight, x, y, null);
    }


    public boolean isImpactActor(Actor actor) {
        Rectangle recLeft = new Rectangle(x + 45 - imgLeft.getWidth(null)+5,
                y+5, imgLeft.getWidth(null), imgLeft.getHeight(null)-10);
        Rectangle recRight = new Rectangle(x, y+5, imgRight.getWidth(null)-10,
                imgRight.getHeight(null)-10);
        Rectangle recUp = new Rectangle(x+5, y + 50 - imgUp.getHeight(null)
                , imgUp.getWidth(null)-5, imgUp.getHeight(null));
        Rectangle recDown = new Rectangle(x+5, y, imgDown.getWidth(null)-5,
                imgDown.getHeight(null)-15);
        Rectangle recActor = new Rectangle(actor.getX(), actor.getY()+10,actor.getWidth()-5,actor.getHeight()-20);
        if (recLeft.intersects(recActor) || recDown.intersects(recActor) || recRight.intersects(recActor)
                || recUp.intersects(recActor)) {
            return true;
        }
        return false;
    }


    public boolean isImpactBomb(Bomb bomb) {
        Rectangle recLeft = new Rectangle(x + 45 - imgLeft.getWidth(null), y, imgLeft.getWidth(null),
                imgLeft.getHeight(null));
        Rectangle recRight = new Rectangle(x, y, imgRight.getWidth(null)
                , imgRight.getHeight(null));
        Rectangle recUp = new Rectangle(x, y + 45 - imgUp.getHeight(null), imgUp.getWidth(null),
                imgUp.getHeight(null));
        Rectangle recDown = new Rectangle(x, y, imgDown.getWidth(null),
                imgDown.getHeight(null));
        Rectangle recBomb = new Rectangle(bomb.getX(), bomb.getY(), bomb.getImage().getWidth(null),
                bomb.getImage().getHeight(null));

        if (recLeft.intersects(recBomb) || recDown.intersects(recBomb) || recRight.intersects(recBomb) || recUp.intersects(recBomb)) {
            return true;
        }
        return false;
    }

    public boolean impactBox(int x, int y, int width, int height, Box map) {
        Rectangle rect = new Rectangle(x, y, width, height);
        Rectangle rectBox = new Rectangle(map.getX(), map.getY(),
                map.getImage().getWidth(null), map.getImage().getHeight(null));
        return rect.intersects(rectBox);
    }

    public boolean isImpactBox(Box mapBomb) {
        if (mapBomb.getBit() == 1) {
            return false;
        }

        Rectangle recLeft = new Rectangle(x - imgLeft.getWidth(null) / 2, y, imgLeft.getWidth(null),
                imgLeft.getHeight(null));
        Rectangle recRight = new Rectangle(x, y, imgRight.getWidth(null)
                , imgRight.getHeight(null));
        Rectangle recUp = new Rectangle(x, y - imgUp.getHeight(null) / 2, imgUp.getWidth(null),
                imgUp.getHeight(null));
        Rectangle recDown = new Rectangle(x, y, imgDown.getWidth(null),
                imgDown.getHeight(null));
        Rectangle recBox = new Rectangle(mapBomb.getX(), mapBomb.getY(), mapBomb.getImage().getWidth(null),
                mapBomb.getImage().getHeight(null));
        if (recLeft.intersects(recBox) || recDown.intersects(recBox) || recRight.intersects(recBox) || recUp.intersects(recBox)) {
            return true;
        }
        return false;
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

    public void deadlineBomb() {
        if (timeLine > 0) {
            timeLine--;
        }
    }

    public void  setImages(ArrayList<Box> arrBox){
        for(int i=1;i<size;i++){
            int impactLeft=0, impactRight=0 ,impactUp=0 ,impactDown=0 ;

            for(int j=0;j<arrBox.size();j++){
                if(impactBox(x-(i)*45, y, (i+1)*45, 45, arrBox.get(j))){
                    impactLeft=1;
                }
                if(impactBox(x, y, (i+1)*45, 45, arrBox.get(j))){
                    impactRight=1;
                }
                if(impactBox(x, y-(i*45), 45, (i+1)*45, arrBox.get(j))){
                    impactUp=1;
                }
                if(impactBox(x, y, 45, (i+1)*45, arrBox.get(j))){
                    impactDown=1;
                }
            }
            if(impactLeft==0){
                imgLeft = new ImageIcon(getClass().getResource("/images/bombbang_left_2.png")).getImage();
            }
            if(impactRight==0){
                imgRight = new ImageIcon(getClass().getResource("/images/bombbang_right_2.png")).getImage();
            }
            if(impactUp==0){
                imgUp = new ImageIcon(getClass().getResource("/images/bombbang_up_2.png")).getImage();

            }
            if(impactDown==0){
                imgDown = new ImageIcon(getClass().getResource("/images/bombbang_down_2.png")).getImage();
            }
        }
    }
}
