package project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findUserByEmail() {
        String email ="anton@gmail.com";
        User user = new User();
        user.setEmail(email);

        userRepository.save(user);
        User userByEmail = userRepository.findUserByEmail(email);

        Assertions.assertNotNull(userByEmail);
        Assertions.assertEquals(email, userByEmail.getEmail());
    }
}