package core;

import models.User;
import repository.UserRepository;

import java.util.ArrayList;

public class UserManager {
    int loginTries = 0;
    User loggedInUser;
    ArrayList<User> persistentUser;

    public UserManager(){
        UserRepository userRepository = new UserRepository();
        this.persistentUser = userRepository.getAll();
    }

    public boolean checkIfUserNameExists(String userName){
        User user = new User();
        // TODO: implement logic
        return false;
    }

    public void registerUser(){
        // TODO: implement logic
    }

    public void deleteAccount(){
        // TODO: implement logic
    }

    public void changePassword(){
        //TODO: implement logic
    }

    public void logout(){
        //TODO: implement logic
    }

    public boolean isUserLoggedIn(){
        return this.loggedInUser != null;
    }
}
