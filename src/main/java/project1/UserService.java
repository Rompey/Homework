package project1;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    User getUserById(Integer id);
    void removeUserByEmail(String email);
    void removeAll();
    List<UserDTO> getUsers();
    UserDTO saveUser(User user);
}
