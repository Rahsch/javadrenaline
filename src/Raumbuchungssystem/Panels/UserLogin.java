package Raumbuchungssystem.Panels;

import Raumbuchungssystem.Datenbanken.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame implements ActionListener{

    private Container c;
    private JLabel title;
    private JLabel userName;
    private JLabel userPass;
    private JTextField userNameField;
    private JTextField userPassField;
    private JLabel loginExecution;
    private JButton loginButton;
    private JButton cancelButton;
    private JButton bookingPage;

    public String checkUsername = "user";
    public String checkPassword = "pass";

    public UserLogin(){

        setTitle("Login Panel");
        setBounds(300, 90, 400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Creates a title for the login page
        title = new JLabel("Please Enter Your Information");
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        title.setSize(250, 25);
        title.setLocation(80, 10);
        c.add(title);

        // creates a label for the user name
        userName = new JLabel("username: ");
        userName.setFont(new Font("Arial", Font.PLAIN, 20));
        userName.setSize(100, 20);
        userName.setLocation(50, 50);
        c.add(userName);

        // creates a field for user to enter (username)
        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        userNameField.setSize(190, 20);
        userNameField.setLocation(150, 50);
        c.add(userNameField);

        // creates a label for the user Password
        userPass = new JLabel("password: ");
        userPass.setFont(new Font("Arial", Font.PLAIN, 20));
        userPass.setSize(100, 20);
        userPass.setLocation(50, 100);
        c.add(userPass);

        // creates a field for user to enter Password
        userPassField = new JTextField();
        userPassField.setFont(new Font("Arial", Font.PLAIN, 15));
        userPassField.setSize(190, 20);
        userPassField.setLocation(150, 100);
        c.add(userPassField);

        loginExecution = new JLabel("waiting...");
        loginExecution.setFont(new Font("Arial", Font.PLAIN, 15));
        loginExecution.setSize(250, 25);
        loginExecution.setLocation(50, 220);
        c.add(loginExecution);

        // creates a button for login command input
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        loginButton.setSize(90, 20);
        loginButton.setLocation(100, 150);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        c.add(loginButton);

        // cancels the login process and exit the panel
        cancelButton = new JButton("Exit");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 15));
        cancelButton.setSize(90, 20);
        cancelButton.setLocation(200, 150);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        c.add(cancelButton);

        // after the login a validated this button allows the user to Room Booking page
        bookingPage = new JButton("To Room Booking Page");
        bookingPage.setFont(new Font("Arial", Font.PLAIN, 15));
        bookingPage.setSize(190, 20);
        bookingPage.setLocation(100, 180);
        bookingPage.setFocusable(false);
        bookingPage.addActionListener(this);
        c.add(bookingPage);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource() == loginButton) {

            String str1 = userNameField.getText();
            String str2 = userPassField.getText();
            if ( str1.equals(checkUsername) && str2.equals(checkPassword) ) {
                loginExecution.setText("Login successful !");
            } else {
                loginExecution.setText("! wrong username or password !");
            }
        }

        else if(e.getSource() == cancelButton){
            dispose();
        }
    }
}

