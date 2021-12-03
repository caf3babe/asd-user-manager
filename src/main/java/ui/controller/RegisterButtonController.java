package ui.controller;

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

        ArrayList user = this.registrationScreen.getLoginScreen().getUsers();

        for(int i=0; i < user.size(); i++){
            System.out.println(user.get(i));
            ArrayList student = (ArrayList) user.get(i);
            if (student.get(2).equals(this.registrationScreen.getUsername().getText())){
                sameUser = true;
                JOptionPane.showMessageDialog(null, "Username is already in use.");
            }

        }
        if (this.registrationScreen.getFirstName().getText().isEmpty() || this.registrationScreen.getLastName().getText().isEmpty() || this.registrationScreen.getUsername().getText().isEmpty() || this.registrationScreen.getPasswordFieldregi().getPassword().length== 0){
            JOptionPane.showMessageDialog(null, "Please fill out every field.");
        }
        else {
            if (!sameUser){

                char[] password1 = this.registrationScreen.getPasswordFieldregi().getPassword();
                char[] password2 = this.registrationScreen.getPasswordField1().getPassword();

                if (Arrays.equals(password1, password2)) {
                    ArrayList myList = new ArrayList();
                    myList.add(this.registrationScreen.getFirstName().getText());
                    myList.add(this.registrationScreen.getLastName().getText());
                    myList.add(this.registrationScreen.getUsername().getText());
                    char[] savePassword = Password.verschluesseln(5, password1);
                    String str = new String(savePassword);
                    myList.add(str);
                    myList.add(0);
                    user.add(myList);
                    this.registrationScreen.getFrame().dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords are not equal. Please redo.");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Username is already in use.");
            }
        }
    }
}
