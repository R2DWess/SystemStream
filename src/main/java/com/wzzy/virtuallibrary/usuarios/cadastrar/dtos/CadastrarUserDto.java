package com.wzzy.virtuallibrary.usuarios.cadastrar.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CadastrarUserDto {

    private Long id;
    private String password;
    private String cpf;
    private String fullname;
    private String socialname;
    private LocalDate birthdate;
    private String rg;
    private String cellphone;
    private String email;
}