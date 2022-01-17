package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import at.ac.fhcampuswien.usermanager.ui.MainScreen;
import at.ac.fhcampuswien.usermanager.ui.LoginScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonController implements ActionListener {
    private final LoginScreen loginScreen;
    private final UserManager userManager;

    public LoginButtonController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        this.userManager = loginScreen.getUserManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.loginScreen.getUserField().getText();
        String password = String.valueOf(this.loginScreen.getPasswordField().getPassword());
        try{
            userManager.login(username, password);
            this.loginScreen.getFrame().dispose();
            new MainScreen(this.userManager);
        } catch (IllegalArgumentException | UserNotFoundException ex) {
            JOptionPane.showMessageDialog(this.loginScreen.getFrame(), ex.getMessage());
        }

    }
}
