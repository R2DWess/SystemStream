package com.wzzy.virtuallibrary.usuarios.cadastrar.repository;

import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CadastrarUserRepository extends JpaRepository<CadastrarUserModel, UUID> {
    CadastrarUserModel findByEmail(String email);
    boolean existsByEmail(String email);
}
