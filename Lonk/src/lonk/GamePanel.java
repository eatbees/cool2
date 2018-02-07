/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lonk;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        player = new Player(500, 500);
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
    
    public void paint(Graphics g)
    {
        super.paint(g);
        screen.draw(g);
        player.draw(g);
    }
    
    class KeyboardListener implements KeyListener
    {
        boolean w;
        boolean a;
        boolean s;
        boolean d;
        
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                player.dir = 2;
                player.vx = 25;
                player.update(0.25, screen);
                d = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                player.dir = 3;
                player.vx = -25;
                player.update(0.25, screen);
                a = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                player.dir = 1;
                player.vy = -25;
                player.update(0.25, screen);
                w = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                player.dir = 0;
                player.vy = 25;
                player.update(0.25, screen);
                s = true;
            }
            player.frame = 0;
}
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                w = false;
                if(s)
                {
                    player.vy = 25;
                }
                else
                {
                    player.vy = 0;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                s = false;
                if(w)
                {
                    player.vy = -25;
                }
                else
                {
                    player.vy = 0;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                a = false;
                if(d)
                {
                    player.vx = 25;
                }
                else
                {
                    player.vx = 0;
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                d = false;
                if(a)
                {
                    player.vx = -25;
                }
                else
                {
                    player.vx = 0;
                }
            }
        }
    }
}