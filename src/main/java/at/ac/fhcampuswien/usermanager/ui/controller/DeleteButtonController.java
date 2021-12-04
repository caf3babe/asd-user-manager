package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.ui.MainScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonController implements ActionListener {

    private final MainScreen mainScreen;

    public DeleteButtonController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] options = {"Yes", "No"};
        int x = JOptionPane.showOptionDialog(null, "Your account will be permanently deleted. Continue?",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0){
            this.mainScreen.getUsers().remove(0);
            this.mainScreen.getFrame().dispose();
        }

    }
}
