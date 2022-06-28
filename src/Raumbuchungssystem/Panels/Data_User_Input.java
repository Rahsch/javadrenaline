package Raumbuchungssystem.Panels;

import Raumbuchungssystem.Datenbanken.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Data_User_Input extends JFrame implements ActionListener {

    // Elements of the UI for User Registration
    private Container c;
    private JLabel title;
    private JLabel firstName;
    private JTextField uFirstName;
    private JLabel lastName;
    private JTextField uLastName;
    private JLabel id;
    private JTextField uID;
    private JLabel type;
    private JRadioButton teacher;
    private JRadioButton student;
    private ButtonGroup typeGroup;
    private JLabel email;
    private JTextField uEmail;
    private JLabel pass;
    private JTextField uPass;
    private JCheckBox checkInfo;
    private JButton signUp;
    private JButton reset;
    private JTextArea info;
    private JLabel res;
    private JTextArea resadd;
    private JButton loginPage;
    private JButton exitButton;

    // the constructor creates each elements of the User Registration UI
    public Data_User_Input() {
        setTitle("Registration");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Creates a title for the input page
        title = new JLabel("Please Enter Your Information");
        title.setFont(new Font("Arial", Font.PLAIN, 28));
        title.setSize(400, 30);
        title.setLocation(300, 30);
        c.add(title);

        // creates a label for the user first name input box
        firstName = new JLabel("First Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 20));
        firstName.setSize(100, 20);
        firstName.setLocation(100, 100);
        c.add(firstName);

        // creates a field for user to enter the first name
        uFirstName = new JTextField();
        uFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
        uFirstName.setSize(190, 20);
        uFirstName.setLocation(200, 100);
        c.add(uFirstName);

        // creates a label for the user last name input box
        lastName = new JLabel("Last Name");
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setSize(100, 20);
        lastName.setLocation(100, 150);
        c.add(lastName);

        // creates a field for user to enter the last name
        uLastName = new JTextField();
        uLastName.setFont(new Font("Arial", Font.PLAIN, 15));
        uLastName.setSize(190, 20);
        uLastName.setLocation(200, 150);
        c.add(uLastName);

        // creates a label for the user ID input box
        id = new JLabel("ID/Matr");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(100, 20);
        id.setLocation(100, 200);
        c.add(id);

        // creates a field for the user to enter the ID/matriculation number
        uID = new JTextField();
        uID.setFont(new Font("Arial", Font.PLAIN, 15));
        uID.setSize(150, 20);
        uID.setLocation(200, 200);
        c.add(uID);

        // creates a label for the user type/role area
        type = new JLabel("User Type");
        type.setFont(new Font("Arial", Font.PLAIN, 20));
        type.setSize(100, 20);
        type.setLocation(100, 250);
        c.add(type);

        // creates a button for the user to register as a teacher
        teacher = new JRadioButton("Teacher");
        teacher.setFont(new Font("Arial", Font.PLAIN, 15));
        teacher.setSelected(true);
        teacher.setSize(90, 20);
        teacher.setLocation(200, 250);
        c.add(teacher);

        // creates a label for the user to register as a student
        student = new JRadioButton("Student");
        student.setFont(new Font("Arial", Font.PLAIN, 15));
        student.setSelected(false);
        student.setSize(80, 20);
        student.setLocation(290, 250);
        c.add(student);

        // creates group for the (teacher/student) buttons
        typeGroup = new ButtonGroup();
        typeGroup.add(teacher);
        typeGroup.add(student);

        // creates a label for the user Email input box
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 300);
        c.add(email);

        // creates a field for the user to enter Email Address
        uEmail = new JTextField();
        uEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        uEmail.setSize(250, 20);
        uEmail.setLocation(200, 300);
        c.add(uEmail);

        // creates a label for the user Password input box
        pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setLocation(100, 350);
        c.add(pass);

        // creates a field for the user to enter Password
        uPass = new JTextField();
        uPass.setFont(new Font("Arial", Font.PLAIN, 15));
        uPass.setSize(250, 20);
        uPass.setLocation(200, 350);
        c.add(uPass);

        // reminds the user to recheck the given data
        checkInfo = new JCheckBox("All information is correct.");
        checkInfo.setFont(new Font("Arial", Font.PLAIN, 15));
        checkInfo.setSize(250, 20);
        checkInfo.setLocation(150, 400);
        c.add(checkInfo);

        // sign up the user: the user data gets stored in a (.txt) file as binary data
        signUp = new JButton("Sign up");
        signUp.setFont(new Font("Arial", Font.PLAIN, 15));
        signUp.setSize(90, 20);
        signUp.setLocation(100, 450);
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        c.add(signUp);

        // resets or clears all the boxes for user to put new data
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(90, 20);
        reset.setLocation(200, 450);
        reset.addActionListener(this);
        c.add(reset);

        // closes this specific input panel for user
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        exitButton.setSize(90, 20);
        exitButton.setLocation(300, 450);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        c.add(exitButton);

        loginPage = new JButton("To Login");
        loginPage.setFont(new Font("Arial", Font.PLAIN, 15));
        loginPage.setSize(300, 20);
        loginPage.setLocation(500, 450);
        loginPage.setFocusable(false);
        loginPage.addActionListener(this);
        c.add(loginPage);

        // the area where user sees what data is stored
        info = new JTextArea();
        info.setFont(new Font("Arial", Font.PLAIN, 15));
        info.setSize(300, 300);
        info.setLocation(500, 100);
        info.setLineWrap(true);
        info.setEditable(false);
        c.add(info);

        // warns if the check box in not checked
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {

            // the terms should be first accepted by the user
            if (checkInfo.isSelected()) {

                // shows if the user is a teacher or a student
                String str1;
                if (teacher.isSelected())
                    str1 = "User Type : Teacher " + "\n";
                else
                    str1 = "User Type : Student " + "\n";

                // gets the user data (Full name and ID/Matriculation No.)
                String str2 = "First Name : " + uFirstName.getText() + "\n"
                        + "Last Name :  " + uLastName.getText() + "\n"
                        + "ID No.  : " + uID.getText() + "\n";

                // gets the Email Address of the user
                String str3 = "Email : " + uEmail.getText();
                info.setText(str1 + str2 + str3);
                info.setEditable(false);
                res.setText("Registred Successfully!");

                UserData newUser = new UserData(
                        uID.getText(), uFirstName.getText(), uLastName.getText(), uEmail.getText(), uPass.getText());
                try {
                    newUser.toPutDataIn(newUser);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                info.setText("");
                resadd.setText("");
                res.setText("Please check the box (All information is correct).");
            }
        }

        // it will reset and clear all the data from their fields
        else if (e.getSource() == reset) {
            String def = "";
            uFirstName.setText(def);
            uLastName.setText(def);
            uEmail.setText(def);
            uID.setText(def);
            res.setText(def);
            info.setText(def);
            checkInfo.setSelected(false);
            resadd.setText(def);
        }

        else if(e.getSource() == exitButton){
            dispose();
        }
    }
}
