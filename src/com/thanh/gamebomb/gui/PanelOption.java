package com.thanh.gamebomb.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOption extends JPanel implements ActionListener {
    private JLabel lbBackground;
    private ButtonMenu btnBackMenu;
    private PanelMenu panelMenu;

    public PanelOption(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        setBackground(Color.orange);
        setLayout(null);
        initComponent();

    }
    public void initComponent() {

        btnBackMenu = new ButtonMenu("bt_back0.png", "bt_back1.png");
        btnBackMenu.setLocation(350, 510);
        add(btnBackMenu);
        btnBackMenu.addActionListener(this);

        lbBackground = new JLabel();
        ImageIcon Icon = new ImageIcon(getClass().getResource("/images/background_option.png"));
        lbBackground.setBounds(100, 0, Icon.getIconWidth(), Icon.getIconHeight());
        lbBackground.setIcon(Icon);
        add(lbBackground);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackMenu) {
            panelMenu.showCardMenu();
        }
    }
}
