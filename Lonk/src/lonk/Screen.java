/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lonk;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Egg
 */
public class Screen {
    boolean[][] tiles;
    
    Screen(){
        tiles = new boolean[25][25];
        for(int i = 0; i < 25; i++){
            //top and bottom
            tiles[i][0] = true;
            tiles[i][24] = true;
            
            //left and right
            tiles[0][i] = true;
            tiles[24][i] = true;
        }
    }
    
    void draw(Graphics g){
        for(int x = 0; x < 25; x++)
        {
            for(int y = 0; y < 25; y++)
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
    
    boolean collision(double x, double y){
        return tiles[(int)x / 40][(int)y / 40];
    }
}