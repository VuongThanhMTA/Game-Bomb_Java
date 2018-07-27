package com.thanh.gamebomb.gui;

import javax.swing.*;
import java.awt.*;


public class PanelMenu extends JPanel {

    private CardLayout mCardLayout;

    private static final String TAG_MENU = "menu";
    private static final String TAG_PLAYGAME = "playgame";
    private static final String TAG_OPTION = "option";
    private static final String TAG_HIGHTSCORE = "hightscore";

    // private FrameBomb frameBomb;
    private Menu menu;
    private PanelBomb panelBomb;
    private PanelHightScore panelHightScore;
    private PanelOption panelOption;

    public PanelMenu() {
        mCardLayout = new CardLayout();
        setLayout(mCardLayout);

        panelBomb = new PanelBomb(this);
        add(panelBomb, TAG_PLAYGAME);
        menu = new Menu(this);
        add(menu, TAG_MENU);
        panelHightScore = new PanelHightScore(this);
        add(panelHightScore, TAG_HIGHTSCORE);
        panelOption = new PanelOption(this);
        add(panelOption, TAG_OPTION);
        showCardMenu();

    }

    public void showCardMenu() {
        mCardLayout.show(PanelMenu.this, TAG_MENU);
        menu.requestFocus();
    }

    public void showCardPlay() {

        mCardLayout.show(PanelMenu.this, TAG_PLAYGAME);
        panelBomb.requestFocus();

    }

    public void showCardOption() {
        mCardLayout.show(PanelMenu.this, TAG_OPTION);
        panelOption.requestFocus();
    }

    public void showCardHightScore() {
        mCardLayout.show(PanelMenu.this, TAG_HIGHTSCORE);
        panelHightScore.readFileHightScore();
        panelHightScore.requestFocus();
    }
}
