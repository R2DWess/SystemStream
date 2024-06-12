package com.wzzy.virtualmovies.usuarios.cadastrar.model;

import com.wzzy.virtualmovies.movie.Movie;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_USERS_STREAM")
public class CadastrarUserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String fullname;

    @Column(length = 255)
    private String socialname;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(length = 255)
    private String rg;

    @Column(nullable = false, length = 255)
    private String cellphone;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @OneToMany
    private List<Movie> movieList;

    @OneToMany
    private List<Movie> favoriteMovies;
}
