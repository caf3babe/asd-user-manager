package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import at.ac.fhcampuswien.usermanager.ui.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutButtonController implements ActionListener {
    private final MainScreen mainScreen;

    public LogoutButtonController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainScreen.getUserManager().logout();
        this.mainScreen.getFrame().dispose();
    }
}
