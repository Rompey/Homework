package project_1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_1.model.User;
import project_1.model.dto.AddressDTO;
import project_1.model.dto.UserCreateDTO;
import project_1.model.dto.UserDTO;
import project_1.repositories.UserRepository;
import project_1.util.ArgonUtil;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    @Transactional
    public UserDTO saveUser(UserCreateDTO userCreateDTO) {
        User save = userRepository.save(buildUser(userCreateDTO));

        return new UserDTO(save.getUsername(), save.getEmail(), new AddressDTO());
    }

    private User buildUser(UserCreateDTO userCreateDTO) {
        return User.builder()
                .username(userCreateDTO.getUsername())
                .password(ArgonUtil.encode(userCreateDTO.getPassword()))
                .email(userCreateDTO.getEmail())
                .build();
    }
}
