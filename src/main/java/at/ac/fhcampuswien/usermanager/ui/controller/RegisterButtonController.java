package at.ac.fhcampuswien.usermanager.ui.controller;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.Password;
import at.ac.fhcampuswien.usermanager.ui.RegistrationScreen;
import org.springframework.beans.factory.annotation.Configurable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

@Configurable
public class RegisterButtonController implements ActionListener {

    private final RegistrationScreen registrationScreen;
    private final UserManager userManager;

    public RegisterButtonController(RegistrationScreen registration) {
        this.registrationScreen = registration;
        this.userManager = registration.getUserManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.registrationScreen.getUsername().getText();
        String firstName = this.registrationScreen.getFirstName().getText();
        String lastName = this.registrationScreen.getLastName().getText();
        String password = String.valueOf(this.registrationScreen.getPasswordField().getPassword());
        String repeatedPassword = String.valueOf(this.registrationScreen.getPasswordRepeatField().getPassword());
        try{
            userManager.registerUser(username, firstName, lastName, password, repeatedPassword);
            this.registrationScreen.getFrame().dispose();
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this.registrationScreen.getFrame(), ex.getMessage());
        }

    }

    private void oldMethod() {
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
        if (this.registrationScreen.getFirstName().getText().isEmpty() || this.registrationScreen.getLastName().getText().isEmpty() || this.registrationScreen.getUsername().getText().isEmpty() || this.registrationScreen.getPasswordRepeatField().getPassword().length== 0){
            JOptionPane.showMessageDialog(null, "Please fill out every field.");
        }
        else {
            if (!sameUser){

                char[] password1 = this.registrationScreen.getPasswordRepeatField().getPassword();
                char[] password2 = this.registrationScreen.getPasswordField().getPassword();

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
