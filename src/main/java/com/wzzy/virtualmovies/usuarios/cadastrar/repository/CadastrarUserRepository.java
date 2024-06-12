package com.wzzy.virtualmovies.usuarios.cadastrar.repository;

import com.wzzy.virtualmovies.usuarios.cadastrar.model.CadastrarUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CadastrarUserRepository extends JpaRepository<CadastrarUserModel, UUID> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsBySocialname(String socialname);
}
