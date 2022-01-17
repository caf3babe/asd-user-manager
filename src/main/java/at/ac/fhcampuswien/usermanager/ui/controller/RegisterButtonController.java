package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.RegistrationScreen;
import org.springframework.beans.factory.annotation.Configurable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Configurable
public class RegisterButtonController implements ActionListener {

    private final RegistrationScreen registrationScreen;
    private final UserManager userManager;

    public RegisterButtonController(RegistrationScreen registration) {
        this.registrationScreen = registration;
        this.userManager = registration.getUserManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.registrationScreen.getUsername().getText();
        String firstName = this.registrationScreen.getFirstName().getText();
        String lastName = this.registrationScreen.getLastName().getText();
        String password = String.valueOf(this.registrationScreen.getPasswordField().getPassword());
        String repeatedPassword = String.valueOf(this.registrationScreen.getPasswordRepeatField().getPassword());
        try{
            userManager.registerUser(username, firstName, lastName, password, repeatedPassword);
            this.registrationScreen.getFrame().dispose();
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this.registrationScreen.getFrame(), ex.getMessage());
        }

    }
}
