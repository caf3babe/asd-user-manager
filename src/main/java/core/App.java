package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;




public class App {
    private JPanel mainPanel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton okButton;
    private JButton registrierenButton;
    private JPasswordField passwordFieldTest;

    public App() {

        okButton.addActionListener(new ActionListener() {
            int count_false_input = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.toString();
                char[] password = passwordField.getPassword();

                // todo: 1: Read DataBase if the user and password are correct
                // todo: 2: Encryption password


                // for Test passwordVerschluesselt
                char [] passwordVerschluesselt = verschluesseln(12, password);
                // todo:  user and password are correct // passwordentschluesseln
                char [] passwordentschluesselt = entschluesseln(12, passwordVerschluesselt);

                // todo: if another user set count_false_input == 0

                // test correctPass
                char[] correctPass = new char[] {'1', '2', '3'};
                if (Arrays.equals(password, correctPass)) {
                    System.out.println("Password is correct");
                    Acc.AccnScreen();
                } else {
                    System.out.println("Incorrect password");
                    count_false_input++;
                    JOptionPane.showMessageDialog(null, "username oder password nicht korrekt");
                    // todo: if user count_false_input == 3 schreibe die felleingaben in die DB wenn 3 sperre denn acc
                }
            }
        });
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Registration nw = new Registration();
                Registration.RegistrationScreen();

            }
        });
    }
    public static char[] verschluesseln(int offset, char[] charArray) {

        char[] cryptArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            int verschiebung = (charArray[i] + offset)%128;
            cryptArray[i] = (char) (verschiebung);
        }
        return cryptArray;

    }

    // hier die Methode zum entschlüsseln

    public static char[] entschluesseln(int offset, char[] charArray) {
        char[] cryptArray = new char[charArray.length];
        int verschiebung;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] - offset < 0)  verschiebung =
                    charArray[i] - offset + 128;
            else verschiebung = (charArray[i] - offset)%128;
            cryptArray[i] = (char) (verschiebung);
        }
        return cryptArray;

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
