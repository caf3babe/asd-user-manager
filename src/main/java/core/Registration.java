package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration {


    private JPanel registration;
    private JTextField vorname;
    private JTextField nachname;
    private JTextField username;
    private JPasswordField passwordFieldregi;
    private JButton registrierenButton;

    public Registration() {
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void RegistrationScreen() {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new Registration().registration);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
