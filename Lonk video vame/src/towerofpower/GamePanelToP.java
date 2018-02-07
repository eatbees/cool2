/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author josec.2020
 */
public class GamePanelToP extends JPanel{
    
    PlayerToP player;
    Layout layout;
    Timer timer;
    ArrayList<Enemy> enemy;
    //Player, 9 tower levels/floors, enemies, items, projectiles, doors, chests, text on screen, health system 
    
    GamePanelToP()
    {
        player = new PlayerToP(550, 450);
        layout = new Layout();
        enemy = new ArrayList<Enemy>();
        
        enemy.add(new Enemy());
        enemy.add(new Enemy());
        enemy.add(new Enemy());
        enemy.add(new Enemy());
        
        timer = new Timer(25, new TimerListener());
        timer.start();
    }
    
    class TimerListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.update(.025, layout);
            //goal.update(player);
            
            repaint();
        }
        
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        layout.draw(g);
        player.draw(g);
        for(int i = 0; i < 4; i++)
        {
            enemy.get(i).draw(g);
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
                player.vx = 300;   
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                player.dir = 3;
                player.vx = -300;
            }
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                player.dir = 1;
                player.vy = -300;
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                player.dir = 0;
                player.vy = 300;
            }
            player.frame = 0;
}
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
            {
                player.vx = 0;
            }
            
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
            {
                player.vy = 0;
            }
        }
    }
}
