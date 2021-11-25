package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Registration {


    private JPanel registration;
    private JTextField vorname;
    private JTextField nachname;
    private JTextField username;
    private JPasswordField passwordFieldregi;
    private JButton registrierenButton;
    private JPasswordField passwordField1;

    public Registration(ArrayList students, JFrame frame) {
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean sameUser = false;
                for(int i=0; i < students.size(); i++){
                    System.out.println(students.get(i));
                    ArrayList student = (ArrayList) students.get(i);
                    if (student.get(2).equals(username.getText())){
                        sameUser = true;
                        JOptionPane.showMessageDialog(null, "username ist bereits vergeben");
                    }

                }
                if (vorname.getText().isEmpty() || nachname.getText().isEmpty()||username.getText().isEmpty() ||passwordFieldregi.getPassword().length== 0){
                    JOptionPane.showMessageDialog(null, "Alle falder besetzen");
                }
                else {
                    if (!sameUser){

                        char[] password1 = passwordFieldregi.getPassword();
                        char[] password2 = passwordField1.getPassword();

                        if (Arrays.equals(password1, password2)) {
                            ArrayList myList = new ArrayList();
                            myList.add(vorname.getText());
                            myList.add(nachname.getText());
                            myList.add(username.getText());
                            char[] savePassword = Password.verschluesseln(5, password1);
                            String str = new String(savePassword);
                            myList.add(str);
                            myList.add(0);
                            students.add(myList);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "password ist nicht gleich");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "username ist bereits vergeben");
                    }
                }
            }
        });
    }
    public static void RegistrationScreen(ArrayList students) {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new Registration(students, frame).registration);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
