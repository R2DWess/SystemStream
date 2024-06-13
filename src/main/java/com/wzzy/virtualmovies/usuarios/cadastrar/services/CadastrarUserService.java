package com.wzzy.virtualmovies.usuarios.cadastrar.services;

import com.wzzy.virtualmovies.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtualmovies.usuarios.cadastrar.repository.CadastrarUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CadastrarUserService {

    final
    CadastrarUserRepository cadastrarUserRepository;

    public CadastrarUserService(CadastrarUserRepository cadastrarUserRepository){
        this.cadastrarUserRepository = cadastrarUserRepository;
    }

    @Transactional
    public CadastrarUserModel save(CadastrarUserModel cadastrarUserModel) {
        return cadastrarUserRepository.save(cadastrarUserModel);
    }

    public boolean existsByCpf(String cpf){
        return cadastrarUserRepository.existsByCpf(cpf);
    }
    public List<CadastrarUserModel> findAll() {
        return cadastrarUserRepository.findAll();
    }

    public Optional<CadastrarUserModel> findById(UUID id) {
        return cadastrarUserRepository.findById(id);
    }

    public boolean existsByEmail(String email){
        return cadastrarUserRepository.existsByEmail(email);
    }

    public boolean existsBySocialname(String socialname){
        return cadastrarUserRepository.existsBySocialname(socialname);
    }
    @Transactional
    public void delete(CadastrarUserModel userModel) {
        cadastrarUserRepository.delete(userModel);
    }

    public Optional<CadastrarUserModel> findBySocialname(String socialname) {
        return cadastrarUserRepository.findBySocialname(socialname);
    }

    @Transactional
    public boolean cadastrarUser(CadastrarUserModel newUser) {
        if (!existsByEmail(newUser.getEmail()) && !existsByCpf(newUser.getCpf())) {
            CadastrarUserModel cadastrarUserModel = new CadastrarUserModel();
            BeanUtils.copyProperties(newUser, cadastrarUserModel);
            try {
                save(cadastrarUserModel);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Erro ao cadastrar usuário", e);
            }
        }
        return false;
    }

}
