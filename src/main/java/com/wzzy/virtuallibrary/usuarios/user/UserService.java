package com.wzzy.virtuallibrary.usuarios.user;

import com.wzzy.virtuallibrary.usuarios.login.model.LoginUserModel;
import com.wzzy.virtuallibrary.usuarios.login.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginUserModel registerUser(LoginUserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return loginUserRepository.save(user);
    }
}
