package project_1.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import project_1.model.dto.UserDTO;
import project_1.services.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{email}")
    @ApiResponse(description = "Remove a user by email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUserByEmail(@PathVariable(value = "email") String email) {
        userService.removeUserByEmail(email);
    }

    @GetMapping("/email/{email}")
    @ApiResponse(description = "Show a user by email")
    public UserDTO getUserByEmail(@PathVariable(value = "email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{id}")
    @ApiResponse(description = "Show a user by id")
    public UserDTO getUserById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @ApiResponse(description = "Show a page of users")
    public Page<UserDTO> getUsers(String name, Pageable pageable){
        return userService.getUsersPage(name, pageable);
    }
}
