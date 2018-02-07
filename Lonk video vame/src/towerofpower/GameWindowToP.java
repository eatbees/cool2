/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import javax.swing.JFrame;

/**
 *
 * @author josec.2020
 */
public class GameWindowToP extends JFrame{
    
    GameWindowToP()
    {
        setTitle("Legend of Zelda: Link to the Past Knockoff");
        setSize(1100, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GamePanelToP panel = new GamePanelToP();
        add(panel);
        addKeyListener(panel.new KeyboardListener());
        setVisible(true);
    }
    
}
