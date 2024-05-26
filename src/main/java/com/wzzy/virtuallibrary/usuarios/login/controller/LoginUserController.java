package com.wzzy.virtuallibrary.usuarios.login.controller;

import com.wzzy.virtuallibrary.usuarios.login.services.LoginUserService;
import com.wzzy.virtuallibrary.usuarios.login.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginUserController {

    private final LoginUserService loginUserService;

    public LoginUserController(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        boolean isValid = loginUserService.validateLogin(loginRequest.getEmail(), loginRequest.getPassword());
        Map<String, String> response = new HashMap<>();
        if (isValid) {
            response.put("message", "Login efetuado com sucesso");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }
}
