package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class NewPassord {
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton saverPasswordButton;
    private JPanel newPassword;

    public NewPassord(ArrayList students, int i, JFrame frame) {
        saverPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField1.getPassword().length== 0){
                    JOptionPane.showMessageDialog(null, "Alle falder besetzen");
                }else {
                    char[] password1 = passwordField1.getPassword();
                    char[] password2 = passwordField2.getPassword();

                    if (Arrays.equals(password1, password2)) {
                        ArrayList student = (ArrayList) students.get(i);
                        char[] savePassword = Password.verschluesseln(5, password1);
                        String str = new String(savePassword);
                        student.set(3, str);
                        frame.dispose();
                    }else {
                        JOptionPane.showMessageDialog(null, "Kennwörter nicht gleich");
                    }
                }


            }
        });
    }
    public static void SavePasswordScreen(ArrayList students, int i) {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new NewPassord(students, i,frame).newPassword);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
