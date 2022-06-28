package Raumbuchungssystem.Panels;

import Raumbuchungssystem.Datenbanken.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller extends JFrame implements ActionListener{

    private Container c;
    private JLabel title;
    private JLabel command;
    private JButton loginCommandButton;
    private JButton registerCommandButton;
    private JButton closeProgramButton;

    public Controller() {

        setTitle("FH Room Booking System");
        setBounds(300, 90, 400, 200);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        c = getContentPane();
        c.setLayout(null);

        // creates the title for the main Controlling panel
        title = new JLabel("Welcome to FH Room Booking Panel");
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        title.setSize(300, 25);
        title.setLocation(40, 10);
        c.add(title);

        // comments the selected button's action
        command = new JLabel("waiting...");
        command.setFont(new Font("Arial", Font.PLAIN, 15));
        command.setSize(250, 25);
        command.setLocation(50, 180);
        c.add(command);

        // creates a button for initiating/opening login panel
        loginCommandButton = new JButton("Login");
        loginCommandButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginCommandButton.setSize(120, 30);
        loginCommandButton.setLocation(50, 80);
        loginCommandButton.setFocusable(false);
        loginCommandButton.addActionListener(this);
        c.add(loginCommandButton);

        // creates a button for initiating/opening the registration panel
        registerCommandButton = new JButton("Register");
        registerCommandButton.setFont(new Font("Arial", Font.PLAIN, 18));
        registerCommandButton.setSize(120, 30);
        registerCommandButton.setLocation(200, 80);
        registerCommandButton.setFocusable(false);
        registerCommandButton.addActionListener(this);
        c.add(registerCommandButton);

        // creates a button for closing the whole program
        closeProgramButton = new JButton("CLOSE PROGRAM");
        closeProgramButton.setFont(new Font("Arial", Font.PLAIN, 18));
        closeProgramButton.setSize(270, 30);
        closeProgramButton.setLocation(50, 120);
        closeProgramButton.setFocusable(false);
        closeProgramButton.addActionListener(this);
        c.add(closeProgramButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginCommandButton) {
            UserLogin login = new UserLogin();
        } else if(e.getSource() == registerCommandButton){
            Data_User_Input uInput = new Data_User_Input();
        }
        else if(e.getSource() == closeProgramButton){
            dispose();
        }
    }
}



