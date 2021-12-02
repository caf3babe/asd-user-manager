package ui.controller;

import ui.MainScreen;
import ui.Password;
import ui.RegistrationScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterButtonController implements ActionListener {

    private final RegistrationScreen registrationScreen;

    public RegisterButtonController(RegistrationScreen registration) {
        this.registrationScreen = registration;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean sameUser = false;

        ArrayList students = this.registrationScreen.getLoginScreen().getUsers();

        for(int i=0; i < students.size(); i++){
            System.out.println(students.get(i));
            ArrayList student = (ArrayList) students.get(i);
            if (student.get(2).equals(this.registrationScreen.getUsername().getText())){
                sameUser = true;
                JOptionPane.showMessageDialog(null, "username ist bereits vergeben");
            }

        }
        if (this.registrationScreen.getVorname().getText().isEmpty() || this.registrationScreen.getNachname().getText().isEmpty() || this.registrationScreen.getUsername().getText().isEmpty() || this.registrationScreen.getPasswordFieldregi().getPassword().length== 0){
            JOptionPane.showMessageDialog(null, "Alle falder besetzen");
        }
        else {
            if (!sameUser){

                char[] password1 = this.registrationScreen.getPasswordFieldregi().getPassword();
                char[] password2 = this.registrationScreen.getPasswordField1().getPassword();

                if (Arrays.equals(password1, password2)) {
                    ArrayList myList = new ArrayList();
                    myList.add(this.registrationScreen.getVorname().getText());
                    myList.add(this.registrationScreen.getNachname().getText());
                    myList.add(this.registrationScreen.getUsername().getText());
                    char[] savePassword = Password.verschluesseln(5, password1);
                    String str = new String(savePassword);
                    myList.add(str);
                    myList.add(0);
                    students.add(myList);
                    this.registrationScreen.getFrame().dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "password ist nicht gleich");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "username ist bereits vergeben");
            }
        }
    }
}
