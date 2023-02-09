package project_1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import project_1.model.User;
import project_1.model.dto.TokenDTO;
import project_1.model.dto.UserLoginDTO;
import project_1.repositories.UserRepository;
import project_1.util.ArgonUtil;
import project_1.util.TokenUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public TokenDTO createToken(UserLoginDTO userDTO) {
        User user = getUserIfCorrectLoginOrPassword(userDTO.getUsername(), userDTO.getPassword());
        String token = TokenUtil.generateToken(buildClaims(user), user.getUsername());

        return new TokenDTO(token, TokenUtil.expiredTime(token));
    }

    private Map<String, Object> buildClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        return claims;
    }

    private User getUserIfCorrectLoginOrPassword(String username, String password) {
        Optional<User> user = userRepository.findUserByUsername(username);

        user.ifPresent(u -> {
            boolean equals = ArgonUtil.matches(password, u.getPassword());
            if (!equals) {
                throw new AccessDeniedException("Password is incorrect");
            }
        });

        return user.orElseThrow(() -> new AccessDeniedException("Username is incorrect"));
    }
}
