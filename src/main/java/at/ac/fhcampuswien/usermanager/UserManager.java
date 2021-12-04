package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import at.ac.fhcampuswien.usermanager.utils.InputValidation;
import at.ac.fhcampuswien.usermanager.utils.PasswordHandling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserManager {

    private int loginTries = 3;
    private User loggedInUser;

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("UserManager was instantiated");
        this.userRepository.findAll().forEach(user -> {
            System.out.println(user);
        });
    }

    public boolean checkIfUserNameExists(String userName) {
        return this.userRepository.existsByUsernameEqualsIgnoreCase(userName);
    }

    public User getUserIfExists(String username) throws UserNotFoundException {
        return this.userRepository.getByUsernameEqualsIgnoreCase(username).orElseThrow(() -> new UserNotFoundException("Could not find user in database"));
    }

    public void registerUser(String username, String firstname, String lastname, String password, String repeatedPassword) throws IllegalArgumentException {
        InputValidation.stringValidation(username);
        InputValidation.stringValidation(firstname);
        InputValidation.stringValidation(lastname);
        InputValidation.compareStrings(password, repeatedPassword);
        if (this.checkIfUserNameExists(username)) {
            throw new IllegalArgumentException("Username already exists");
        } else {
            User user = new User(username, firstname, lastname, PasswordHandling.hashPassword(password));
            userRepository.save(user);
        }
    }

    public void deleteAccount() {
        userRepository.delete(this.loggedInUser);
    }

    public void changePassword(String newPassword, String repeatedPassword) throws IllegalArgumentException {
        if (InputValidation.compareStrings(newPassword, repeatedPassword)) {
            loggedInUser.setPassword(PasswordHandling.hashPassword(newPassword));
            this.userRepository.save(loggedInUser);
        } else {
            throw new IllegalArgumentException("Inputs invalid or do not match!");
        }
    }

    public void login(String username, String password) throws IllegalArgumentException, UserNotFoundException{
        InputValidation.passwordValidation(password);
        User user = this.getUserIfExists(username);
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

    public void logout() {
        this.loggedInUser = null;
    }

    public User getCurrentUser() throws NullPointerException {
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