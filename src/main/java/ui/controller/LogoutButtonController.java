package ui.controller;

import ui.MainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutButtonController implements ActionListener {
    private final MainScreen mainScreen;

    public LogoutButtonController(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainScreen.getFrame().dispose();
    }
}
