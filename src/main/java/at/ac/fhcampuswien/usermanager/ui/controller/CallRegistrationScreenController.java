package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import at.ac.fhcampuswien.usermanager.ui.RegistrationScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CallRegistrationScreenController implements ActionListener {
    private final LoginScreen loginScreen;

    public CallRegistrationScreenController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new RegistrationScreen(this.loginScreen);
    }
}
