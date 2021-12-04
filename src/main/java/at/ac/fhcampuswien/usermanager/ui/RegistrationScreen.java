package at.ac.fhcampuswien.usermanager.ui;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.controller.RegisterButtonController;
import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
public class RegistrationScreen {

    private final JFrame frame;
    private final LoginScreen loginScreen;
    private final UserManager userManager;
    private JPanel registration;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField username;
    private JButton registerButton;
    private JPasswordField passwordField;
    private JPasswordField passwordRepeatField;
    private ArrayList user;

    public RegistrationScreen(LoginScreen loginScreen, UserManager userManager) {
        this.userManager = userManager;
        this.loginScreen = loginScreen;
        frame = new JFrame("User Manager - Registration");
        frame.setContentPane(registration);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        registerButton.addActionListener(new RegisterButtonController(this));
    }

    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public void setRegistration(JPanel registration) {
        this.registration = registration;
    }

    public void setFirstName(JTextField firstName) {
        this.firstName = firstName;
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public void setPasswordRepeatField(JPasswordField passwordRepeatField) {
        this.passwordRepeatField = passwordRepeatField;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public void setStudents(ArrayList user) {
        this.user = user;
    }
}
