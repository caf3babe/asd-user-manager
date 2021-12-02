package repositories;

import models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getByUsernameEqualsIgnoreCase(@NonNull String username);
    boolean existsByUsernameEqualsIgnoreCase(@NonNull String username);
}
