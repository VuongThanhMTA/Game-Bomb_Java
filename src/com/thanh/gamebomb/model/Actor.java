package com.thanh.gamebomb.model;

import com.thanh.gamebomb.gui.FrameBomb;

import java.awt.*;
import java.util.ArrayList;

public class Actor {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int ALIVE = 1;
    public static final int DEAD = 0;

    protected int orient;
    protected int speed;
    protected int runBomb;
    protected int x;
    protected int y;
    protected Image[] images;
    protected int width;
    protected int height;

    public void draw(Graphics2D g2d) {
        boolean check = this instanceof Bomber;
        if (check == true) {
            g2d.drawImage(images[orient], x, y, null);
        } else {
            g2d.drawImage(images[orient], x, y, width, height - 3, null);
        }
    }

    public void changeOrient(int orient) {

        this.orient = orient;
    }

    public boolean move(int count, ArrayList<Box> arrBox, ArrayList<Bomb> arrBomb, ArrayList<Monster> arrMonster) {
        if (count % speed != 0) {
            return true;
        }

        int xR = x;
        int yR = y;

        switch (orient) {
            case LEFT:
                x -= 1;
                int fix = fixMap(arrBox);
                if (fix == 0) {
                    return false;
                }

                break;
            case RIGHT:
                x += 1;
                fix = fixMap(arrBox);
                if (fix == 0) {
                    return false;
                }
                break;
            case UP:
                y -= 1;
                fix = fixMap(arrBox);
                if (fix == 0) {
                    return false;
                }

                break;
            case DOWN:
                y += 1;
                fix = fixMap(arrBox);
                if (fix == 0) {
                    return false;
                }
                break;
        }
        //fixMap(arrMap);
        boolean checkMap = checkMap(arrBox, arrBomb, arrMonster);

        if (checkMap == false) {
            x = xR;
            y = yR;
            return false;
        }
        return true;
    }

    private boolean checkMap(ArrayList<Box> arrMap, ArrayList<Bomb> arrBomb, ArrayList<Monster> arrMonster) {
        if (x < -3 || x > FrameBomb.WIDTH_FRAME - 270
                || y < -25 || y > FrameBomb.HEIGHT_FRAME - 90) {
            return false;
        }

        for (Bomb bomb : arrBomb) {
            for (Monster monster : arrMonster) {
                if (bomb.isImpactActor(monster)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int fixMap(ArrayList<Box> arrBox) {

        switch (orient) {
            case LEFT:
                for (int i = 0; i < arrBox.size(); i++) {
                    int kq = arrBox.get(i).isImpactBoxvsActor(this);
                    if (kq != 0) {
                        if (kq >= -10 && kq <= 10) {
                            if (kq > 0) {
                                y = y + 1;
                            } else {
                                y = y - 1;
                            }
                        }
                        x = x + 1;
                        return 0;
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < arrBox.size(); i++) {
                    int kq = arrBox.get(i).isImpactBoxvsActor(this);
                    if (kq != 0) {
                        if (kq >= -10 && kq <= 10) {
                            if (kq > 0) {
                                y = y + 1;
                            } else {
                                y = y - 1;
                            }
                        }
                        x = x - 1;
                        return 0;
                    }
                }
                break;
            case UP:
                for (int i = 0; i < arrBox.size(); i++) {
                    int kq = arrBox.get(i).isImpactBoxvsActor(this);
                    if (kq != 0) {
                        if (kq >= -10 && kq <= 10) {
                            if (kq > 0) {
                                x = x + 1;
                            } else {
                                x = x - 1;
                            }
                        }
                        y = y + 1;
                        return 0;
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < arrBox.size(); i++) {
                    int kq = arrBox.get(i).isImpactBoxvsActor(this);
                    if (kq != 0) {
                        if (kq >= -10 && kq <= 10) {
                            if (kq > 0) {
                                x = x + 1;
                            } else {
                                x = x - 1;
                            }
                        }
                        y = y - 1;
                        return 0;
                    }
                }
                break;
            default:
                break;
        }
        return 1;
    }

    public void setOrient(int orient) {
        this.orient = orient;
    }

    public void setSpeed(int speed) {
        if (speed < 3) {
            return;
        }
        this.speed = speed;
    }

    public void setRunBomb(int runBomb) {
        this.runBomb = runBomb;
    }

    public int getOrient() {
        return orient;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRunBomb() {
        return runBomb;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImages() {
        return images[orient];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
