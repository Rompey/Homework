package project1.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project1.domain.User;
import project1.dto.UserDTO;
import project1.dto.UserFilterDTO;
import project1.mapping.PageDtoToEntityMapper;
import project1.mapping.UserMapper;
import project1.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserDTO> getUsers(UserFilterDTO userFilterDTO) {
        List<User> users;
        if(userFilterDTO.getSearchName() != null){
            users = userRepository.findUsersByName(userFilterDTO.getSearchName());
        } else {
            users = userRepository.findAll();
        }
        return users.stream()
                .map(UserMapper.MAPPER::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User save = userRepository.save(UserMapper.MAPPER.map(userDTO));
        return UserMapper.MAPPER.map(save);
    }

    @Override
    public Page<UserDTO> getUsersByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findUsersByNameContaining(name, pageable);
        return PageDtoToEntityMapper.PAGE_DTO_TO_ENTITY_MAPPER.toRest(users);
    }
}
