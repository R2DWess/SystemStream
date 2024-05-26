package com.wzzy.virtuallibrary.usuarios.cadastrar.repository;

import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<CadastrarUserModel, UUID> {
    Optional<CadastrarUserModel> findByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsBySocialname(String socialname);
}
