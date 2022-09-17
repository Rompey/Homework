package project1.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import project1.domain.User;
import project1.repositories.UserRepository;
import project1.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void removeUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        userRepository.delete(user);
    }

    @Override
    public void removeAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::getUserDTO)
                .collect(Collectors.toList());
    }

    @NotNull
    private UserDTO getUserDTO(User user) {
        return new UserDTO(
                user.getBirthday(),
                user.getName(),
                user.getEmail());
    }

    @Override
    public UserDTO saveUser(User user) {
        User save = userRepository.save(user);
        return getUserDTO(save);
    }
}
