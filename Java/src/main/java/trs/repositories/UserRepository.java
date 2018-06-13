package trs.repositories;

import trs.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by its name
     * @param name the name of the user
     * @return a user object
     */
    User findUserByName(String name);
}
