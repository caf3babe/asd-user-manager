package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.ui.NewPasswordScreen;
import at.ac.fhcampuswien.usermanager.ui.Password;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveButtonController implements ActionListener {
    private final NewPasswordScreen newPassword;

    public SaveButtonController(NewPasswordScreen newPasswordScreen) {
        this.newPassword = newPasswordScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.newPassword.getPasswordField1().getPassword().length== 0){
            JOptionPane.showMessageDialog(null, "Please fill out every field.");
        }else {
            char[] password1 = this.newPassword.getPasswordField1().getPassword();
            char[] password2 = this.newPassword.getPasswordField2().getPassword();

            if (Arrays.equals(password1, password2)) {
                ArrayList student = (ArrayList) this.newPassword.getUsers().get(0);
                char[] savePassword = Password.verschluesseln(5, password1);
                String str = new String(savePassword);
                student.set(3, str);
                this.newPassword.getFrame().dispose();
            }else {
                JOptionPane.showMessageDialog(null, "Passwords are not equal. Please redo.");
            }
        }
    }
}
