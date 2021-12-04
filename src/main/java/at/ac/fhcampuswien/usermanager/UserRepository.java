package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getByUsernameEqualsIgnoreCase(String username);
    boolean existsByUsernameEqualsIgnoreCase(String username);
}
