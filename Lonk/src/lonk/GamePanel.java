/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lonk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Egg
 */
public class GamePanel extends JPanel{
    Player player;
    Screen screen;
    Timer timer;
    
    GamePanel(){
        player = new Player(550, 450);
        screen = new Screen();
        
        timer = new Timer(25, new TimerListener());
        timer.start();
    }
    
    class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            player.update(0.25, screen);
            
            repaint();
        }
    }
    
    class KeyboardListener implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                player.dir = 2;
                player.x += 50;   
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                player.dir = 3;
                player.x -= -50;
            }
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                player.dir = 1;
                player.y = -50;
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                player.dir = 0;
                player.y = 50;
            }
            player.frame = 0;
}
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}