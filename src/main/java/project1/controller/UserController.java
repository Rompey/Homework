package project1.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project1.dto.UserDTO;
import project1.dto.UserFilterDTO;
import project1.services.UserService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiResponse(description = "Show all users")
    public List<UserDTO> getUsers(UserFilterDTO userFilterDTO) {
        return userService.getUsers(userFilterDTO);
    }

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

    @PostMapping
    @ApiResponse(description = "Add a new user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/page")
    @ApiResponse(description = "Show a page of users filtered by name")
    public Page<UserDTO> getUsersByName(@RequestParam(required = false) String name,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "6") int size){
        return userService.getUsersByName(name, page, size);
    }

    @GetMapping("/country")
    public List<UserDTO> getUsersByCountry(){
        return userService.getUsersByCountry();
    }
}
