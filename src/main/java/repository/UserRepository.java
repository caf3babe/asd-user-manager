package repository;

import models.User;

import java.util.ArrayList;

public class UserRepository {
    public ArrayList<User> getAll(){
        // TODO: get all User from database
        return new ArrayList<User>();
    }

    public User findUserByUserName(String username){
        //TODO:implement get User by username from database
        return null;
    }

    public boolean createUser(User user){
        // TODO: implement saving logic
        return false;
    }

    public boolean updateUser(User user){
        // TODO: implement update logic
        return false;
    }

    public boolean deleteUser(User user){
        // TODO: implement delete logic
        return false;
    }
}
