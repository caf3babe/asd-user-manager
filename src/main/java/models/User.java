package models;

import utils.PasswordHandling;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean loggedIn;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
