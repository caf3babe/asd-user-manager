package ui;

import ui.controller.SaveButtonController;

import javax.swing.*;
import java.util.ArrayList;

public class NewPasswordScreen {

    private final JFrame frame;
    private final ArrayList users;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton savePasswordButton;
    private JPanel newPassword;

    public NewPasswordScreen(ArrayList users, int i) {
        this.users = users;
        frame = new JFrame("User Manager - New Password");
        frame.setContentPane(newPassword);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        savePasswordButton.addActionListener(new SaveButtonController(this));
    }

    public JFrame getFrame() {
        return frame;
    }

    public ArrayList getUsers() {
        return users;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JPasswordField getPasswordField2() {
        return passwordField2;
    }

    public JButton getSavePasswordButton() {
        return savePasswordButton;
    }

    public JPanel getNewPassword() {
        return newPassword;
    }
}
