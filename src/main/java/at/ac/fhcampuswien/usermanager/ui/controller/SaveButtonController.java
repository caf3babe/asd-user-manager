package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.ui.NewPasswordScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButtonController implements ActionListener {
    private final NewPasswordScreen newPassword;

    public SaveButtonController(NewPasswordScreen newPasswordScreen) {
        this.newPassword = newPasswordScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = String.valueOf(this.newPassword.getPasswordField().getPassword());
        String passwordRepeated = String.valueOf(this.newPassword.getPasswordRepeatField().getPassword());
        try{
            this.newPassword.getUserManager().changePassword(password, passwordRepeated);
            this.newPassword.getFrame().dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.newPassword.getFrame(), ex.getMessage());
        }

    }
}
