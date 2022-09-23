package project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project1.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email=?", nativeQuery = true)
    User findUserByEmail(String email);

    User findUserById(Integer id);

    List<User> findUsersByName(String name);
}
