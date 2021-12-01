package core;

import models.User;
import repository.UserRepository;

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

    public boolean inputInvalid (String username,String firstname, String lastname, char [] password){
        if(username.isEmpty()||firstname.isEmpty()||lastname.isEmpty()||password.length==0){
            return true;
        }else if(username==null||firstname==null||lastname==null||password==null){
            return true;
        }else{
            return false;
        }
    }

    public void registerUser(String username,String firstname, String lastname, char [] password){
        if(inputInvalid(username,firstname, lastname,password)){
            throw new IllegalArgumentException("Invalid input!Try again:)");
        }else if(this.checkIfUserNameExists(username)){
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

    public void logout(){ this.loggedInUser.setLoggedIn(false); }


    public boolean isUserLoggedIn(){ return this.loggedInUser.isLoggedIn(); }
}
