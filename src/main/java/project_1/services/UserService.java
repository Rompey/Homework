package project_1.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project_1.model.dto.UserDTO;

public interface UserService {
    UserDTO getUserByEmail(String email);

    UserDTO getUserById(Integer id);

    void removeUserByEmail(String email);

    Page<UserDTO> getUsersPage(String username, Pageable pageable);
}
