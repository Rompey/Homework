package project1.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import project1.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE email=?", nativeQuery = true)
    User findUserByEmail(String email);

    User findUserById(Integer id);

    Page<User> findUsersByName(String name, Pageable pageable);
}
