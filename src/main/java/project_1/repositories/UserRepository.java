package project_1.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project_1.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserById(Integer id);

    Page<User> findUsersByUsernameContaining(String username, Pageable pageable);

    Optional<User> findUserByUsername(String username);
}
