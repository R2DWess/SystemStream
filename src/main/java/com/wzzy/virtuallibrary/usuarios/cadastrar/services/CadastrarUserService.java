package com.wzzy.virtuallibrary.usuarios.cadastrar.services;

import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtuallibrary.usuarios.cadastrar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CadastrarUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsBySocialname(String socialname) {
        return userRepository.existsBySocialname(socialname);
    }

    public CadastrarUserModel save(CadastrarUserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<CadastrarUserModel> findAll() {
        return userRepository.findAll();
    }

    public Optional<CadastrarUserModel> findById(UUID id) {
        return userRepository.findById(id);
    }

    public void delete(CadastrarUserModel user) {
        userRepository.delete(user);
    }
}
