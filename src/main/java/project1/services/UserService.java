package project1.services;

import project1.dto.UserDTO;
import project1.dto.UserFilterDTO;

public interface UserService {
    UserDTO getUserByEmail(String email);
    UserDTO getUserById(Integer id);
    void removeUserByEmail(String email);
    Iterable<UserDTO> getUsers(UserFilterDTO userFilterDTO, int page, int size);
    UserDTO saveUser(UserDTO userDTO);
}
