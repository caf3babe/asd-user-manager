package at.ac.fhcampuswien.usermanager;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getByUsernameEqualsIgnoreCase(String username);
    boolean existsByUsernameEqualsIgnoreCase(String username);
}
