package com.thanh.gamebomb.gui;

import com.thanh.gamebomb.model.Actor;
import com.thanh.gamebomb.model.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBomb extends JPanel implements Runnable {
    private boolean IS_RUNNING;

    public boolean isIS_RUNNING() {
        return IS_RUNNING;
    }

    public void setIS_RUNNING(boolean IS_RUNNING) {
        this.IS_RUNNING = IS_RUNNING;
    }

    private GameManager gameManager;// = new GameManager();
    private boolean flag[] = new boolean[256];
    private ButtonMenu btnMenu;
    private JButton btn_Pause;
    private ButtonMenu btnNewGame;
    private PanelMenu panelMenu;
    private boolean isPause;
    private boolean statusPause;
    private Thread thread;
    private int timeNext = 0;

    public PanelBomb(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
        setLayout(null);
        //setBackground(Color.gray);

        startThread();
    }

    public void startThread() {
        gameManager = new GameManager();
        //gameManager.initGame();
        setFocusable(true);
        addKeyListener(keyListener);

        initComponent();
        IS_RUNNING = true;
        isPause = false;
        statusPause = false;
        thread = new Thread(this);
        thread.start();
    }

    public void initComponent() {
        btnMenu = new ButtonMenu("button_menu.png", "button_menu1.png");
        btnMenu.setLocation(700, 490);
        btnMenu.addActionListener(actionListener);
        btnMenu.setFocusable(false);
        add(btnMenu);

        btn_Pause = new JButton();
        ImageIcon imgNormal = new ImageIcon(getClass().getResource("/images/button_pause.png"));
        btn_Pause.setIcon(imgNormal);
        btn_Pause.setSize(imgNormal.getIconWidth(), imgNormal.getIconHeight());
        btn_Pause.setLocation(700, 390);
        btn_Pause.addActionListener(actionListener);
        btn_Pause.setFocusable(false);
        add(btn_Pause);

//        btnNewGame = new ButtonMenu("button_new-game.png", "button_new-game 1.png");
//        btnNewGame.setLocation(700, 290);
//        btnNewGame.addActionListener(actionListener);
//        btnNewGame.setFocusable(false);
//        add(btnNewGame);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        gameManager.draw(g2d);
        if (gameManager.getStatus() == 1) {
            gameManager.drawDialog(g2d, 1);
        }
        if (gameManager.getStatus() == 2) {
            gameManager.drawDialog(g2d, 2);
        }
        if (gameManager.getStatus() == 3) {
            gameManager.drawDialog(g2d, 3);
        }
    }

    KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            flag[e.getKeyCode()] = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            flag[e.getKeyCode()] = false;
        }
    };


    @Override
    public void run() {
        while (IS_RUNNING) {
            if (isPause == false) {
                if (flag[KeyEvent.VK_LEFT] == true) {
                    gameManager.moveBomber(Actor.LEFT);
                } else if (flag[KeyEvent.VK_RIGHT] == true) {
                    gameManager.moveBomber(Actor.RIGHT);
                } else if (flag[KeyEvent.VK_UP] == true) {
                    gameManager.moveBomber(Actor.UP);
                } else if (flag[KeyEvent.VK_DOWN] == true) {
                    gameManager.moveBomber(Actor.DOWN);
                }
                if (flag[KeyEvent.VK_SPACE] == true) {
                    gameManager.innitBomb();
                }
                if (gameManager.getStatus() == 2) {
                    timeNext++;
                    if (timeNext == 2000) {
                        gameManager.initGame();
                        timeNext = 0;
                    }
                }
                if (gameManager.getStatus() == 3) {
                    timeNext++;
                    if (timeNext == 2000) {
                        gameManager.initGame();
                        panelMenu.showCardMenu();
                        timeNext = 0;
                    }
                }
                boolean check = gameManager.AI();
                repaint();
                if (check == false) {
                    int result = JOptionPane.showConfirmDialog(null, "Do you want to replay?",
                            "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.NO_OPTION) {
                        // IS_RUNNING = false;
                        // gameManager.saveScore();
                        isPause = true;
                        panelMenu.showCardMenu();
                    }
                    gameManager.initGame();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn_Pause) {
                if (isPause == false) {
                    ImageIcon img = new ImageIcon(getClass().getResource("/images/button_resume.png"));
                    btn_Pause.setIcon(img);
                    isPause = true;
                    // statusPause = true;
                } else {
                    ImageIcon img = new ImageIcon(getClass().getResource("/images/button_pause.png"));
                    btn_Pause.setIcon(img);
                    isPause = false;
                    // statusPause = false;
                }
            } else if (e.getSource() == btnMenu) {
                ImageIcon img = new ImageIcon(getClass().getResource("/images/button_resume.png"));
                btn_Pause.setIcon(img);
                isPause = true;
                panelMenu.showCardMenu();
            }
//            else if(e.getSource()==btnNewGame){
//                gameManager.resetGame();
//                gameManager.initGame();
//            }
        }
    };
}
