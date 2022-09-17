package project1.services;

import project1.domain.User;
import project1.dto.UserDTO;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    User getUserById(Integer id);
    void removeUserByEmail(String email);
    void removeAll();
    List<UserDTO> getUsers();
    UserDTO saveUser(User user);
}
