package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import at.ac.fhcampuswien.usermanager.utils.InputValidation;
import at.ac.fhcampuswien.usermanager.utils.PasswordHandling;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

    private static final int MAX_LOGIN_TRIES = 3;
    private static final int INITIAL_LOGIN_TRIES = 0;

    @Getter private int loginTries;
    private User loggedInUser;

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.loginTries = INITIAL_LOGIN_TRIES;
        this.loggedInUser = null;
    }

    public boolean doesUserExistWithUserName(String userName) {
        return this.userRepository.existsByUsernameEqualsIgnoreCase(userName);
    }

    public User getUserIfExists(String username) throws UserNotFoundException {
        return this.userRepository
                .getByUsernameEqualsIgnoreCase(username)
                .orElseThrow(
                        () -> new UserNotFoundException("Could not find user in database")
                );
    }

    public void registerUser(String username, String firstname, String lastname, String password, String repeatedPassword) throws IllegalArgumentException {
        InputValidation.isEmpty(username);
        InputValidation.isEmpty(firstname);
        InputValidation.isEmpty(lastname);
        InputValidation.compareStrings(password, repeatedPassword);
        if (this.doesUserExistWithUserName(username)) {
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
        User user = this.getUserIfExists(username);
        if (loginTries <= MAX_LOGIN_TRIES) {
            if (!PasswordHandling.checkPassword(password, user.getPassword())) {
                loginTries++;
                throw new IllegalArgumentException("Password is not correct. "+loginTries+" tries remaining.");
            } else {
                loginTries=0;
                loggedInUser = user;
            }
        }
    }

    public void logout() {
        this.loggedInUser = null;
    }

    public User getCurrentUser() throws UserNotFoundException {
        if (isUserLoggedIn()) {
            return this.loggedInUser;
        } else {
            throw new UserNotFoundException("User is not logged in");
        }
    }

    public boolean isUserLoggedIn() {
        return this.loggedInUser != null;
    }
}
