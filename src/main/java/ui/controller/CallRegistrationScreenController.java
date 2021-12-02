package ui.controller;

import ui.LoginScreen;
import ui.RegistrationScreen;

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
