package com.thanh.gamebomb.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelHightScore extends JPanel implements ActionListener {
    private JLabel lbBackground;
    private PanelMenu panelMenu;
    private ButtonMenu btnCancel;

    public PanelHightScore(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        setLayout(null);
        initComponent();
    }

    public void initComponent() {

        btnCancel = new ButtonMenu("bt_back0.png", "bt_back1.png");
        btnCancel.setLocation(350, 480);
        add(btnCancel);
        btnCancel.addActionListener(this);

        lbBackground = new JLabel();
        ImageIcon Icon = new ImageIcon(getClass().getResource("/images/background_hightscore.png"));
        lbBackground.setBounds(0, 0, Icon.getIconWidth(), Icon.getIconHeight());
        lbBackground.setIcon(Icon);
        add(lbBackground);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            panelMenu.showCardMenu();
        }
    }
}
