package at.ac.fhcampuswien.usermanager.ui;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.controller.SaveButtonController;
import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
public class NewPasswordScreen {

    private final JFrame frame;
    private final UserManager userManager;
    private JPasswordField passwordField;
    private JPasswordField passwordRepeatField;
    private JButton savePasswordButton;
    private JPanel newPassword;

    public NewPasswordScreen(UserManager userManager) {
        this.userManager = userManager;
        this.frame = new JFrame("User Manager - New Password");
        this.frame.setContentPane(newPassword);
        this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
        this.savePasswordButton.addActionListener(new SaveButtonController(this));
    }
}
