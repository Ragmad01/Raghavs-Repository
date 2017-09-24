/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.Random;
/**
 *
 * @author venra
 */
public class Stopwatch {
static Frame myFrame;
static Graphics myGraphics;
static Timer myTimer;
static String [] Seconds;
static String [] Minutes;
static int countdown;
static int minutesUp;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        myFrame = new Frame();
        myFrame.setSize(800, 800);
        myFrame.setTitle("TicTacToe Grid");
        myFrame.setVisible(true);
        myGraphics = myFrame.getGraphics();
        Seconds = new String [61];
        Seconds [0] = "00";
        Seconds [1] = "01";
        Seconds [2] = "02";
        Seconds [3] = "03";
        Seconds [4] = "04";
        Seconds [5] = "05";
        Seconds [6] = "06";
        Seconds [7] = "07";
        Seconds [8] = "08";
        Seconds [9] = "09";
        Seconds [10] = "10";
        Seconds [11] = "11";
        Seconds [12] = "12";
        Seconds [13] = "13";
        Seconds [14] = "14";
        Seconds [15] = "15";
        Seconds [16] = "16";
        Seconds [17] = "17";
        Seconds [18] = "18";
        Seconds [19] = "19";
        Seconds [20] = "20";
        Seconds [21] = "21";
        Seconds [22] = "22";
        Seconds [23] = "23";
        Seconds [24] = "24";
        Seconds [25] = "25";
        Seconds [26] = "26";
        Seconds [27] = "27";
        Seconds [28] = "28";
        Seconds [29] = "29";
        Seconds [30] = "30";
        Seconds [31] = "31";
        Seconds [32] = "32";
        Seconds [33] = "33";
        Seconds [34] = "34";
        Seconds [35] = "35";
        Seconds [36] = "36";
        Seconds [37] = "37";
        Seconds [38] = "38";
        Seconds [39] = "39";
        Seconds [40] = "40";
        Seconds [41] = "41";
        Seconds [42] = "42";
        Seconds [43] = "43";
        Seconds [44] = "44";
        Seconds [45] = "45";
        Seconds [46] = "46";
        Seconds [47] = "47";
        Seconds [48] = "48";
        Seconds [49] = "49";
        Seconds [50] = "50";
        Seconds [51] = "51";
        Seconds [52] = "52";
        Seconds [53] = "53";
        Seconds [54] = "54";
        Seconds [55] = "55";
        Seconds [56] = "56";
        Seconds [57] = "57";
        Seconds [58] = "58";
        Seconds [59] = "59";
        Seconds [60] = "60";
        Minutes = new String [61];
        Minutes [0] = "00";
        Minutes [1] = "01";
        Minutes [2] = "02";
        Minutes [3] = "03";
        Minutes [4] = "04";
        Minutes [5] = "05";
        Minutes [6] = "06";
        Minutes [7] = "07";
        Minutes [8] = "08";
        Minutes [9] = "09";
        Minutes [10] = "10";
        Minutes [11] = "11";
        Minutes [12] = "12";
        Minutes [13] = "13";
        Minutes [14] = "14";
        Minutes [15] = "15";
        Minutes [16] = "16";
        Minutes [17] = "17";
        Minutes [18] = "18";
        Minutes [19] = "19";
        Minutes [20] = "20";
        Minutes [21] = "21";
        Minutes [22] = "22";
        Minutes [23] = "23";
        Minutes [24] = "24";
        Minutes [25] = "25";
        Minutes [26] = "26";
        Minutes [27] = "27";
        Minutes [28] = "28";
        Minutes [29] = "29";
        Minutes [30] = "30";
        Minutes [31] = "31";
        Minutes [32] = "32";
        Minutes [33] = "33";
        Minutes [34] = "34";
        Minutes [35] = "35";
        Minutes [36] = "36";
        Minutes [37] = "37";
        Minutes [38] = "38";
        Minutes [39] = "39";
        Minutes [40] = "40";
        Minutes [41] = "41";
        Minutes [42] = "42";
        Minutes [43] = "43";
        Minutes [44] = "44";
        Minutes [45] = "45";
        Minutes [46] = "46";
        Minutes [47] = "47";
        Minutes [48] = "48";
        Minutes [49] = "49";
        Minutes [50] = "50";
        Minutes [51] = "51";
        Minutes [52] = "52";
        Minutes [53] = "53";
        Minutes [54] = "54";
        Minutes [55] = "55";
        Minutes [56] = "56";
        Minutes [57] = "57";
        Minutes [58] = "58";
        Minutes [59] = "59";
        Minutes [60] = "60";
        myTimer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                myGraphics.clearRect(250, 325, 300, 80);
                if (countdown == 60){
                    minutesUp++;
                }
                if(countdown == 61){
                    countdown = 0;
                }
                myGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                myGraphics.drawString(Seconds[countdown], 400,400 );
                myGraphics.drawString(Minutes[minutesUp], 280,400 );
                myGraphics.drawString(":", 385, 400);
                countdown++;
            }
    });
        myFrame.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                myGraphics.setColor(Color.black);
                myGraphics.fillRect(150, 150, 500, 500);
                myGraphics.setColor(Color.red);
                myGraphics.fillRect(450, 500, 100, 50);//stop
                myGraphics.setColor(Color.green);
                myGraphics.fillRect(250, 500, 100, 50);//start
                myGraphics.setColor(Color.black);
                myGraphics.setFont(new Font("Ariel", Font.PLAIN, 40));
                myGraphics.drawString("Start", 255, 540);
                myGraphics.drawString("Stop", 460, 540);
                myGraphics.setColor(Color.blue);
                if(e.getX() > 250 && e.getY() > 500){
                    if(e.getX() < 350 && e.getY() < 550){
                        myTimer.start();
                    }
                }
                else if(e.getX() > 450 && e.getY() > 500){
                    if(e.getX() < 550 && e.getY() < 550){
                            myTimer.stop();
                    }
                }
            }
        });
        myFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
