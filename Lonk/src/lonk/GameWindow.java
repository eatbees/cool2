/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lonk;

import javax.swing.JFrame;

/**
 *
 * @author Egg
 */
public class GameWindow extends JFrame{
    GameWindow(){
        setTitle("Lonk");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        add(panel);
        addKeyListener(panel.new KeyboardListener());
        setVisible(true);
    }
}