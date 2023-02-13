package project_1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_1.model.User;
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

        return new UserDTO(save.getUsername(), save.getEmail());
    }

    private User buildUser(UserCreateDTO userCreateDTO) {
        return User.builder()
                .username(userCreateDTO.username())
                .password(ArgonUtil.encode(userCreateDTO.password()))
                .email(userCreateDTO.email())
                .build();
    }
}
