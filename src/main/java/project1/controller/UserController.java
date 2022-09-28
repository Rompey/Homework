package project1.controller;

import lombok.AllArgsConstructor;
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
    public List<UserDTO> getUsers(UserFilterDTO userFilterDTO){
        return userService.getUsers(userFilterDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAll(){
        userService.removeAll();
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUserByEmail(@PathVariable(value = "email") String email){
        userService.removeUserByEmail(email);
    }

    @GetMapping("/email/{email}")
    public UserDTO getUserByEmail(@PathVariable(value = "email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable(value = "id") Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }
}
