package com.wzzy.virtuallibrary.movie.repository;

import com.wzzy.virtuallibrary.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByCategory(String category);
    Movie findByTitulo(String titulo);
    Movie findAllBy();
}