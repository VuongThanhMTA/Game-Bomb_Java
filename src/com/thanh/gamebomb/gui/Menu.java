package com.thanh.gamebomb.gui;

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
    private JLabel lbPlayGame;
    private JLabel lbOption;
    private JLabel lbHigthScore;
    private JLabel lbExit;

    public Menu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        setLayout(null);
        initComponent();

    }

    public void initComponent() {
//        lbPlayGame = setLabel(350, 100, "/images/Play.png");
//        lbOption = setLabel(350, 170, "/images/Option.png");
//        lbHigthScore = setLabel(350, 230, "/images/HightScore.png");
//        lbExit = setLabel(350, 300, "/images/Exit.png");
//
//        lbPlayGame.addMouseListener(this);
//        lbOption.addMouseListener(this);
//        lbHigthScore.addMouseListener(this);
//        lbExit.addMouseListener(this);
//        add(lbPlayGame);
//        add(lbOption);
//        add(lbHigthScore);
//        add(lbExit);
//

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

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        if (e.getSource() == lbPlayGame) {
//            panelMenu.showCardPlay();
//        }else if (e.getSource() == lbOption) {
//           // panelMenu.showCardPlay();
//        }else if (e.getSource() == lbHigthScore) {
//            //panelMenu.showCardPlay();
//        }//else if (e.getSource() == lbPlayGame) {
//
//        //}
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        if (e.getSource() == lbPlayGame) {
//            ImageIcon iconPlay = new ImageIcon(getClass().getResource("/images/Play2.png"));
//            lbPlayGame.setIcon(iconPlay);
//        }
//        if (e.getSource() == lbOption) {
//            ImageIcon iconOption = new ImageIcon(getClass().getResource("/images/Option2.png"));
//            lbOption.setIcon(iconOption);
//        }
//        if (e.getSource() == lbHigthScore) {
//            ImageIcon icon = new ImageIcon(getClass().getResource("/images/HightScore2.png"));
//            lbHigthScore.setIcon(icon);
//        }
//        if (e.getSource() == lbExit) {
//            ImageIcon icon = new ImageIcon(getClass().getResource("/images/Exit2.png"));
//            lbExit.setIcon(icon);
//        }
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        if (e.getSource() == lbPlayGame) {
//            ImageIcon iconPlay = new ImageIcon(getClass().getResource("/images/Play.png"));
//            lbPlayGame.setIcon(iconPlay);
//        }
//        if (e.getSource() == lbOption) {
//            ImageIcon iconOption = new ImageIcon(getClass().getResource("/images/Option.png"));
//            lbOption.setIcon(iconOption);
//        }
//        if (e.getSource() == lbHigthScore) {
//            ImageIcon icon = new ImageIcon(getClass().getResource("/images/HightScore.png"));
//            lbHigthScore.setIcon(icon);
//        }
//        if (e.getSource() == lbExit) {
//            ImageIcon icon = new ImageIcon(getClass().getResource("/images/Exit.png"));
//            lbExit.setIcon(icon);
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPlay) {
            panelMenu.showCardPlay();
        }
        if(e.getSource()==btnHightScore){
            panelMenu.showCardHightScore();
        }
    }
}
