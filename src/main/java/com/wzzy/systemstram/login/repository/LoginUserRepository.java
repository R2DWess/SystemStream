package com.wzzy.systemstram.login.repository;

import com.wzzy.systemstram.login.model.LoginUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LoginUserRepository extends JpaRepository<LoginUserModel, UUID> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsBySocialname(String socialname);

    Optional<LoginUserModel> findByEmail(String email);

}