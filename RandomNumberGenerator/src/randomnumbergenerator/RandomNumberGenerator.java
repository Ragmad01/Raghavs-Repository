/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbergenerator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;
/**
 *
 * @author venra
 */
public class RandomNumberGenerator extends JFrame {
    JLabel randomNumberLabel = new JLabel();
    JTextField showNumber = new JTextField();
    JButton generateButton = new JButton();
    Random myRandom = new Random();
    String theNumber;
    public static void main(String[] args) {
        //construct frame
        new RandomNumberGenerator().show();
    }
    public RandomNumberGenerator(){
    //code to build frame
    setTitle("Generate a Random Number");
    getContentPane().setBackground(Color.RED);
    setResizable(false);
    addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    });
    getContentPane().setLayout(new GridBagLayout());
    //position controls
    GridBagConstraints gridConstraints;
        randomNumberLabel.setText("Click to generate!");
        randomNumberLabel.setOpaque(true);
        randomNumberLabel.setBackground(Color.white);
        randomNumberLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        randomNumberLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        
        randomNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 30;
        gridConstraints.ipady = 20;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane(). add(randomNumberLabel, gridConstraints);
        
        showNumber.setText("");
        showNumber.setFont(new Font ("Arial", Font.PLAIN, 14));
        showNumber.setColumns(3);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(showNumber, gridConstraints);
        
        generateButton.setText("Generate");
        generateButton.setFont(new Font ("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(generateButton, gridConstraints);
        generateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                generateButtonActionPerformed(e);
            }
        });
    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
}
    private void generateButtonActionPerformed(ActionEvent e){
        int num = myRandom.nextInt(100) + 1;
        theNumber = String.valueOf(num);
        showNumber.setText(theNumber);
    }
}
