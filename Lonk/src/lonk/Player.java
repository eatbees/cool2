/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lonk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author Egg
 */
public class Player {
    double x;
    double y;
    double vx;
    double vy;
    static Image idle;
    static Image idle1;
    static Image idle2;
    static Image[] walkdown;
    static Image[] walkside;
    double frame; // which frame of animation we're on
    int dir; // 0 means down, 1 means up, 2 means right, 3 means left
    static Image[] walkup;
    
    Player(double x, double y){
        this.x = x;
        this.y = y;
        if(idle == null)
        {
            try {
               
                idle = ImageIO.read(new File("walkdown2.png"));
                idle1 = ImageIO.read(new File("walkup3.png"));
                idle2 = ImageIO.read(new File("idleside.png"));
                walkdown = new Image[7];
                walkdown[0] = ImageIO.read(new File("walkdown.png"));
                walkdown[1] = ImageIO.read(new File("walkdown3.png"));
                walkdown[2] = ImageIO.read(new File("walkdown4.png"));
                walkdown[3] = ImageIO.read(new File("walkdown5.png"));
                walkdown[4] = ImageIO.read(new File("walkdown6.png"));
                walkdown[5] = ImageIO.read(new File("walkdown7.png"));
                walkdown[6] = ImageIO.read(new File("walkdown8.png"));  
                walkside = new Image[5];
                walkside[0] = ImageIO.read(new File("walkside1.png"));  
                walkside[1] = ImageIO.read(new File("walkside2.png"));  
                walkside[2] = ImageIO.read(new File("walkside3.png"));  
                walkside[3] = ImageIO.read(new File("walkside4.png"));  
                walkside[4] = ImageIO.read(new File("walkside5.png"));  
                walkup = new Image[8];
                walkup[0] = ImageIO.read(new File("walkup1.png"));
                walkup[1] = ImageIO.read(new File("walkup2.png"));
                walkup[2] = ImageIO.read(new File("walkup3.png"));
                walkup[3] = ImageIO.read(new File("walkup4.png"));
                walkup[4] = ImageIO.read(new File("walkup5.png"));
                walkup[5] = ImageIO.read(new File("walkup6.png"));
                walkup[6] = ImageIO.read(new File("walkup7.png"));
                walkup[7] = ImageIO.read(new File("walkup8.png"));
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void update(double time, Screen screen){
        //frame += 17 * time;
        //if(dir == 0 && (int)frame > 6 || dir == 1 && (int)frame > 7 || (dir == 2 || dir == 3) && (int)frame > 3)
        //{
        //    frame = 0;
        //}
        //if(!screen.collision(x + (vx * time), y - (vy * time)) && vy < 0)
        //{
            y += vy * time;
        //}
        //if(!screen.collision(x + (vx * time), y - (vy * time)) && vx > 0)
        //{
            x += vx * time;
        //}
        //else
        //{
            //vx = 0;
            //vy = 0;
        //}
    }
    
    void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x, (int)y, 40, 40);
    }
}