
package shapes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shapes extends JFrame 
    implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        Shapes frame = new Shapes();
        frame.setSize(350, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        //drawSquare(paper, 60, 60, 50);
        //drawSquare(paper, 65, 65, 40);
        //drawTriangle(paper, 100, 100, 30, 30);
        drawHouse(paper);
        
    }
    
    private void drawSquare(Graphics paper, int xPos, int yPos, int size){
        paper.drawRect(xPos, yPos, size, size);
    }
    
    private void drawTriangle(Graphics drawingArea, int xPos, int yPos, int width, int height) {
        drawingArea.drawLine(xPos, yPos, xPos, yPos + height);
        drawingArea.drawLine(xPos, yPos + height, xPos + width, yPos + height);
        drawingArea.drawLine(xPos, yPos, xPos + width, yPos + height);
    }
    
    private void drawWindow (Graphics paper, int xPos, int yPos){
        paper.drawRect(xPos, yPos, 20, 30);
        paper.drawLine(xPos + 10, yPos, xPos + 10, yPos + 30);
        paper.drawLine(xPos, yPos + 15, xPos + 20, yPos + 15);
    }
    
    private void drawHouse (Graphics paper){
        paper.drawRect(75, 99, 150, 100);
        paper.drawLine(75,99,150,29);
        paper.drawLine(150, 29, 225, 99);
        drawWindow(paper, 95, 110);
        drawWindow(paper, 140, 110);
        drawWindow(paper, 185, 110);
    }
}



