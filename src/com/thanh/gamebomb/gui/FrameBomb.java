package com.thanh.gamebomb.gui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameBomb extends JFrame implements WindowListener {
    public static final int WIDTH_FRAME = 905;
    public static final int HEIGHT_FRAME = 610;
    private PanelBomb panelBoom;
    private PanelMenu panelMenu;
    private Menu menu;


    public FrameBomb() {
        setTitle("Boom");
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        panelMenu=new PanelMenu();
        add(panelMenu);
//        panelBoom=new PanelBomb();
//        add(panelBoom);
        setVisible(true);

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không!",
                "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            PanelBomb.IS_RUNNING = false;
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
