package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import at.ac.fhcampuswien.usermanager.ui.MainScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonController implements ActionListener {

    private final MainScreen mainScreen;
    private final UserManager userManager;

    public DeleteButtonController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.userManager = mainScreen.getUserManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] options = {"Yes", "No"};
        int x = JOptionPane.showOptionDialog(null, "Your account will be permanently deleted. Continue?",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0){
            try{
                userManager.deleteAccount();
                this.mainScreen.getFrame().dispose();
                new LoginScreen(this.userManager);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.mainScreen.getFrame(), ex.getMessage());
            }
        }
    }

}
