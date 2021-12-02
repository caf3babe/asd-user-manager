package core;

import models.User;
import repository.UserRepository;
import ui.Password;

import java.util.ArrayList;
import java.util.Optional;

public class UserManager {
    private int loginTries = 0;
    private User loggedInUser;
    private ArrayList<User> persistentUser;
    private UserRepository userRepository = new UserRepository();

    //TODO: Not sure we need a constructor here ?
    public UserManager() {
        this.persistentUser = userRepository.getAll();
    }

    public boolean checkIfUserNameExists(String userName) {
        return this.persistentUser.stream().anyMatch(user -> user.getUsername().equals(userName));
    }

    public User checkIfUserExists(String username) {
        User tempUser = this.persistentUser.stream().findFirst().filter(user -> user.getUsername().equals(username)).get();
        //User tempUser = userRepository.findUserByUserName(username);
        if (tempUser == null) {
            throw new NullPointerException("No user with this username found");
        } else {
            return tempUser;
        }
    }

    public void registerUser(String username, String firstname, String lastname, String password) {
        InputValidation.stringValidation(username);
        InputValidation.stringValidation(firstname);
        InputValidation.stringValidation(lastname);
        InputValidation.passwordValidation(password);
        if (this.checkIfUserNameExists(username)) {
            throw new IllegalArgumentException("Username already exists");
        } else {
            User user = new User(username, firstname, lastname, password);
            userRepository.createUser(user);
            this.persistentUser.add(user);
        }
    }


    //could be boolean as well
    public void deleteAccount(User user) {
        this.persistentUser.remove(user);
        userRepository.deleteUser(user);
    }

    public void changePassword(String newPassword, String repeadPassword) {
        if (InputValidation.compareStrings(newPassword, repeadPassword)) {
            loggedInUser.setPassword(PasswordHandling.hashPassword(newPassword));
            userRepository.updateUser(loggedInUser);
        } else {
            throw new IllegalArgumentException("Inputs invalid or do not match!");
        }

    }

    //TODO: refactoring -> outsource methods and change login to boolean
    //this login handels check + set current loggedInUser
    //TODO: missing window pane
    public void login(String username, String password) {
        InputValidation.passwordValidation(password);
        User user = checkIfUserExists(username);
        if (!PasswordHandling.checkPassword(password, user.getPassword())) {
            throw new IllegalArgumentException("Password is not correct");
        } else {
            loggedInUser = user;
            loggedInUser.setLoggedIn(true);
        }
    }

    //TODO: has to be a boolean method for ui-> on logout close window
    public void logout() {
        this.loggedInUser.setLoggedIn(false);
    }

    public User getCurrentUser(){
        if(isUserLoggedIn()){
            return this.loggedInUser;
        }else{
            throw new NullPointerException("User is not logged in");
        }
    }

    public boolean isUserLoggedIn() {
        return this.loggedInUser.isLoggedIn();
    }

}
