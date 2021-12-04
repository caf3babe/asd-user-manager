package at.ac.fhcampuswien.usermanager.ui;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.controller.CallRegistrationScreenController;
import at.ac.fhcampuswien.usermanager.ui.controller.LoginButtonController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
@Setter
public class LoginScreen {

    private ArrayList users;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private final UserManager userManager;

    public LoginScreen(UserManager userManager) {
        this.userManager = userManager;

        this.frame = new JFrame("User Manager - Login");
        this.frame.setContentPane(mainPanel);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.setLocationRelativeTo(this.frame);
        this.frame.setVisible(true);
        this.frame.pack();

        loginButton.addActionListener(new LoginButtonController(this));
        registerButton.addActionListener(new CallRegistrationScreenController(this));
    }
}
