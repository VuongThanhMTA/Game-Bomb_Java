package com.thanh.gamebomb.model;

import com.thanh.gamebomb.gui.ButtonMenu;
import com.thanh.gamebomb.gui.FrameBomb;
import com.thanh.gamebomb.gui.PanelMenu;
import sounds.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GameManager {

    private PanelMenu panelMenu;
    private Random random = new Random();
    private SoundManager soundManager = new SoundManager();


    private Bomber myBomber;
    private ArrayList<Monster> arrMonster;
    private ArrayList<Bomb> arrBomb;
    private ArrayList<BomBang> arrBomBangs;
    private ArrayList<Box> arrMap;
    private ArrayList<Box> arrBox;
    private ArrayList<Box> arrShawdow;
    private ArrayList<Item> arrItem;
    private ArrayList<HightScore> arrHightScore;
    private int count = 0;

    private Image imageBG = new ImageIcon(getClass().getResource("/images/background_Play.png")).getImage();
    private Image imageInfo = new ImageIcon(getClass().getResource("/images/background_Info.png")).getImage();

    private int round = 1;
    private int status = 0;
    private int timeDie = 0;
    private int timeNext = 0;
    private int timeLost = 0;
    private int nextRound = 0;

    public GameManager() {
        initGame();
    }

    public void initGame() {
        switch (round) {
            case 1:
                init();
                myBomber = new Bomber(300, FrameBomb.HEIGHT_FRAME - 90, 7, 1, 3);
                readMapBomb(round);
                readMapItem(round);
                initMonster();
                status = 0;
                nextRound = 0;
                break;
            case 2:
                //myBomber = new Bomber(300, 290, 7, 1, 3);
                init();
                myBomber.setNew(300, 280);
                readMapBomb(round);
                readMapItem(round);
                initMonster();
                status = 0;
                nextRound = 0;
                break;
            default:
                break;
        }
        if (status != 3) {
          //  soundManager.getSoundBackground().play();
        }
        // soundManager.getSoundStart().play();
    }

    public void init() {
        arrMonster = new ArrayList<>();
        arrBomb = new ArrayList<>();
        arrBox = new ArrayList<>();
        arrShawdow = new ArrayList<>();
        arrItem = new ArrayList<>();
        arrBomBangs = new ArrayList<>();
        arrHightScore = new ArrayList<>();
        readFileHightScore();
    }

    public void draw(Graphics2D g2d) {

        g2d.drawImage(imageBG, 0, 0, null);
        drawInfo(g2d);


        for (int i = 0; i < arrBomb.size(); i++) {
            arrBomb.get(i).draw(g2d);
        }

        for (int i = 0; i < arrBomBangs.size(); i++) {
            arrBomBangs.get(i).draw(g2d);
        }


        for (int i = 0; i < arrBox.size(); i++) {
            arrBox.get(i).drawMapBomb(g2d);
        }

        for (int i = 0; i < arrItem.size(); i++) {
            arrItem.get(i).drawMapBomb(g2d);
        }
        for (int i = 0; i < arrMonster.size(); i++) {
            arrMonster.get(i).draw(g2d);
        }
        myBomber.draw(g2d);

        for (int i = 0; i < arrShawdow.size(); i++) {
            arrShawdow.get(i).drawMapBomb(g2d);
        }
    }

    public void drawDialog(Graphics2D g2d, int type) {
        g2d.setFont(new Font("Arial", Font.BOLD, 70));
        g2d.setColor(Color.RED);
        if (type == 1) {
            g2d.drawString("You Lose !!!", 200, 250);
        } else {
            if (type == 2) {
                g2d.drawString("Round " + round, 200, 250);
            } else {
                g2d.drawString("You Win !!!", 200, 250);
            }
        }
    }

    public void drawInfo(Graphics2D g2d) {

        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.setColor(Color.RED);
        g2d.drawImage(imageInfo, 678, 0, null);
        g2d.drawString("HEART", 700, 100);
        Image heart = new ImageIcon(getClass().getResource(
                "/images/heart_1.png")).getImage();
        if (myBomber.getHeart() == 3) {
            g2d.drawImage(heart, 750, 120, null);
            g2d.drawImage(heart, 775, 120, null);
            g2d.drawImage(heart, 800, 120, null);
        }
        if (myBomber.getHeart() == 2) {
            g2d.drawImage(heart, 760, 120, null);
            g2d.drawImage(heart, 790, 120, null);
        }
        if (myBomber.getHeart() == 1) {
            g2d.drawImage(heart, 775, 120, null);
        }

        g2d.drawString("SCORE : " + myBomber.getScore(), 700, 200);
    }

    private void initMonster() {

        switch (round) {
            case 1:
                //arrMonster.add(new Monster(136, -15, 9, 1));
               // arrMonster.add(new Monster(10, -15, 9, 1));
               // arrMonster.add(new Monster(300, 65, 9, 1));
               // arrMonster.add(new Monster(300, 160, 9, 1));
                arrMonster.add(new Monster(FrameBomb.WIDTH_FRAME / 2, FrameBomb.HEIGHT_FRAME / 2 + 40, 10, 1));
                break;
            case 2:
               // arrMonster.add(new Monster(0, 0, 8, 1));
               // arrMonster.add(new Monster(400, -3, 8, 1));
               // arrMonster.add(new Monster(0, 150, 8, 1));
               // arrMonster.add(new Monster(600, 200, 8, 1));
               // arrMonster.add(new Monster(50, 250, 8, 1));
               // arrMonster.add(new Monster(400, 200, 8, 1));
                arrMonster.add(new Monster(FrameBomb.WIDTH_FRAME / 2, FrameBomb.HEIGHT_FRAME / 2 + 70, 8, 1));
                break;
            default:
                break;
        }

    }

    public void innitBomb() {
        if (myBomber.getStatus() == Bomber.DEAD) {
            return;
        }
        int x = myBomber.getX() + myBomber.getWidth() / 2;
        int y = myBomber.getY() + myBomber.getHeight() / 2;
        for (int i = 0; i < arrBomb.size(); i++) {
            if (arrBomb.get(i).isImpactBom(x, y)) {// không đặt 2 bom 1 chỗ
                return;
            }
        }

        if (arrBomb.size() >= myBomber.getQuantityBomb()) {
            return;
        }
        Bomb mBom = new Bomb(x, y, myBomber.getSizeBomb(), 2000);
        arrBomb.add(mBom);
        soundManager.getSoundSetBomb().play();

    }

    private void readMapItem(int round) {
        try {
            File fileMap = new File("src/maps/item" + round + ".txt");
            // đọc từng dòng dùng bufferReader
            FileReader reader = new FileReader(fileMap);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();// đọc 1 dòng
            int n = 0;// chỉ số dòng
            while (line != null) {
                // duyệt từng ký tự trên dòng
                for (int i = 0; i < line.length(); i++) {

                    char c = line.charAt(i);
                    int bit = Integer.parseInt(c + "");

                    if (bit != 5) {

                        int x = i * 45;
                        int y = n * 45;
                        Item item = new Item(x, y, bit, bit);
                        arrItem.add(item);
                    }
                }
                line = bufferedReader.readLine();
                n++; // dòng tiếp theo
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void readMapBomb(int round) {

        try {
            File fileMap = new File("src/maps/map" + round + ".txt");
            // đọc từng dòng dùng bufferReader
            FileReader reader = new FileReader(fileMap);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();// đọc 1 dòng
            int n = 0;// chỉ số dòng
            while (line != null) {
                // duyệt từng ký tự trên dòng
                for (int i = 0; i < line.length(); i++) {

                    char c = line.charAt(i);
                    int bit = Integer.parseInt(c + "");

                    if (bit != 5) {

                        int x = i * 45;
                        int y = n * 45;
                        if (bit == 1 || bit == 2) {
                            Box mapBomb = new Box(x, y, bit);
                            arrBox.add(mapBomb);
                            if (bit == 1) {
                                Box shawdaw = new Box(x, y - 22, 3);
                                arrShawdow.add(shawdaw);
                            } else {
                                Box shawdaw = new Box(x, y - 7, 4);
                                arrShawdow.add(shawdaw);
                            }
                        }
                    }
                }
                line = bufferedReader.readLine();
                n++; // dòng tiếp theo
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readFileHightScore() {
        try {
            File fileMap = new File("src/HightScore/HightScore.txt");
            // đọc từng dòng dùng bufferReader
            FileReader reader = new FileReader(fileMap);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();// đọc 1 dòng
            int n = 0;// chỉ số dòng
            while (line != null) {
                String str[] = line.split(":");
                String name = str[0];
                int score = Integer.parseInt(str[1]);
                HightScore hightScore = new HightScore(name, score);
                arrHightScore.add(hightScore);

                line = bufferedReader.readLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private Comparator<HightScore> Comparator = new Comparator<HightScore>() {
        @Override
        public int compare(HightScore o1, HightScore o2) {
            if (o1.getScore() > o2.getScore()) {
                return -1;
            }
            return 0;
        }
    };

    public void saveScore() {
        System.out.println();
        //arrHightScore = new ArrayList<>();
        if (myBomber.getScore() > arrHightScore.get(arrHightScore.size() - 1).getScore() || arrHightScore.size() < 10) {
            String name = JOptionPane.showInputDialog("Please input Your Name");
            HightScore newScore = new HightScore(name, myBomber.getScore());
            arrHightScore.add(newScore);

            arrHightScore.sort(Comparator);

            if (arrHightScore.size() > 10) {
                arrHightScore.remove(arrHightScore.size() - 1);
            }
            try {
                FileOutputStream fileOutput = new FileOutputStream("src/HightScore/HightScore.txt");
                for (int i = 0; i < arrHightScore.size(); i++) {
                    String newScore1 = arrHightScore.get(i).getName() + ":" + arrHightScore.get(i).getScore() + "\n";
                    fileOutput.write(newScore1.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveBomber(int newOrient) {
        myBomber.changeOrient(newOrient);
        myBomber.move(count, arrBox, arrBomb, arrMonster);
    }

    public void changeOrientAll() {
        for (int i = 0; i < arrMonster.size(); i++) {
            int orient = random.nextInt(4);
            arrMonster.get(i).changeOrient(orient);
        }
    }

    // doi huong monster va khi monster va chạm thì đổi hướng
    public void moveMonster() {
        for (int i = arrMonster.size() - 1; i >= 0; i--) {
            if (arrMonster.get(i).move(count, arrBox, arrBomb, arrMonster) == false) {
                int orient = random.nextInt(4);
                arrMonster.get(i).changeOrient(orient);
            }
        }
    }

    private void bombBang() {
        // tao bombang xoa bomb
        for (int i = 0; i < arrBomb.size(); i++) {
            arrBomb.get(i).deadlineBomb();
            if (arrBomb.get(i).getTimeLine() == 50) {
                BomBang bomBang = new BomBang(arrBomb.get(i).getX(), arrBomb
                        .get(i).getY(), arrBomb.get(i).getSize(), arrBox);
                arrBomBangs.add(bomBang);
                arrBomb.remove(i);
                soundManager.getSoundBomBang().play();
            }
        }

        //2 bom no gan nhau
        for (int i = 0; i < arrBomBangs.size(); i++) {
            for (int j = 0; j < arrBomb.size(); j++) {
                if (arrBomBangs.get(i).isImpactBomb(arrBomb.get(j))) {
                    BomBang bomBang = new BomBang(arrBomb.get(j).getX(),
                            arrBomb.get(j).getY(), arrBomb.get(j).getSize(), arrBox);
                    arrBomBangs.add(bomBang);
                    arrBomb.remove(j);
                }
            }
        }
        // bombang va cham monster
        for (int i = 0; i < arrBomBangs.size(); i++) {
            arrBomBangs.get(i).deadlineBomb();
            for (int j = 0; j < arrMonster.size(); j++) {
                if (arrBomBangs.get(i).isImpactActor(arrMonster.get(j))) {
                    myBomber.setScore(myBomber.getScore() + 1);
                    arrMonster.remove(j);
                    soundManager.getSoundMonster().play();
                }
            }
            if (arrBomBangs.get(i).getTimeLine() == 0) {
                arrBomBangs.remove(i);
            }
        }

        for (int j = 0; j < arrBox.size(); j++) {
            //if (arrBox.get(j).getBit() != 1 && arrShawdow.get(j).getBit() != 3) {
            for (int i = 0; i < arrBomBangs.size(); i++) {
                if (arrBomBangs.get(i).isImpactBox(arrBox.get(j))) {
                    arrBox.remove(j);
                    arrShawdow.remove(j);
                }
            }
        }
    }

    public void eatItem() {
        for (int i = 0; i < arrItem.size(); i++) {
            if (myBomber.isImpactItem(arrItem.get(i))) {
                soundManager.getSoundItem().play();
                if (arrItem.get(i).getType() == Item.ITEM_BOMB) {
                    myBomber.setQuantityBomb(myBomber.getQuantityBomb() + 1);
                    arrItem.remove(i);
                    break;
                }
                if (arrItem.get(i).getType() == Item.ITEM_BOMBSIZE) {
                    myBomber.setSizeBomb(myBomber.getSizeBomb() + 1);
                    arrItem.remove(i);
                    break;
                }
                if (arrItem.get(i).getType() == Item.ITEM_SHOE) {
                    myBomber.setSpeed(myBomber.getSpeed() - 2);
                    arrItem.remove(i);
                    break;
                }


            }
        }
    }

    public void checkWinAndLose() {
        if (myBomber.getHeart() == 0 && nextRound == 0) {
            //soundManager.getSoundBye().play();
            round = 1;
            status = 1;
            nextRound++;
            saveScore();
           // return;
        }
        if (arrMonster.size() == 0 && nextRound == 0) {
            if (round == 2) {
                status = 3;
                round = 1;
                nextRound++;
                saveScore();
                return;
            }
            round = round + 1;
            nextRound++;
            status = 2;
        }
    }

    public void checkDie(ArrayList<Monster> arrMonster, ArrayList<BomBang> arrBombBangs) {
        for (int i = 0; i < arrBombBangs.size(); i++) {
            if (arrBombBangs.get(i).isImpactActor(myBomber) && myBomber.getStatus() == Bomber.ALIVE) {
                soundManager.getSoundBomberDie().play();
                myBomber.setOrient(4);
                myBomber.setQuantityBomb(1);
                myBomber.setSizeBomb(1);
                if (myBomber.getStatus() == Bomber.DEAD) {
                    return;
                }
                myBomber.setHeart(myBomber.getHeart() - 1);
                myBomber.setStatus(Bomber.DEAD);
            }
        }
        for (int i = 0; i < arrMonster.size(); i++) {
            if (myBomber.isImpactMonster(arrMonster.get(i))) {
                soundManager.getSoundBomberDie().play();
                myBomber.setOrient(5);
                myBomber.setQuantityBomb(1);
                myBomber.setSizeBomb(1);
                if (myBomber.getStatus() == Bomber.DEAD) {
                    return;
                }
                myBomber.setHeart(myBomber.getHeart() - 1);
                myBomber.setStatus(Bomber.DEAD);
            }
        }
    }


    public boolean AI() {
        moveMonster();
        bombBang();
        checkDie(arrMonster, arrBomBangs);
        eatItem();
        checkWinAndLose();
        if (myBomber.status == Actor.DEAD) {
            timeDie++;
            if (timeDie == 2000) {
                if (round == 1) {
                    myBomber.setNew(0, FrameBomb.HEIGHT_FRAME - 100);
                    timeDie = 0;
                }else if(round==2){
                    myBomber.setNew(300, 290);
                    timeDie = 0;
                }
            }
        }
        if (status == 1) {
            timeLost++;
            if (timeLost == 2000) {
                timeLost = 0;
                panelMenu.showCardMenu();
                return false;
            }
        }
//        if (status == 2) {
//            timeNext++;
//            if (timeNext == 2000) {
//                initGame();
//                timeNext = 0;
//            }
//        }
//        if (status == 3) {
//            timeNext++;
//            if (timeNext == 2000) {
//                initGame();
//                panelMenu.showCardMenu();
//                timeNext = 0;
//            }
//        }
        count++;
        if (count == 1000000) {
            count = 0;
        }
        return true;
    }

    public int getStatus() {
        return status;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void resetGame() {
        round = 1;
        status = 0;
    }

}
