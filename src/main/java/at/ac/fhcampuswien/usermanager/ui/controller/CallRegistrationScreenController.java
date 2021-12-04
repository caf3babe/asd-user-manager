package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import at.ac.fhcampuswien.usermanager.ui.RegistrationScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CallRegistrationScreenController implements ActionListener {
    private final LoginScreen loginScreen;
    private final UserManager userManager;

    public CallRegistrationScreenController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        this.userManager = loginScreen.getUserManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new RegistrationScreen(this.loginScreen, this.userManager);
    }
}
