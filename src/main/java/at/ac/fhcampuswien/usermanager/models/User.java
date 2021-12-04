package at.ac.fhcampuswien.usermanager.models;

import at.ac.fhcampuswien.usermanager.utils.PasswordHandling;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

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
