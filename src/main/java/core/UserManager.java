package core;

import exceptions.UserNotFoundException;
import models.User;
import repositories.UserRepository;
import utils.InputValidation;
import utils.PasswordHandling;

public class UserManager {

    private static UserManager userManager;
    private final int loginTries = 0;
    private final UserRepository userRepository;
    private User loggedInUser;

    //TODO: Not sure we need a constructor here ?
    private UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean checkIfUserNameExists(String userName){
        return this.userRepository.existsByUsernameEqualsIgnoreCase(userName);
    }

    public User getUserIfExists(String username) throws UserNotFoundException {
        return this.userRepository.getByUsernameEqualsIgnoreCase(username).orElseThrow(() -> new UserNotFoundException("Could not find user in database"));
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
            userRepository.save(user);
        }
    }


    //could be boolean as well
    public void deleteAccount(User user) {
        userRepository.delete(user);
    }

    public void changePassword(String newPassword, String repeadPassword) {
        if (InputValidation.compareStrings(newPassword, repeadPassword)) {
            loggedInUser.setPassword(PasswordHandling.hashPassword(newPassword));
            this.userRepository.save(loggedInUser);
        } else {
            throw new IllegalArgumentException("Inputs invalid or do not match!");
        }

    }

    //TODO: refactoring -> outsource methods and change login to boolean
    //this login handels check + set current loggedInUser
    //TODO: missing window pane
    public void login(String username, String password) {
        InputValidation.passwordValidation(password);
        User user = null;
        try {
            user = this.getUserIfExists(username);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
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
