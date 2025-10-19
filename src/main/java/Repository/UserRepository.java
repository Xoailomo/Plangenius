package Repository;

import User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // how does jpa works
    // what is optional
    Optional<User> findByEmail(String email);

}
