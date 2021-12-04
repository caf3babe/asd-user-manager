package at.ac.fhcampuswien.usermanager.ui;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.controller.RegisterButtonController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
@Setter
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

        this.frame = new JFrame("User Manager - Registration");
        this.frame.setContentPane(registration);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.setLocationRelativeTo(this.frame);
        this.frame.setVisible(true);
        this.frame.pack();

        registerButton.addActionListener(new RegisterButtonController(this));
    }
}
