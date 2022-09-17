package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> new UserDTO(user.getId(), user.getBirthday(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
