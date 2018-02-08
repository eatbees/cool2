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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author Egg
 */
public class Player {
    boolean attacking;
    int dir; // 0 means down, 1 means up, 2 means right, 3 means left
    int acounter;
    double x;
    double y;
    double vx;
    double vy;
    double frame; // which frame of animation we're on
    static Image idle;
    static Image idle1;
    static Image idle2;
    static Image[] walkdown;
    static Image[] walkside;
    static Image[] walkup;
    static Image[] attackup;
    static Image[] attackdown;
    static Image[] attackside;
    AudioInputStream audioInputStream;
    Clip hit;
    
    Player(double x, double y){
        this.x = x;
        this.y = y;
        if(idle == null)
        {
            try {
                idle = ImageIO.read(new File("walkdown2.png"));
                idle1 = ImageIO.read(new File("walkup8.png"));
                idle2 = ImageIO.read(new File("idleside.png"));
                
                walkdown = new Image[8];
                walkup = new Image[8];
                for(int i = 1; i < 9; i++)
                {
                    walkdown[i - 1] = ImageIO.read(new File("walkdown" + i + ".png"));
                    walkup[i - 1] = ImageIO.read(new File("walkup" + i + ".png"));
                }
                
                walkside = new Image[5];
                attackup = new Image[5];
                //attackdown = new Image[5];
                //attackside = new Image[5];
                for(int i = 1; i < 6; i++)
                {
                    attackup[i - 1] = ImageIO.read(new File("attackup" + i + ".png"));
                    //attackdown[i - 1] = ImageIO.read(new File("attackdown" + i + ".png"));
                    //attackside[i - 1] = ImageIO.read(new File("attackside" + i + ".png"));
                    walkside[i - 1] = ImageIO.read(new File("walkside" + i + ".png")); 
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void attack()
    {
        vx = 0;
        vy = 0;
        playHitSound();
        attacking = true;
    }
    
    public void playHitSound()
    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("hit.wav"));
            hit = AudioSystem.getClip();
            hit.open(audioInputStream);
            FloatControl gainControl = (FloatControl) hit.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(6.0206f);
            hit.start();
        } catch(IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("Error with playing sound.");
        }
    }
    
    void update(double time, Screen screen){
        frame += .25;
        if(dir == 0 && (int)frame > 6 || dir == 1 && (int)frame > 6 || (dir == 2 || dir == 3) && (int)frame > 3 || attacking && (int)frame == 5)
        {
            frame = 0;
            if(attacking)
            {
                attacking = false;
            }
        }
        if(!screen.collision(x, y + (vy * time) + 2) && vy < 0)
        {
            y += vy * time;
        }
        else if(!screen.collision(x, y + 87 + (vy * time)) && vy > 0)
        {
            y += vy * time;
        }
        else
        {
            vy = 0;
        }
        
        if(!screen.collision(x + (vx * time), y) && vx < 0)
        {
            x += vx * time;
        }
        else if(!screen.collision(x + 64 + (vx * time), y) && vx > 0)
        {
            x += vx * time;
        }
        else
        {
            vx = 0;
        }
    }
    
    void draw(Graphics g)
    {
        if(vx == 0 && vy == 0) // if we're not moving at all)
        {
            if(attacking)
            {
//                if(dir == 0)
//                {
//                    g.drawImage(attackdown[(int)frame], (int)x, (int)y, 16 * 4, 22 * 4, null);
//                }
                if(dir == 1)
                {
                    g.drawImage(attackup[(int)frame], (int)x, (int)y, 16 * 4, 22 * 4, null);
                }
//                if(dir == 3)
//                {
//                    g.drawImage(attackside[(int)frame], (int)x, (int)y, 16 * 4, 22 * 4, null);
//                }
//                if(dir == 2)
//                {
//                    g.drawImage(attackside[(int)frame], (int)x + 16 * 4, (int)y, -16 * 4, 22 * 4, null);
//                }
            }
            else
            {
                //choose which idle image it should be
                if(dir == 0)
                {
                    g.drawImage(idle, (int)x, (int)y, 16 * 4, 22 * 4, null);
                }
                if(dir == 1)
                {
                    g.drawImage(idle1, (int)x, (int)y, 16 * 4, 22 * 4, null);
                }
                if(dir == 3)
                {
                    g.drawImage(idle2, (int)x, (int)y, 16 * 4, 22 * 4, null);
                }
                if(dir == 2)
                {
                    g.drawImage(idle2, (int)x + 16 * 4, (int)y, -16 * 4, 22 * 4, null);
                }
            }
        }
        else
        {
       
            //g.drawImage(idle, (int)x, (int)y, 16 * 4, 22 * 4, null);
            if(dir == 0)
            {
                g.drawImage(walkdown[(int)frame], (int)x, (int)y, 16 * 4, 22 * 4, null);
            }
            if(dir == 1)
            {
                g.drawImage(walkup[(int)frame], (int)x, (int)y, 16 * 4, 22 * 4, null);
            }
            if(dir == 3)
            {
                g.drawImage(walkside[(int)frame], (int)x, (int)y, 16 * 4, 22 * 4, null);
            }
            if(dir == 2)
            {
                g.drawImage(walkside[(int)frame], (int)x + 16 * 4, (int)y, -16 * 4, 22 * 4, null);
            }
        }
    }
}