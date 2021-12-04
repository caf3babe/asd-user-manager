package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import at.ac.fhcampuswien.usermanager.ui.MainScreen;
import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import at.ac.fhcampuswien.usermanager.ui.Password;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginButtonController implements ActionListener {
    private final LoginScreen loginScreen;
    private final UserManager userManager;

    public LoginButtonController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        this.userManager = loginScreen.getUserManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.loginScreen.getUserField().getText();
        String password = String.valueOf(this.loginScreen.getPasswordField().getPassword());
        try{
            userManager.login(username, password);
            new MainScreen(this.userManager);
        } catch (IllegalArgumentException | UserNotFoundException ex) {
            JOptionPane.showMessageDialog(this.loginScreen.getFrame(), ex.getMessage());
        }

    }

    private void oldMethod() {
        char[] password = loginScreen.getPasswordField().getPassword();
        if (this.loginScreen.getUsers().size() == 0) {
            JOptionPane.showMessageDialog(null, "Wrong username or password.");

        } else {
            for (int i = 0; i < this.loginScreen.getUsers().size(); i++) {
                ArrayList user = (ArrayList) this.loginScreen.getUsers().get(i);
                if (user.get(2).equals(loginScreen.getUserField().getText())) {

                    char[] save_pw = user.get(3).toString().toCharArray();
                    char[] save_pw_en = Password.entschluesseln(5, save_pw);
                    if (Arrays.equals(password, save_pw_en)) {
                        //new MainScreen(this.loginScreen.getUsers());
                    } else {
                        Integer num = (Integer) user.get(4);
                        if (num < 3) {
                            num++;
                            user.set(4, num);
                        }
                        JOptionPane.showMessageDialog(null, "Wrong username or password.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password.");
                }
            }
        }
    }
}
