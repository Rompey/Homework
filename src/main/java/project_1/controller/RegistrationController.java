package project_1.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project_1.model.dto.UserCreateDTO;
import project_1.model.dto.UserDTO;
import project_1.services.RegistrationService;

import java.net.URI;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    @ApiResponse(description = "Add a new user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        UserDTO userDTO = registrationService.saveUser(userCreateDTO);
        URI location = URI.create("/registration");
        return ResponseEntity.created(location).body(userDTO);
    }
}
