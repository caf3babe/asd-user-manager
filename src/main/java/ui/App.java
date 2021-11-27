package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class App {
    private JPanel mainPanel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton okButton;
    private JButton registrierenButton;
    public ArrayList students = new ArrayList();

    public App() {

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                if (students.size() == 0) {
                    JOptionPane.showMessageDialog(null, "username oder password nicht korrekt");

                } else {
                    for (int i = 0; i < students.size(); i++) {
                        ArrayList student = (ArrayList) students.get(i);
                        if (student.get(2).equals(userField.getText())) {

                            char[] save_pw = student.get(3).toString().toCharArray();
                            char[] save_pw_en = Password.entschluesseln(5, save_pw);
                            if (Arrays.equals(password, save_pw_en)) {
                                Acc.AccnScreen(students, i);
                            } else {
                                Integer num = (Integer) student.get(4);
                                if (num < 3) {
                                    num++;
                                    student.set(4, num);
                                }
                                JOptionPane.showMessageDialog(null, "username oder password nicht korrekt");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "username oder password nicht korrekt");
                        }
                    }
                }
            }
        });
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration.RegistrationScreen(students);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
