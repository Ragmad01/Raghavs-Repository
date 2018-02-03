/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
/**
 *
 * @author venra
 */
public class Savings extends JFrame {
//establish class level objects
JLabel depositLabel = new JLabel();
JLabel interestLabel = new JLabel();
JLabel monthsLabel = new JLabel();
JLabel finalLabel = new JLabel();
JTextField depositTextField = new JTextField();
JTextField interestTextField = new JTextField();
JTextField monthsTextField = new JTextField();
JTextField finalTextField = new JTextField();
JButton calculateButton = new JButton ();
JButton exitButton = new JButton();
    public static void main(String[] args) {
        //construct frame
        new Savings().show();
    }
    public Savings(){
        //code to build the form
        setTitle("Savings Account");
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                exitForm(e);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        
        //position controls (establis event methods)
        GridBagConstraints gridConstraints = new GridBagConstraints();
        depositLabel.setText("Monthly Deposit");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        getContentPane().add(depositLabel, gridConstraints);
        interestLabel.setText("Yearly Interest");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        getContentPane(). add(interestLabel, gridConstraints);
        monthsLabel.setText("Number of Months");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(monthsLabel, gridConstraints);
        finalLabel.setText("Final Balance");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane().add(finalLabel, gridConstraints);
        
        //textfields
        depositTextField.setText("");
        depositTextField.setColumns(10);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        getContentPane(). add(depositTextField, gridConstraints);
        interestTextField.setText("");
        interestTextField.setColumns(10);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        getContentPane().add(interestTextField, gridConstraints);
        monthsTextField.setText("");
        monthsTextField.setColumns(10);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        getContentPane().add(monthsTextField, gridConstraints);
        finalTextField.setText("");
        finalTextField.setColumns(10);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        getContentPane().add(finalTextField, gridConstraints);
        
        calculateButton.setText("Calculate");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        getContentPane().add(calculateButton, gridConstraints);
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calculateButtonActionPerformed(e);
            }
        });
        exitButton.setText("Exit");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                exitButtonActionPerformed(e);
            }
        });
        pack();
    }
    private void calculateButtonActionPerformed(ActionEvent e){
        double deposit;
        double interest;
        double months;
        double finalBalence;
        double monthlyInterest;
        //read valyes from text field
        deposit = Double.valueOf(depositTextField.getText()).doubleValue();
        interest = Double.valueOf(interestTextField.getText()).doubleValue();
        monthlyInterest = interest/1200;
        months = Double.valueOf(monthsTextField.getText()).doubleValue();
        //compute final value and put in text field
        finalBalence = deposit * (Math.pow((1 + monthlyInterest), months) - 1) / monthlyInterest;
        finalTextField.setText(new DecimalFormat("0.00").format(finalBalence));
    }
    private void exitButtonActionPerformed(ActionEvent e){
        System.exit(0);
    }
    private void exitForm(WindowEvent e){
        System.exit(0);
    }
}
