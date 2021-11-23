package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPassord {
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton saverPasswordButton;
    private JPanel newPassword;

    public NewPassord() {
        saverPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
    public static void SavePasswordScreen() {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new NewPassord().newPassword);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
