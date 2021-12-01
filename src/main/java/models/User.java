package models;

import ui.Password;

public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean loggedIn;

    public User(String username, String firstName, String lastName, char[] password){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password= new String(Password.verschluesseln(5,password));
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

    //TODO: muss man an der Stelle das entschlüsseln?--Ich würde es nicht machen.Ilona
    public String getPassword() {
        return this.password;
    }

    public void setPassword(char [] password) {
        this.password = new String(Password.verschluesseln(5,password));
    }

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
