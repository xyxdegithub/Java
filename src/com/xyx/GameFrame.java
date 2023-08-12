package com.xyx;

import javax.swing.*;

/**
 * @author: xyx
 * @date 2022/11/2 11:40
 * @email: yx282947664@163.com
 * @description: TODO
 */
public class GameFrame extends JFrame {
    GameFrame(){
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
