package ui;

import ui.controller.RegisterButtonController;

import javax.swing.*;
import java.util.ArrayList;

public class RegistrationScreen {

    private final JFrame frame;
    private final LoginScreen loginScreen;
    private JPanel registration;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField username;
    private JPasswordField passwordFieldregi;
    private JButton registerButton;
    private JPasswordField passwordField1;
    private ArrayList user;

    public RegistrationScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        frame = new JFrame("User Manager - Registration");
        frame.setContentPane(registration);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        registerButton.addActionListener(new RegisterButtonController(this));
    }

    public JFrame getFrame() {
        return frame;
    }

    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public JPanel getRegistration() {
        return registration;
    }

    public void setRegistration(JPanel registration) {
        this.registration = registration;
    }

    public JTextField getFirstName() {
        return firstName;
    }

    public void setFirstName(JTextField firstName) {
        this.firstName = firstName;
    }

    public JTextField getLastName() {
        return lastName;
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JPasswordField getPasswordFieldregi() {
        return passwordFieldregi;
    }

    public void setPasswordFieldregi(JPasswordField passwordFieldregi) {
        this.passwordFieldregi = passwordFieldregi;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public ArrayList getUsers() {
        return user;
    }

    public void setStudents(ArrayList user) {
        this.user = user;
    }
}
