package com.thanh.gamebomb.gui;

import sounds.SoundManager;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonMenu extends JButton implements MouseListener {
    private ImageIcon imgSelect;
    private ImageIcon imgNormal;
    private SoundManager soundManager = new SoundManager();

    public ButtonMenu(String normal, String select) {
        imgSelect = new ImageIcon(getClass().getResource("/images/" + select));
        imgNormal = new ImageIcon(getClass().getResource("/images/" + normal));
        setIcon(imgNormal);
        setSize(imgNormal.getIconWidth(), imgNormal.getIconHeight());
        addMouseListener(this);
    }

    public void setImgIcon(String icon){
        ImageIcon img = new ImageIcon(getClass().getResource("/images/" + icon));
        setIcon(img);
    }

    @Override
    public void mouseClicked(MouseEvent e) {//click lên
        soundManager.getSoundClick().play();
    }

    @Override
    public void mousePressed(MouseEvent e) {//

    }

    @Override
    public void mouseReleased(MouseEvent e) { //

    }

    @Override
    public void mouseEntered(MouseEvent e) {// di chuột vào vùng
        setIcon(imgSelect);
    }

    @Override
    public void mouseExited(MouseEvent e) {//di chuột ra vùng
        setIcon(imgNormal);
    }
}
