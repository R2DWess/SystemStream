package com.wzzy.virtualmovies.movie;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String titulo;
    private int ano;
    private int duracaoEmMinutos;

    @ElementCollection
    private List<String> genero;

    private String diretor;

    @ElementCollection
    private List<String> roteiristas;

    @ElementCollection
    private List<String> atores;

    private String poster;
    private int metascore;
    private String videoUrl;
    private String category;
}
