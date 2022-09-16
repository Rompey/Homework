package project1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1, Timestamp.from(Instant.now()), "Anton", "anton@gmail.com"));
        users.add(new User(2, Timestamp.from(Instant.now()), "Anton", "anton@gmail.com"));
        users.add(new User(3, Timestamp.from(Instant.now()), "Anton", "anton@gmail.com"));
        users.add(new User(4, Timestamp.from(Instant.now()), "Anton", "anton@gmail.com"));
        users.add(new User(5, Timestamp.from(Instant.now()), "Anton", "anton@gmail.com"));

        userRepository.saveAll(users);
        Collection<UserDTO> serviceUsers = userService.getUsers();
        System.out.println(serviceUsers.size());
    }
}