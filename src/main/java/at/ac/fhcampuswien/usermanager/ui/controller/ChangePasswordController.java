package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.MainScreen;
import at.ac.fhcampuswien.usermanager.ui.NewPasswordScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordController implements ActionListener {

    private final UserManager userManager;
    private final MainScreen mainScreen;

    public ChangePasswordController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.userManager = mainScreen.getUserManager();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new NewPasswordScreen(this.userManager);
    }
}
