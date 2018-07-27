package com.thanh.gamebomb.gui;

import com.thanh.gamebomb.model.Box;
import com.thanh.gamebomb.model.HightScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class PanelHightScore extends JPanel implements ActionListener {
    private JLabel lbBackground;
    private PanelMenu panelMenu;
    private ButtonMenu btnCancel;
    private ArrayList<HightScore> arrHightScore;


    public PanelHightScore(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        setLayout(null);
        initComponent();

    }

    public void initComponent() {
        readFileHightScore();
        btnCancel = new ButtonMenu("bt_back0.png", "bt_back1.png");
        btnCancel.setLocation(350, 480);
        add(btnCancel);
        btnCancel.addActionListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        Image img = new ImageIcon(getClass().getResource("/images/background_hightscore.png")).getImage();
        g2d.drawImage(img, 0, 0, null);

        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(Color.YELLOW);
        g2d.drawString("Hight Score",300,50);
        int y = 100;
        for (int i = 0; i < arrHightScore.size(); i++) {
            g2d.drawString("" + (i + 1), 270, y);
            g2d.drawString("" + arrHightScore.get(i).getName(), 380, y);
            g2d.drawString("" + arrHightScore.get(i).getScore(), 600, y);
            y = y + 40;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            panelMenu.showCardMenu();
        }
    }


    public void readFileHightScore() {
        arrHightScore = new ArrayList<>();
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
}
