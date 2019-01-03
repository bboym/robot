/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.io.IOException;

/**
 *
 */
public class MouseRobot {

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        Robot robot = new Robot();
        //设置Robot产生一个动作后的休眠时间,否则执行过快
        robot.setAutoDelay(500);

        //获取屏幕分辨率
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(d);
        
//        Rectangle screenRect = new Rectangle(d);
//        //截图
//        BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
//        //保存截图
//        File file = new File("screenRect.png");
//        ImageIO.write(bufferedImage, "png", file);

        //移动鼠标
        robot.mouseMove(770, 105);

        int i=0;
		//点击鼠标
        //鼠标左键
        while(i<1000000000){
        	System.out.println("单击");
             robot.mousePress(InputEvent.BUTTON1_MASK);
             robot.mouseRelease(InputEvent.BUTTON1_MASK);  
             robot.mouseMove(770, 105);
             robot.mousePress(InputEvent.BUTTON1_MASK);
             robot.mouseRelease(InputEvent.BUTTON1_MASK);  
            
        }
        
        
//        robot.mouseMove(1302, 570);
//        for(int i = 0; i < 800; i++){
//            robot.mousePress(InputEvent.BUTTON1_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_MASK);    
//        }
//        //鼠标右键
//        System.out.println("右击");
        
//        robot.mousePress(InputEvent.BUTTON3_MASK);
//        robot.mouseRelease(InputEvent.BUTTON3_MASK);
//
//        //按下ESC，退出右键状态
//        System.out.println("按下ESC");
//        robot.keyPress(KeyEvent.VK_ESCAPE);
//        robot.keyRelease(KeyEvent.VK_ESCAPE);
//        //滚动鼠标滚轴
//        System.out.println("滚轴");
//        robot.mouseWheel(5);
//
//        //按下Alt+TAB键
//        robot.keyPress(KeyEvent.VK_ALT);
//        for (int i = 1; i <= 2; i++) {
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//        }
//        robot.keyRelease(KeyEvent.VK_ALT);
    }
    

}
