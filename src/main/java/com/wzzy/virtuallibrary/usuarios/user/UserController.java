package com.wzzy.virtuallibrary.usuarios.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/login")
    public String login() {
        return "login"; // Certifique-se de que você tem uma visão chamada "login"
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Certifique-se de que você tem uma visão chamada "register"
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
