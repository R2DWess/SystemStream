package com.wzzy.virtuallibrary.usuarios.login.services;

import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtuallibrary.usuarios.login.model.LoginUserModel;
import com.wzzy.virtuallibrary.usuarios.login.repository.LoginUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginUserService {

    final
    LoginUserRepository loginUserRepository;

    public LoginUserService(LoginUserRepository loginUserRepository){
        this.loginUserRepository = loginUserRepository;
    }

    @Transactional
    public LoginUserModel save(LoginUserModel loginUserModel) {
        return loginUserRepository.save(loginUserModel);
    }

    public boolean existsByCpf(String cpf){
        return loginUserRepository.existsByCpf(cpf);
    }
    public List<LoginUserModel> findAll() {
        return loginUserRepository.findAll();
    }

    public Optional<LoginUserModel> findById(UUID id) {
        return loginUserRepository.findById(id);
    }

    public boolean existsByEmail(String email){
        return loginUserRepository.existsByEmail(email);
    }

    public boolean existsBySocialname(String socialname){
        return loginUserRepository.existsBySocialname(socialname);
    }
    @Transactional
    public void delete(LoginUserModel parkingSpotModel) {
        loginUserRepository.delete(parkingSpotModel);
    }

    public boolean validateLogin(String email, String password) {
        Optional<LoginUserModel> user = loginUserRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getPassword().equals(password);
        }
        return false;
    }

    @Transactional
    public boolean cadastrarUser(CadastrarUserModel newUser) {
        if (!existsByEmail(newUser.getEmail()) && !existsByCpf(newUser.getCpf())) {
            LoginUserModel loginUserModel = new LoginUserModel();
            BeanUtils.copyProperties(newUser, loginUserModel);
            save(loginUserModel);
            return true;
        }
        return false;
    }
}