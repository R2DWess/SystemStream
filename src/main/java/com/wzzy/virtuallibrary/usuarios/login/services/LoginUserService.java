package com.wzzy.virtuallibrary.usuarios.login.services;

import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtuallibrary.usuarios.cadastrar.repository.CadastrarUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {

    @Autowired
    private CadastrarUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validateLogin(String email, String password) {
        CadastrarUserModel user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        return passwordEncoder.matches(password, user.getPassword());
    }

    public boolean cadastrarUser(CadastrarUserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
