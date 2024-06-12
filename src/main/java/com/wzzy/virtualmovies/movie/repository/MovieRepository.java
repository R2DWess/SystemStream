package com.wzzy.virtualmovies.movie.repository;

import com.wzzy.virtualmovies.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByCategory(String category);
    List<Movie> findByTitulo(String titulo);
    List<Movie> findByDiretor(String diretor);
    List<Movie> findByAno(int ano);
    List<Movie> findByGenero(String genero);
    List<Movie> findByMetascoreGreaterThan(int metascore);

}