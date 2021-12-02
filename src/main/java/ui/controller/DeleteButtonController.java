package ui.controller;

import ui.MainScreen;

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
        String[] options = {"Ja", "Nein"};
        int x = JOptionPane.showOptionDialog(null, "Wollen Sie den Account wirklich löschen",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0){
            this.mainScreen.getUsers().remove(0);
            this.mainScreen.getFrame().dispose();
        }

    }
}
