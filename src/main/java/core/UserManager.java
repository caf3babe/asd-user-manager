package core;

import models.User;
import repository.UserRepository;
import ui.Password;

import java.util.ArrayList;

public class UserManager {
    private int loginTries = 0;
    private User loggedInUser;
    private ArrayList<User> persistentUser;
    private UserRepository userRepository = new UserRepository();

    public UserManager(){
        this.persistentUser = userRepository.getAll();
    }

    public boolean checkIfUserNameExists(String userName){
        return this.persistentUser.stream().anyMatch(user -> user.getUsername().equals(userName));
    }

    public void registerUser(String username,String firstname, String lastname, char [] password){
           InputValidation.stringValidation(username);
           InputValidation.stringValidation(firstname);
           InputValidation.stringValidation(lastname);
           InputValidation.passwordValidation(password);
        if(this.checkIfUserNameExists(username)){
            throw new IllegalArgumentException("Username already exists");
        }else{
            User user = new User(username,firstname,lastname,password);
            userRepository.createUser(user);
        }
    }

    public void deleteAccount(User user){
       userRepository.deleteUser(user);
    }

    public void changePassword(User user){
        //TODO: implement logic
        userRepository.updateUser(user);
    }

    //TODO: refactoring -> outsource methods and change login to boolean
    //this login handels check + set current loggedInUser
    //TODO: missing window pane

    public void login(String username, char [] password){
        InputValidation.passwordValidation(password);
        String tempPassword = Password.verschluesseln(5,password).toString();
        User tempUser = userRepository.findUserByUserName(username);
        if(tempUser==null){
            throw new NullPointerException("No such user found");
        }else if(!tempUser.getPassword().equals(tempPassword)){
            throw new IllegalArgumentException("Password is not correct");
        }else{
            loggedInUser=tempUser;
            loggedInUser.setLoggedIn(true);
        }
    }

    //TODO: has to be a boolean method for ui-> on logout close window
    public void logout(){ this.loggedInUser.setLoggedIn(false); }


    public boolean isUserLoggedIn(){ return this.loggedInUser.isLoggedIn(); }
}
