package at.ac.fhcampuswien.usermanager.ui;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.controller.CallRegistrationScreenController;
import at.ac.fhcampuswien.usermanager.ui.controller.LoginButtonController;
import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
public class LoginScreen {

    private ArrayList users;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private final UserManager userManager;

    public LoginScreen(UserManager userManager) {
        this.userManager = userManager;
        this.users = new ArrayList();
        this.frame = new JFrame("User Manager - Login");
        this.frame.setContentPane(mainPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.pack();
        loginButton.addActionListener(new LoginButtonController(this));
        registerButton.addActionListener(new CallRegistrationScreenController(this));
    }

    public ArrayList getUsers() {
        return users;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}