package project1.services;

import org.springframework.data.domain.Page;
import project1.dto.UserDTO;
import project1.dto.UserFilterDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserByEmail(String email);
    UserDTO getUserById(Integer id);
    void removeUserByEmail(String email);
    List<UserDTO> getUsers(UserFilterDTO userFilterDTO);
    UserDTO saveUser(UserDTO userDTO);
    Page<UserDTO> getUsersByName(String name, int page, int size);
    List<UserDTO> getUsersByCountry();//
}
