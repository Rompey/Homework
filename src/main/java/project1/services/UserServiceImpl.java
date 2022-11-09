package project1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project1.domain.Address;
import project1.domain.User;
import project1.dto.UserCreateDTO;
import project1.dto.UserDTO;
import project1.mapping.PageMapper;
import project1.mapping.UserMapper;
import project1.repositories.AddressRepository;
import project1.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static project1.mapping.AddressMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

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

    @Transactional
    @Override
    public UserCreateDTO saveUser(UserCreateDTO userDTO) {
        if (userDTO.getAddress().getId() != null) {
            Optional<Address> byId = addressRepository.findById(userDTO.getAddress().getId());
            userDTO.setAddress(MAPPER.map(byId.orElseThrow(() -> new RuntimeException("Address doesn't exist"))));
        }

        User save = userRepository.saveAndFlush(UserMapper.MAPPER.createMapping(userDTO));
        return UserMapper.MAPPER.createMapping(save);
    }

    @Override
    public Page<UserDTO> getUsersPage(String name, Pageable pageable) {
        Page<User> users = getUsers(name, pageable);
        return PageMapper.MAPPER.createMapping(users);
    }

    private Page<User> getUsers(String name, Pageable pageable) {
        if (name != null) {
            return userRepository.findUsersByName(name, pageable);
        }
            return userRepository.findAll(pageable);
    }
}
