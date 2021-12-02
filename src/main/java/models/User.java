package models;

import core.PasswordHandling;
import ui.Password;

public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean loggedIn;

    public User(String username, String firstName, String lastName, String password){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password= PasswordHandling.hashPassword(password);
    }


    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) { this.password = PasswordHandling.hashPassword(password); }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
