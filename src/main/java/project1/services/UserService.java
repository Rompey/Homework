package project1.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project1.dto.UserCreateDTO;
import project1.dto.UserDTO;

public interface UserService {
    UserDTO getUserByEmail(String email);

    UserDTO getUserById(Integer id);

    void removeUserByEmail(String email);

    UserCreateDTO saveUser(UserCreateDTO userDTO);

    Page<UserDTO> getUsersPage(String name, Pageable pageable);
}
