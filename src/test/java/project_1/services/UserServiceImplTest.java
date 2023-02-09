package project_1.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project_1.model.User;
import project_1.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setUsername("Anton");
        String email = "anton@gmail.com";
        user.setEmail(email);

        userRepository.save(user);
        User userByEmail = userRepository.findUserByEmail(email);

        assertEquals(user.getUsername(), userByEmail.getUsername());
    }
}