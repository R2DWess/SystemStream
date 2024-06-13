package com.wzzy.virtualmovies.movie;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
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
    private int metascore;
    private String videoUrl;
    private String category;
}
