package ui;

import ui.controller.RegisterButtonController;

import javax.swing.*;
import java.util.ArrayList;

public class RegistrationScreen {

    private final JFrame frame;
    private final LoginScreen loginScreen;
    private JPanel registration;
    private JTextField vorname;
    private JTextField nachname;
    private JTextField username;
    private JPasswordField passwordFieldregi;
    private JButton registrierenButton;
    private JPasswordField passwordField1;
    private ArrayList students;

    public RegistrationScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        frame = new JFrame("User Manager - Registration");
        frame.setContentPane(registration);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        registrierenButton.addActionListener(new RegisterButtonController(this));
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

    public JTextField getVorname() {
        return vorname;
    }

    public void setVorname(JTextField vorname) {
        this.vorname = vorname;
    }

    public JTextField getNachname() {
        return nachname;
    }

    public void setNachname(JTextField nachname) {
        this.nachname = nachname;
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

    public JButton getRegistrierenButton() {
        return registrierenButton;
    }

    public void setRegistrierenButton(JButton registrierenButton) {
        this.registrierenButton = registrierenButton;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public ArrayList getStudents() {
        return students;
    }

    public void setStudents(ArrayList students) {
        this.students = students;
    }
}
