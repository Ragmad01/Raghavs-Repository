/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package useballoon;
import java.awt.*;

public class Balloon {

    private int x = 50;
    private int stringX= 50 + 10;
    private int stringY = 50 + 20;
    private int stringLengthX = 275;
    private int stringLengthY = 400;
    private int y = 50;
    private int diameter = 20;
    private Color balloonColor = Color.black;


    public void moveRight(int xStep) {
        x = x + xStep;
        stringX = x + diameter/2;
    }
    public void moveLeft(int xStep) {
        x = x - xStep;
        stringX = x + diameter/2;        
    }
    public void moveUp(int yStep) {
        y = y - yStep;
        stringY = y + diameter;
    }
    public void moveDown(int yStep) {
        y = y + yStep;
        stringY = y + diameter;
    }
    
    public void changeSize(int change) {
        diameter = diameter + change;
        stringY = y + diameter;
        stringX = x + diameter/2;
    }
    
    public void setBColor (Color balloonColor){
        this.balloonColor = balloonColor;
    }

    public void display(Graphics paper) {
        paper.setColor(Color.black);
        //paper.drawOval(x, y, diameter, diameter);
        paper.setColor(balloonColor);
        paper.fillOval(x, y, diameter, diameter);
        paper.setColor(Color.black);
        paper.drawLine(stringX, stringY, stringLengthX, stringLengthY);
    }
    public int getYOfBalloon (){
        return this.y;
    }
    
}
