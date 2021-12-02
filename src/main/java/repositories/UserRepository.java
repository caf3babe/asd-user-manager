package repositories;

import models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> getByUsernameEqualsIgnoreCase(String username);

    public ArrayList<User> getAll();

    public User findUserByUsername(String username);

    public void createUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);
}
