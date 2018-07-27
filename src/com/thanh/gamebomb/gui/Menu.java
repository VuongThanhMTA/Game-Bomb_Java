package com.thanh.gamebomb.gui;

import com.thanh.gamebomb.model.GameManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JPanel implements ActionListener {

    private PanelMenu panelMenu;

    private ButtonMenu btnPlay;
    private ButtonMenu btnOption;
    private ButtonMenu btnHightScore;
    private ButtonMenu btnExit;

    private JLabel lbbackground;

    public Menu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;

        setLayout(null);
        initComponent();

    }

    public void initComponent() {
        //
        btnPlay = new ButtonMenu("Play.png", "Play2.png");
        btnPlay.setLocation(350, 100);
        add(btnPlay);
        btnPlay.addActionListener(this);
        //
        btnOption = new ButtonMenu("Option.png", "Option2.png");
        btnOption.setLocation(350, 170);
        btnOption.addActionListener(this);
        add(btnOption);
        //
        btnHightScore = new ButtonMenu("HightScore.png", "HightScore2.png");
        btnHightScore.setLocation(350, 230);
        btnHightScore.addActionListener(this);
        add(btnHightScore);
        //
        btnExit = new ButtonMenu("Exit.png", "Exit2.png");
        btnExit.setLocation(350, 300);
        btnExit.addActionListener(this);
        add(btnExit);
        //
        lbbackground = setLabel(0, -40, "/images/background_Menu.png");
        add(lbbackground);
    }

    public JLabel setLabel(int x, int y, String ImageIcon) {
        JLabel label = new JLabel();
        ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
        label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
        label.setIcon(Icon);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlay) {
            panelMenu.showCardPlay();
        } else if (e.getSource() == btnHightScore) {
            panelMenu.showCardHightScore();
        } else if (e.getSource() == btnOption) {
            panelMenu.showCardOption();
        } else if (e.getSource() == btnExit) {
          //  PanelBomb.IS_RUNNING = false;
            System.exit(0);
        }
    }
}
