package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acc {
    private JLabel vorname;
    private JLabel nachname;
    private JLabel username;
    private JButton kennwortZuEandernButton;
    private JButton accountZuLoeschenButton;
    private JPanel acc;

    public Acc() {
        kennwortZuEandernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        kennwortZuEandernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewPassord.SavePasswordScreen();
            }
        });
        accountZuLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void AccnScreen() {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new Acc().acc);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
