/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package useballoon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UseBalloon extends JFrame implements ActionListener {

    private JButton growButton, rightButton, redButton, blueButton, greenButton, blackButton, orangeButton, leftButton, upButton, downButton;
    private JPanel panel;
    
    private Balloon balloon;

    public static void main(String[] args) {
        UseBalloon demo = new UseBalloon();
        demo.setSize(600,600);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(550, 400));
        panel.setBackground(Color.white);
        window.add(panel);

        rightButton = new JButton("move right");
        window.add(rightButton);
        rightButton.addActionListener(this);
        
        leftButton = new JButton("move left");
        window.add(leftButton);
        leftButton.addActionListener(this);
        
        upButton = new JButton("move up");
        window.add(upButton);
        upButton.addActionListener(this);
        
        downButton = new JButton("move down");
        window.add(downButton);
        downButton.addActionListener(this);
        
        growButton = new JButton("grow");
        window.add(growButton);
        growButton.addActionListener(this);

        redButton = new JButton("red");
        window.add(redButton);
        redButton.setBackground(Color.red);
        redButton.addActionListener(this);
        
        blueButton = new JButton("blue");
        window.add(blueButton);
        blueButton.setBackground(Color.blue);
        blueButton.addActionListener(this);
        
        greenButton = new JButton("green");
        window.add(greenButton);
        greenButton.setBackground(Color.green);
        greenButton.addActionListener(this);
        
        blackButton = new JButton("black");
        window.add(blackButton);
        blackButton.setBackground(Color.black);
        blackButton.addActionListener(this);
        
        orangeButton = new JButton("orange");
        window.add(orangeButton);
        orangeButton.setBackground(Color.orange);
        orangeButton.addActionListener(this);

        balloon = new Balloon();
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        if (event.getSource() == rightButton) {
            balloon.moveRight(20);
        }
        if (event.getSource() == leftButton) {
            balloon.moveLeft(20);
        }
        if (event.getSource() == upButton) {
            balloon.moveUp(20);
        }
        if (event.getSource() == downButton) {
            balloon.moveDown(20);
        }
        else if (event.getSource() == growButton) {
            balloon.changeSize(20);
        }
        else if(event.getSource() == redButton){
            balloon.setBColor(Color.red);
        }
        else if(event.getSource() == blueButton){
            balloon.setBColor(Color.blue);
        }
        else if(event.getSource() == greenButton){
            balloon.setBColor(Color.green);
        }
        else if(event.getSource() == orangeButton){
            balloon.setBColor(Color.orange);
        }
        else if(event.getSource() == blackButton){
            balloon.setBColor(Color.black);
        }
        paper.setColor(Color.white);
        paper.fillRect(0, 0, 550, 400);
        balloon.display(paper);
    }
}
