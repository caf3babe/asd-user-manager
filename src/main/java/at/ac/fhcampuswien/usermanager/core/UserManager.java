package at.ac.fhcampuswien.usermanager.core;

import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import at.ac.fhcampuswien.usermanager.models.User;
import at.ac.fhcampuswien.usermanager.repositories.UserRepository;
import at.ac.fhcampuswien.usermanager.utils.InputValidation;
import at.ac.fhcampuswien.usermanager.utils.PasswordHandling;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    private int loginTries = 3;
    private UserRepository userRepository;
    private User loggedInUser;

    private UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkIfUserNameExists(String userName) {
        return this.userRepository.existsByUsernameEqualsIgnoreCase(userName);
    }

    public User getUserIfExists(String username) throws UserNotFoundException {
        return this.userRepository.getByUsernameEqualsIgnoreCase(username).orElseThrow(() -> new UserNotFoundException("Could not find user in database"));
    }

    public void registerUser(String username, String firstname, String lastname, String password, String repeatedPassword) {
        InputValidation.stringValidation(username);
        InputValidation.stringValidation(firstname);
        InputValidation.stringValidation(lastname);
        InputValidation.compareStrings(password, repeatedPassword);
        if (this.checkIfUserNameExists(username)) {
            throw new IllegalArgumentException("Username already exists");
        } else {

            User user = new User(username, firstname, lastname, password);
            userRepository.save(user);
        }
    }

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

    public void login(String username, String password) {
        InputValidation.passwordValidation(password);
        User user = null;
        try {
            user = this.getUserIfExists(username);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        if (loginTries > 0) {
            if (!PasswordHandling.checkPassword(password, user.getPassword())) {
                loginTries--;
                throw new IllegalArgumentException("Password is not correct. "+loginTries+" tries remaining.");
            } else if(loginTries==0){
                //Reset value to 3, after 3 tries
                loginTries=3;
            } else {
                loginTries=3;
                loggedInUser = user;
            }
        }
    }

    public int getLoginTries() {
        return loginTries;
    }

    public void logout() {
        this.loggedInUser = null;
    }

    public User getCurrentUser() {
        if (isUserLoggedIn()) {
            return this.loggedInUser;
        } else {
            throw new NullPointerException("User is not logged in");
        }
    }

    public boolean isUserLoggedIn() {
        return this.loggedInUser != null;
    }

}
