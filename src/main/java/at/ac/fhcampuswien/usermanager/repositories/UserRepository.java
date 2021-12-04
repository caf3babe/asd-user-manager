package at.ac.fhcampuswien.usermanager.repositories;

import at.ac.fhcampuswien.usermanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByUsernameEqualsIgnoreCase(String username);
    boolean existsByUsernameEqualsIgnoreCase(String username);
}
