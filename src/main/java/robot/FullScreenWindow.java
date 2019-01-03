/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JWindow;

/**
 *
 * @author zhiguoyin
 */
public class FullScreenWindow extends JWindow {


    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        FullScreenWindow fsw = new FullScreenWindow();
     
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(fsw);
        } else {
            System.out.println("Unsupported full screen.");
        }
    }

    public FullScreenWindow() {
        this.addMouseListener(new java.awt.event.MouseListener() {
            
            private int x1;
            private int x2;
            private int y1;
            private int y2;
            
            public void mouseClicked(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                if(p.x >= 5 && p.x <= 20 && p.y >= 5 && p.y <= 20){
                    quit();
                }else{
                    System.out.println("Mouse: " + p.x + ", " + p.y);
                }
            }

            public void mousePressed(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                x1 = p.x;
                y1 = p.y;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                x2 = p.x;
                y2 = p.y;
                System.out.println("P1(" + x1 + ", " + y1 + ")");
                System.out.println("P2(" + x2 + ", " + y2 + ")");
                System.out.println("WH(" + Math.abs(x1 - x2) + ", " + Math.abs(y2 - y1)+ ")");
                
            }

            public void mouseEntered(MouseEvent e) {}

            public void mouseExited(MouseEvent e) {}

        });
        
        this.addMouseMotionListener(new java.awt.event.MouseMotionListener() {

            public void mouseDragged(MouseEvent e) {}

            public void mouseMoved(MouseEvent e) {}
        });
        
    }

    public void quit() {
        this.dispose();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(30, 80, 3, 18));
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        g.setColor(new Color(255, 0, 0, 70));
        g.fillRect(5, 5, 20, 20);
    }
}