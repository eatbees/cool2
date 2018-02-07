/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author josec.2020
 */
public class Layout {
    
    boolean[][] tiles;
    
    Layout()
    {
        tiles = new boolean[26][20];
        
        //border
        for(int x = 0; x < 26; x++)
        {
            tiles[x][0] = true; 
            tiles[x][19] = true;
        }
        for(int y = 0; y < 20; y++)
        {
            tiles[0][y] = true;
            tiles[25][y] = true;
        }
        
    }
    
     void draw(Graphics g)
    {
        for(int x = 0; x < 26; x++)
        {
            for(int y = 0; y < 20; y++)
            {
                if(tiles[x][y] == true)
                {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x*40, y*40, 40, 40);
                }
                else
                {
                    g.setColor(Color.GRAY);
                    g.fillRect(x*40, y*40, 40, 40);
                }
            }
        }
    }
     
     boolean Collision(double x, double y)
    {
        
        if(tiles[(int)x / 40][(int)y / 40] == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
