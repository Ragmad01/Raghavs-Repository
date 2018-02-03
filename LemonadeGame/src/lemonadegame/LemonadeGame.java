/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadegame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;
/**
 *
 * @author venra
 */
public class LemonadeGame extends JFrame{
    JLabel randomNumberLabel = new JLabel();
    JLabel priceValueLabel = new JLabel();
    JLabel peopleLabel = new JLabel();
    JLabel profitLabel = new JLabel();
    JLabel moneyMade = new JLabel();
    JTextField showNumber = new JTextField();
    JTextField showPrice = new JTextField();
    JTextField numOfPeople = new JTextField();
    JTextField totalProfits = new JTextField();
    JTextField totalMoneyMade = new JTextField();
    JButton generateTempButton = new JButton();
    JButton startEndDay = new JButton();
    Random myRandom = new Random();
    String theTempNumber;
    String price;
    String thePeopleNumber;
    int peopleNum;
    int tempNum;
    int numberOfDays = 20;
    double priceNum;
    double profits;
    double piggybank;
    String moneyNum;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LemonadeGame().show();
    }
    public LemonadeGame(){
    //code to build frame
    setTitle("Lemonade Game");
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
        peopleLabel.setText("Number of customers");
        peopleLabel.setOpaque(true);
        peopleLabel.setBackground(Color.white);
        peopleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        peopleLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        
        peopleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 30;
        gridConstraints.ipady = 20;
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane(). add(peopleLabel, gridConstraints);
        
        moneyMade.setText("Money made today:");
        moneyMade.setOpaque(true);
        moneyMade.setBackground(Color.white);
        moneyMade.setFont(new Font("Arial", Font.BOLD, 14));
        
        moneyMade.setBorder(BorderFactory.createLoweredBevelBorder());
        
        moneyMade.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 30;
        gridConstraints.ipady = 20;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane(). add(moneyMade, gridConstraints);
        
        profitLabel.setText("Total money in wallet");
        profitLabel.setOpaque(true);
        profitLabel.setBackground(Color.white);
        profitLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        profitLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        
        profitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 30;
        gridConstraints.ipady = 20;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane(). add(profitLabel, gridConstraints);
        
        priceValueLabel.setText("Selling Price");
        priceValueLabel.setOpaque(true);
        priceValueLabel.setBackground(Color.white);
        priceValueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        priceValueLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        
        priceValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 30;
        gridConstraints.ipady = 20;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane(). add(priceValueLabel, gridConstraints);
        
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
        
        showNumber.setHorizontalAlignment(SwingConstants.CENTER);
        showNumber.setText("");
        showNumber.setFont(new Font ("Arial", Font.PLAIN, 14));
        showNumber.setColumns(8);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(showNumber, gridConstraints);
        
        totalMoneyMade.setHorizontalAlignment(SwingConstants.CENTER);
        totalMoneyMade.setText("");
        totalMoneyMade.setFont(new Font ("Arial", Font.PLAIN, 14));
        totalMoneyMade.setColumns(8);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(totalMoneyMade, gridConstraints);
        
        numOfPeople.setHorizontalAlignment(SwingConstants.CENTER);
        numOfPeople.setText("");
        numOfPeople.setFont(new Font ("Arial", Font.PLAIN, 14));
        numOfPeople.setColumns(8);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(numOfPeople, gridConstraints);
        
        showPrice.setHorizontalAlignment(SwingConstants.CENTER);
        showPrice.setText("");
        showPrice.setFont(new Font ("Arial", Font.PLAIN, 14));
        showPrice.setColumns(8);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(showPrice, gridConstraints);
        
        totalProfits.setHorizontalAlignment(SwingConstants.CENTER);
        totalProfits.setText("");
        totalProfits.setFont(new Font ("Arial", Font.PLAIN, 14));
        totalProfits.setColumns(8);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(totalProfits, gridConstraints);
        
        generateTempButton.setText("Generate");
        generateTempButton.setFont(new Font ("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(generateTempButton, gridConstraints);
        generateTempButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                generateTempButtonActionPerformed(e);
            }
        });
        
        startEndDay.setText("Calculate profits");
        startEndDay.setFont(new Font ("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane().add(startEndDay, gridConstraints);
        startEndDay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startEndDayButtonActionPerformed(e);
            }
        });
        
    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
}
    private void generateTempButtonActionPerformed(ActionEvent e){
        if (numberOfDays >= 1){
        numberOfDays = numberOfDays - 1;
        tempNum = myRandom.nextInt(110) + 1;
        theTempNumber = String.valueOf(tempNum);
        showNumber.setText(theTempNumber + " degrees");
        
        if (tempNum > 100){
            price = "0.75$";
            priceNum = 0.75;
        }
        
        else if ((tempNum >= 96) && (tempNum <= 100)){
            price = "0.65$";
            priceNum = 0.65;
        }
        
        else if ((tempNum >= 91) && (tempNum <= 95)){
            price = "0.55$";
            priceNum = 0.55;
        }
        
        else if ((tempNum >= 86) && (tempNum <= 90)){
            price = "0.50$";
            priceNum = 0.50;
        }
        
        else if ((tempNum >= 81) && (tempNum <= 85)){
            price = "0.40$";
            priceNum = 0.40;
        }
        
        else if ((tempNum >= 71) && (tempNum <= 80)){
            price = "0.30$";
            priceNum = 0.30;
        }
        
        else if ((tempNum >= 61) && (tempNum <= 70)){
            price = "0.25$";
            priceNum = 0.25;
        }
        
        else if ((tempNum >= 50) && (tempNum <= 60)){
            price = "0.20$";
            priceNum = 0.20;
        }
        
        else if (tempNum < 50){
            price = "0$";
            priceNum = 0.0;
        }
        
        showPrice.setText(price);
        }
        if (numberOfDays == 0){
            int response;
            response = JOptionPane.showConfirmDialog(null, "You've run out of days, you're score was " + moneyNum + "$", "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.OK_OPTION){
                System.exit(0);
            }
        }
    }
    private void startEndDayButtonActionPerformed(ActionEvent e){
        peopleNum = myRandom.nextInt(60) + 1;
        numOfPeople.setText(peopleNum + " people");
        
        profits = priceNum * peopleNum;
        piggybank = profits + piggybank;
        moneyNum = new DecimalFormat("0.00").format(piggybank);
        totalProfits.setText(moneyNum + "$");
        
        String totalMoneyEarned = new DecimalFormat("0.00").format(profits);
        totalMoneyMade.setText(totalMoneyEarned);
    }
}
