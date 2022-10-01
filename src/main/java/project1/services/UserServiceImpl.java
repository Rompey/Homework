package project1.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project1.domain.User;
import project1.dto.UserDTO;
import project1.dto.UserFilterDTO;
import project1.mapping.UserMapper;
import project1.repositories.UserRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public Iterable<UserDTO> getUsers(UserFilterDTO userFilterDTO, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Iterable<User> users;
        if(userFilterDTO.getSearchName() != null){
            users = userRepository.findUsersByName(userFilterDTO.getSearchName(), pageable);
        } else {
            users = userRepository.findAll();
        }
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserMapper.MAPPER::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User save = userRepository.save(UserMapper.MAPPER.map(userDTO));
        return UserMapper.MAPPER.map(save);
    }
}
