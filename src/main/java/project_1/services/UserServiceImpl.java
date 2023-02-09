package project_1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project_1.mapping.PageMapper;
import project_1.mapping.UserMapper;
import project_1.model.User;
import project_1.model.dto.UserDTO;
import project_1.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return UserMapper.MAPPER.map(user);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findUserById(id);
        return UserMapper.MAPPER.map(user);
    }

    @Override
    public void removeUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        userRepository.delete(user);
    }

    @Override
    public Page<UserDTO> getUsersPage(String username, Pageable pageable) {
        Page<User> users = getUsers(username, pageable);
        return PageMapper.MAPPER.createMapping(users);
    }

    private Page<User> getUsers(String username, Pageable pageable) {
        if (username != null) {
            return userRepository.findUsersByUsernameContaining(username, pageable);
        }
        return userRepository.findAll(pageable);
    }
}
