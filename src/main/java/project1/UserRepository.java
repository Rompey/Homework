package project1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email=?", nativeQuery = true)
    User findUserByEmail(String email);
    User findUserById(Integer id);
}
