/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import sun.misc.ThreadGroupUtils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 */
public class RobotUtils {
    
    private static Robot robot;
    private static Random rnd;
    private static int width;
    private static int height;
    private static int delayTime = 50;
    
    static{
        try {
            Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
            rnd = new Random();
            width = scr.width;
            height = scr.height;
            robot = new Robot();
            robot.setAutoDelay(500);
            
            System.out.println("屏幕分辨率：[" + width + ", " + height + "]");
            
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    private RobotUtils(){}
    
    public static void main(String[] args) throws InterruptedException {
        RobotUtils.leftClick(571, 671);


        while(true){
            Thread.sleep(1000);
        RobotUtils.ctrlv();
            RobotUtils.enter();
        Point mousepoint = MouseInfo.getPointerInfo().getLocation();
        System.out.println(mousepoint.x+"  "+mousepoint.y);
    }}
    
    public static void fetchScreen(File dir, Point leftTop, Dimension size, String info, int index){
        Rectangle screenRect = new Rectangle(leftTop, size);
        //截图
        BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
        //保存截图
        File file = new File(dir, info + "_" + index + ".png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
        	System.out.println("截图是发生错误！");
        }
    }
    
    public static int getScreenWidth(){
        return width;
    }
    
    public static int getScreenHeight(){
        return height;
    }
    
    public static void setDelayTime(int time){
        delayTime = time;
    }
    
    private static int randomDelay(){
        return delayTime + rnd.nextInt(300);
    }
    
    public static void delay(int delay){
        robot.delay(delay);
    }
    
    /**
     * 鼠标移动到屏幕的指定位置。
     * @param x
     * @param y 
     */
    public static void move(int x, int y){
        robot.mouseMove(x, y);
        robot.delay(randomDelay());
    }
    
    /**
     * 鼠标滚动指定刻度
     * @param number 
     */
    public static void wheel(int number){
        robot.mouseWheel(number);
        robot.delay(randomDelay());
    }
    
    public static void ctrlc(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    
    public static void ctrlv(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    
    public static void ctrla(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    public static void enter(){
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(20);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    /**
     * 
     * @param x
     * @param y 
     */
    public static void leftClick(int x, int y){
        //移动鼠标
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    public static void rightClick(int x, int y){
        //移动鼠标
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }
    
    public static void dragged(int x1, int y1, int x2, int y2){
        robot.mouseMove(x1, y1);//移动鼠标到(10,20)点
        robot.mousePress(InputEvent.BUTTON1_MASK);//按下左键
        robot.delay(100);//停顿100ms
        robot.mouseMove(x2, y2);//移动鼠标到(100,200)点
        robot.mouseRelease(InputEvent.BUTTON1_MASK);//释放左键
    }
}
