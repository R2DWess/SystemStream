package com.wzzy.virtualmovies.movie;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

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
    private Integer metascore;
    private String videoUrl;
    private String category;
}
