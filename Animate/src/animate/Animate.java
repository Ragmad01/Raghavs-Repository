/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Random;
/**
 *
 * @author venra
 */
public class Animate {
static Frame myFrame;
static Timer myTimer;
static int objectY;
static int objectVert;
static int objectHori;
static boolean playerBlue;
static boolean playerRed;
static int num;
static int rectX = 100;
static int rectY = 710;
static int rectW = 50;
static int rectH = 10;
static int rect2X = 10;
static int rect2Y = 40;
static int rect2W = 50;
static int rect2H = 10;
static int objectX = 75;
static int objectW = 10;
static int objectH = 10;
static int blueScore;
static int redScore;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create Frame
        myFrame = new Frame();
        myFrame.setSize(450,735);
        myFrame.setTitle("Animation");
        myFrame.setVisible(true);
        Graphics myGraphics = myFrame.getGraphics();
        myGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        myGraphics.drawString("Click on frame too start", 60, 250);
        //creat timer
        myTimer = new Timer(100, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean collision;
                boolean collision2;
                Graphics myGraphics = myFrame.getGraphics();
                myGraphics.clearRect(objectX,objectY,objectW,objectH);
                int [] dir = new int[2];
                dir [0] = 1;
                dir [1] = -1;
                Random myRandom = new Random();
                num = myRandom.nextInt(2);
                objectHori = dir[num];
                objectY = objectY + objectVert * 10;
                objectX = objectX + objectHori * 10;
                collision = false;
                collision2 = false;
                if ((objectX + objectW) > rectX){
                    if (objectX < (rectX + rectW)){
                        if ((objectY + objectH) > rectY){
                            if (objectY < (rectY + rectH)){
                                collision = true;
                                playerBlue = true;
                            }
                        }
                    }
                }
                if ((objectX + objectW) > rect2X){
                    if (objectX < (rect2X + rect2W)){
                        if ((objectY + objectH) > rect2Y){
                            if (objectY < (rect2Y + rect2H)){
                                collision2 = true;
                                playerRed = true;
                            }
                        }
                    }
                }
                if (playerBlue = true){
                    blueScore++;
                }
                if (playerRed = true){
                    redScore++;
                }
                if (collision){
                    objectY = rectY - objectH;
                    objectVert = -1;
                    Toolkit.getDefaultToolkit().beep();
                }
                else if(collision2){
                    objectY = rect2Y + objectH;
                    objectVert = 1;
                    Toolkit.getDefaultToolkit().beep();
                }
                //left border
                else if (objectX < 0){
                    objectX = 0;
                    objectHori = -num;
                    Toolkit.getDefaultToolkit().beep();
                }
                //right border
                else if ((objectX + objectW) > myFrame.getWidth()){
                    objectX = myFrame.getWidth() - objectW;
                    objectHori = -num;
                }
                myGraphics.setColor(Color.red);
                myGraphics.fillOval(objectX, objectY, objectW, objectH);
                // Loser message
                if (objectY < 0){
                    myGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    myGraphics.drawString("Red player looses", 60, 250);
                }
                else if(objectY > 735){
                    myGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    myGraphics.drawString("Blue player looses", 60, 250);
                }
            }
        });
        
        //add listener for mouse press
        myFrame.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                myGraphics.clearRect(0, 0, 1000, 1000);
                myGraphics.setColor(Color.blue);
                myGraphics.fillRect(rectX, rectY, rectW, rectH);
                myGraphics.setColor(Color.red);
                myGraphics.fillRect(rect2X, rect2Y, rect2W, rect2H);
                myGraphics.setColor(Color.white);
                myGraphics.fillRect(100, 250, 100, 100);
                objectY = 0;
                objectVert = 1;
                if (myTimer.isRunning()){
                    myTimer.stop();
                }
                else{
                    myTimer.start();
                }
            }
        });
        //add listener for key press
        myFrame.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                Graphics myGraphics = myFrame.getGraphics();
                //erase rectangle
                myGraphics.clearRect(rectX, rectY, rectW, rectH);
                //erase player 2 rectangle
                myGraphics.clearRect(rect2X, rect2Y, rect2W, rect2H);
                if (e.getKeyCode() == e.VK_RIGHT){
                    rectX = rectX + 10;
                }
                else if (e.getKeyCode() == e.VK_LEFT){
                    rectX = rectX - 10;
                }
                if(e.getKeyCode() == e.VK_A){
                    rect2X = rect2X - 10;
                }
                else if (e.getKeyCode() == e.VK_D){
                    rect2X = rect2X + 10;
                }  
                //redraw rectangle
                myGraphics.setColor(Color.blue);
                myGraphics.fillRect(rectX, rectY, rectW, rectH);
                //redraw player 2 rectangle
                myGraphics.setColor(Color.red);
                myGraphics.fillRect(rect2X, rect2Y, rect2W, rect2H);
            }
        });
        
        //add listener for closing frame
        myFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    
}
