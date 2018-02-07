/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author josec.2020
 */
public class Enemy {
    double x;
    double y;
    double speed;
    double angle;
    Random r;
    
    Enemy()
    {
        r = new Random();
        x = r.nextInt(800);
        y = r.nextInt(600);
        angle = r.nextDouble() * 2 * Math.PI; //0 - 2pi
        speed = 100;
    }
    
    void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval((int)x, (int)y, 20, 20);
    }
    
    double distanceTo(PlayerToP p)
    {
        return Math.sqrt((p.x - x)*(p.x-x) + (p.y - y)*(p.y-y));
    }
}
