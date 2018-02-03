/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author venra
 */
public class Password extends JFrame{
    JLabel passwordLabel = new JLabel();
    JPasswordField inputPasswordField = new JPasswordField();
    JButton validButton = new JButton();
    JButton exitButton = new JButton();
    int tryMax = 3;
    int tries;
    public static void main(String[] args) {
        //construct frame
        new Password().show();
    }
    
    public Password(){
        //code to build form
        setTitle("Password Validation");
        getContentPane().setBackground(Color.YELLOW);
        setResizable(false);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                exitForm(e);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        //position controls
        GridBagConstraints gridConstraints;
        passwordLabel.setText("Please Enter Your Password");
        passwordLabel.setOpaque(true);
        passwordLabel.setBackground(Color.white);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        passwordLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.ipadx = 30;
        gridConstraints.ipady = 20;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(5, 20, 5, 20);
        getContentPane(). add(passwordLabel, gridConstraints);
        
        inputPasswordField.setText("");
        inputPasswordField.setFont(new Font ("Arial", Font.PLAIN, 14));
        inputPasswordField.setColumns(15);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        getContentPane().add(inputPasswordField, gridConstraints);
        inputPasswordField.addActionListener (new ActionListener (){
            public void actionPerformed (ActionEvent e){
                inputPasswordFieldAcionPerformed(e);
            }
        });
        validButton.setText("Validate");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane ().add(validButton, gridConstraints);
        validButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                validButtonActionPerformed(e);
            }
        });
        exitButton.setText("Exit");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane ().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                exitButtonActionPerformed(e);
            }
        });
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
    }
    private void inputPasswordFieldAcionPerformed(ActionEvent e){
        validButton.doClick();
    }
    private void validButtonActionPerformed(ActionEvent e){
        final String THEPASSWORD = "LetMeIn";
        
        //This procedure  checks the input password
        int response;
        if (inputPasswordField.getText().equals(THEPASSWORD)){
            //if correct display message box
            JOptionPane.showConfirmDialog(null, "You've passed Security!", "Access Granted", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        else if(tryMax == 1){
            response = JOptionPane.showConfirmDialog(null, "You've run out of attempts, you will be forcefully exited now!", "NO TRIES", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
                exitButton.doClick();
            }
        }
        else{
            //If incorrect give error message
            tryMax = tryMax - 1;
            response = JOptionPane.showConfirmDialog(null,"Incorrect Password - Try Again? You have " + tryMax + " tries left!" , "Access Denied", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
                inputPasswordField.setText("");
                inputPasswordField.requestFocus();
            }
            else{
                exitButton.doClick();
            }
        }
    }
    private void exitButtonActionPerformed(ActionEvent e){
        System.exit(0);
    }
    private void exitForm (WindowEvent e){
        System.exit(0);
    }
    
}
