package project_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project_1.model.dto.TokenDTO;
import project_1.model.dto.UserLoginDTO;
import project_1.services.LoginService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<TokenDTO> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        TokenDTO tokenDTO = loginService.createToken(userLoginDTO);
        return ResponseEntity.ok(tokenDTO);
    }
}
