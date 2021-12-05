package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import at.ac.fhcampuswien.usermanager.ui.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutButtonController implements ActionListener {
    private final MainScreen mainScreen;
    private final UserManager userManager;

    public LogoutButtonController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.userManager = mainScreen.getUserManager();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainScreen.getUserManager().logout();
        this.mainScreen.getFrame().dispose();
        new LoginScreen(this.userManager);
    }
}
